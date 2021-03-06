package net.cis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cis.constants.ResponseErrorCodeConstants;
import net.cis.dto.ErrorDto;
import net.cis.dto.ResponseApi;
import net.cis.dto.TicketTransactionDto;
import net.cis.dto.TicketTransactionPortalDto;
import net.cis.dto.UpdateInvoiceDto;
import net.cis.jpa.entity.TicketTransactionEntity;
import net.cis.jpa.entity.TicketTransactionPortalEntity;
import net.cis.repository.TicketTransactionPortalReponsitory;
import net.cis.repository.TicketTransactionRepository;
import net.cis.service.TicketTransactionService;

/**
 * Created by Vincent on 02/10/2018
 */
@Service
public class TicketTransactionServiceImpl implements TicketTransactionService {

	@Autowired
	private TicketTransactionRepository ticketTransactionRepository;
	
	@Autowired
	private TicketTransactionPortalReponsitory ticketTransactionPortalRepository;

	
	
	ModelMapper mapper;
	
	@Override
	public TicketTransactionDto save(TicketTransactionDto ticketTransactionDto) {
		ModelMapper mapper = new ModelMapper();
		TicketTransactionEntity ticketTransactionEntity = new TicketTransactionEntity();
		mapper.map(ticketTransactionDto, ticketTransactionEntity);
		ticketTransactionEntity = ticketTransactionRepository.save(ticketTransactionEntity);
		mapper.map(ticketTransactionEntity, ticketTransactionDto);
		return ticketTransactionDto;
	}
	
	@Override
	public TicketTransactionDto findById(String id) {
		ModelMapper mapper = new ModelMapper();
		TicketTransactionEntity entity = ticketTransactionRepository.findOne(id);
		if(entity == null) {
			return null;
		}
		TicketTransactionDto ticketTransactionDto = new TicketTransactionDto();
		mapper.map(entity, ticketTransactionDto);
		return ticketTransactionDto;
	}
	
	
	@Override
	public TicketTransactionDto findByPaymentOrderNo(String paymentOrderNo) {
		ModelMapper mapper = new ModelMapper();
		TicketTransactionEntity entity = ticketTransactionRepository.findByPaymentOrderNo(paymentOrderNo);
		if(entity == null) {
			return null;
		}
		TicketTransactionDto ticketTransactionDto = new TicketTransactionDto();
		mapper.map(entity, ticketTransactionDto);
		return ticketTransactionDto;
	}


	@Override
	public List<TicketTransactionDto> findAll() {
		List<TicketTransactionEntity> ticketTransactionEntities = ticketTransactionRepository.findAll();
		List<TicketTransactionDto> ticketTransacitonDtos = this.map(ticketTransactionEntities);
		return ticketTransacitonDtos;
	}

	
	private List<TicketTransactionDto> map(List<TicketTransactionEntity> source) {
		
		ArrayList<TicketTransactionDto> rtn = new ArrayList<>();
		source.stream().map((entity) -> {
			TicketTransactionDto dto = new TicketTransactionDto();
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
	public void delete(TicketTransactionDto ticketTransactionDto) {
		if(ticketTransactionDto != null) {
			ticketTransactionRepository.delete(ticketTransactionDto.getId());
		}
	}

	
	public ResponseApi findByTicketId(Long ticketId) {
		ResponseApi responseApi = new ResponseApi();
		ErrorDto errorDto = new ErrorDto();

		List<TicketTransactionEntity> ticketTransactionsEntities = null;
		
		try {
			ticketTransactionsEntities = ticketTransactionRepository.findByTicketId(ticketId);
				if (ticketTransactionsEntities == null) {
					errorDto.setCode(ResponseErrorCodeConstants.StatusOK);
					errorDto.setMessage("");
					responseApi.setError(errorDto);
					return responseApi;
				}
				List<TicketTransactionDto> ticketTransacitonDtos = this.map(ticketTransactionsEntities);

				responseApi.setData(ticketTransacitonDtos);
				errorDto.setCode(ResponseErrorCodeConstants.StatusOK);
				errorDto.setMessage("");
				responseApi.setError(errorDto);
				return responseApi;
			
		}catch (Exception e) {
			errorDto.setCode(ResponseErrorCodeConstants.StatusInternalServerError);
			errorDto.setMessage(ResponseErrorCodeConstants.DBAccessErr);
			responseApi.setError(errorDto);
			return responseApi;
		}
	}

	@Override
	public ResponseApi getDetailPortal(String id) {
		// TODO Auto-generated method stub
		ResponseApi responseApi = new ResponseApi();
		ModelMapper mapper = new ModelMapper();
		ErrorDto errorDto = new ErrorDto();
		try {
			TicketTransactionPortalEntity entity = ticketTransactionPortalRepository.getDetailPortalById(id);
			if(entity == null) {
				errorDto.setCode(ResponseErrorCodeConstants.StatusOK);
				errorDto.setMessage("");
				responseApi.setError(errorDto);
				return responseApi;
			}
			TicketTransactionPortalDto ticketTransactionPortalDto = new TicketTransactionPortalDto();
			
			mapper.map(entity, ticketTransactionPortalDto);
			
			errorDto.setCode(ResponseErrorCodeConstants.StatusOK);
			errorDto.setMessage("");
			responseApi.setError(errorDto);
			responseApi.setData(ticketTransactionPortalDto);

			return responseApi;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return responseApi;
	}

	@Override
	public ResponseApi updateInvoice(UpdateInvoiceDto dto) {
		ResponseApi responseApi = new ResponseApi();
		ErrorDto errorDto = new ErrorDto();
		TicketTransactionEntity entity = ticketTransactionRepository.findByIdAndTicketId(dto.getTransactionId(), dto.getTicketId());
		
		if (entity != null) {
			// Update invoice code
			entity.setInvoiceCode(dto.getInvoiceCode());
			ticketTransactionRepository.save(entity);
			
			
			errorDto.setCode(200);
			errorDto.setMessage("");
			responseApi.setError(errorDto);
			responseApi.setData(entity);
			
			return responseApi;
		}
		return null;
	}

}
