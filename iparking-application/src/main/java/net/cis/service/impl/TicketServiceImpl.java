package net.cis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cis.dto.TicketDto;
import net.cis.jpa.entity.TicketEntity;
import net.cis.repository.iparking.center.TicketRepository;
import net.cis.service.TicketService;

/**
 * Created by Vincent on 02/10/2018
 */
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	

	ModelMapper mapper;
	
	@Override
	public TicketDto save(TicketDto ticketDto) {
		ModelMapper mapper = new ModelMapper();
		TicketEntity ticketEntity = new TicketEntity();
		mapper.map(ticketDto, ticketEntity);
		mapper.map(ticketRepository.save(ticketEntity), ticketDto);
		return ticketDto;
	}
	
	@Override
	public TicketDto findById(long id) {
		ModelMapper mapper = new ModelMapper();
		TicketEntity entity = ticketRepository.findOne(id);
		if(entity == null) {
			return null;
		}
		TicketDto ticketDto = new TicketDto();
		mapper.map(entity, ticketDto);
		return ticketDto;
	}


	@Override
	public List<TicketDto> findAll() {
		List<TicketEntity> ticketEntities = ticketRepository.findAll();
		List<TicketDto> ticketDtos = this.map(ticketEntities);
		return ticketDtos;
	}

	
	private List<TicketDto> map(List<TicketEntity> source) {
		
		ArrayList<TicketDto> rtn = new ArrayList<>();
		source.stream().map((entity) -> {
			TicketDto dto = new TicketDto();
			mapper.map(entity, dto);
			return dto;
		}).forEachOrdered((dto) -> {
			rtn.add(dto);
		});
		return rtn;
	}

	

	@PostConstruct
	public void initialize() {
		mapper = new ModelMapper();
	}


	@Override
	public void delete(TicketDto ticketDto) {
		if(ticketDto != null && ticketDto.getId() > 0) {
			ticketRepository.delete(ticketDto.getId());
		}
	}


}
