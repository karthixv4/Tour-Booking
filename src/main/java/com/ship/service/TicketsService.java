package com.ship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ship.model.Tickets;

import com.ship.repository.TicketsRepo;

@Service
public class TicketsService {

	@Autowired
	private TicketsRepo ticketsRepo;
	
	public void addTickets(Tickets tickets) {
		ticketsRepo.save(tickets);
	}
	public void removeTickets(Long id) {
		ticketsRepo.deleteById(id);
	}
	public List<Tickets> getTicketsByUser(String user){
		return ticketsRepo.findAll(user);
		}
	public List<Tickets> showAllTickets(){
		
		return ticketsRepo.findAll();
	}
}
