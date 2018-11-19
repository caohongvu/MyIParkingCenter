package net.cis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.cis.common.web.BaseEndpoint;
import net.cis.dto.TicketDto;
import net.cis.service.TicketService;

/**
 * Created by Vincent on 02/10/2018
 */
@RestController
@RequestMapping("/ticket")
@Api(value = "ticket Endpoint", description = "The URL to handle ticket endpoint")
public class TicketEndpoint extends BaseEndpoint {

	@Autowired
	TicketService ticketService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation("Fetch all ticket")
	public @ResponseBody List<TicketDto> fetchTickets() throws Exception {
		List<TicketDto> tickets = ticketService.findAll();
		return tickets;
	}
	
	@RequestMapping(value = "/{id}/find-by-id/", method = RequestMethod.GET)
	@ApiOperation("Fetch details of ticket")
	public @ResponseBody TicketDto getById(@PathVariable("id") Long id) throws Exception {
		TicketDto ticket = ticketService.findById(id);
		return ticket;
	}
	
	@RequestMapping(value = "/update/", method = RequestMethod.POST)
	@ApiOperation("Update details of ticket")
	public @ResponseBody TicketDto update(@RequestBody TicketDto ticketDto) throws Exception {
		TicketDto ticket = ticketService.save(ticketDto);
		return ticket;
	}
	
	@RequestMapping(value = "/create/", method = RequestMethod.POST)
	@ApiOperation("Create details of ticket")
	public @ResponseBody TicketDto create(@RequestBody TicketDto ticketDto) throws Exception {
		TicketDto ticket = ticketService.save(ticketDto);
		return ticket;
	}
	
	
}
