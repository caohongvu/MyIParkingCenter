package net.cis.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cis.dto.NotificationHistoryDto;
import net.cis.dto.UserDto;
import net.cis.jpa.entity.NotificationHistoryEntity;
import net.cis.repository.NotificationHistoryRepository;
import net.cis.service.NotificationHistoryService;
import net.cis.service.UserService;

@Service
public class NotificationHistoryServiceImpl implements NotificationHistoryService {
	@Autowired
	NotificationHistoryRepository notificationHistoryRepository;

	@Autowired
	UserService userService;

	ModelMapper mapper;

	@PostConstruct
	public void initialize() {
		mapper = new ModelMapper();
	}

	@Override
	public NotificationHistoryDto save(NotificationHistoryDto notificationHistoryDto) {
		NotificationHistoryEntity entity = new NotificationHistoryEntity();
		mapper.map(notificationHistoryDto, entity);
		mapper.map(notificationHistoryRepository.save(entity), notificationHistoryDto);
		return notificationHistoryDto;
	}

	@Override
	public List<NotificationHistoryDto> findAllByCreatedBy(long createdBy) {
		List<NotificationHistoryEntity> ticketEntities = null;
		ticketEntities = notificationHistoryRepository.findByCreatedBy(createdBy);
		List<NotificationHistoryDto> ticketDtos = this.map(ticketEntities, createdBy);
		return ticketDtos;
	}

	public List<NotificationHistoryDto> map(List<NotificationHistoryEntity> source, long createdBy) {
		UserDto objUserDto = userService.findUserById((int) createdBy);
		ArrayList<NotificationHistoryDto> rtn = new ArrayList<>();
		source.stream().map((entity) -> {
			NotificationHistoryDto dto = new NotificationHistoryDto();
			mapper.map(entity, dto);
			dto.setCreatedByFullName(objUserDto.getFullname());
			dto.setCreatedByUserName(objUserDto.getUsername());
			return dto;
		}).forEachOrdered((dto) -> {
			rtn.add(dto);
		});
		return rtn;
	}

	public List<NotificationHistoryDto> map(List<NotificationHistoryEntity> source) {
		ArrayList<NotificationHistoryDto> rtn = new ArrayList<>();
		source.stream().map((entity) -> {
			NotificationHistoryDto dto = new NotificationHistoryDto();
			mapper.map(entity, dto);
			return dto;
		}).forEachOrdered((dto) -> {
			rtn.add(dto);
		});
		return rtn;
	}

}
