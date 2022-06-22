package com.ship.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ship.model.Activities;
import com.ship.model.TempHold;
import com.ship.model.Tickets;
import com.ship.service.EventsService;
import com.ship.service.TicketsService;


@Controller
public class TicketsController {
	
	@Autowired
	private TicketsService ticketsService;
	
	@Autowired
	private EventsService eventsService;

	@GetMapping("/details/eventDetails/tickets/{eventsid}")
	public String bookTicket(Model model,@PathVariable("eventsid") Long id,Principal principal) {
		TempHold.hold.clear();
		model.addAttribute("tickets",new Tickets());
		model.addAttribute("event",eventsService.getEventsById(id).get());
		model.addAttribute("user",principal.getName());
		return "bookTickets";
	}
	 @PostMapping("/details/addTickets")
		public String saving( @Valid Tickets tickets,Principal principal) 
				 {
			TempHold.hold.add(tickets);
			System.out.println(tickets.getName());
				
		
			return "redirect:/payment";
		
		}
	 @GetMapping("/viewTickets")
	 public String viewTicket(Principal principal,Model model) {
		 String user = principal.getName();
		List<Tickets> tickets = ticketsService.getTicketsByUser(user);
		model.addAttribute("tickets",tickets);
		 return "viewTicket";
	 }
	 @GetMapping("admin/viewTickets")
	 public String viewTickets(Principal principal,Model model) {
		
		List<Tickets> tickets = ticketsService.showAllTickets();
		model.addAttribute("tickets",tickets);
		 return "viewTicket";
	 }
	 @GetMapping("/payment")
	 public String payment(Model model){
		 model.addAttribute("ticket",TempHold.hold.get(0));
		return "payment";
	 }
	 @GetMapping("/buyTicket")
	 public String addTicket() {
		 Tickets ticket = TempHold.hold.get(0);
		 ticketsService.addTickets(ticket);
		 TempHold.hold.clear();
		return "redirect:/home"; 
	 }
	 @GetMapping("/redirect/payment")
	 public String gateway() {
		 return "gateway";
	 }
	
}
