package com.ship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ship.model.Activities;
import com.ship.model.Destination;
import com.ship.model.Events;
import com.ship.service.ActivitiesService;
import com.ship.service.DestinationService;
import com.ship.service.EventsService;

@Controller
public class HomePageController {
	@Autowired
	private DestinationService destinationService;
	
	@Autowired
	private EventsService eventsService;
	
	@Autowired
	private ActivitiesService activitiesService;
	
	
	 @GetMapping("/home")
	    public String listDestination(Model model) {
	        List<Destination> listDestination = destinationService.showAllDestination();
	        model.addAttribute("listDestination", listDestination);
	        List<Events> listEvents = eventsService.showAllEvents();
	        model.addAttribute("listEvents", listEvents);
	         
	        return "index";
	    }
	 @GetMapping("/details/{id}")
	 public String Details(Model model,@PathVariable Long id) {
		 List<Events> event = eventsService.showEventsById(id);
		 model.addAttribute("event",event);
	 model.addAttribute("details",destinationService.getDestinationById(id).get());
	 return "details";
	 }
	 @GetMapping("details/eventDetails/{id}")
	 public String eventDetails(Model model,@PathVariable Long id) {
		 List<Activities> act = activitiesService.getActivitiesById(id);
	 model.addAttribute("events",eventsService.getEventsById(id).get());
	 model.addAttribute("act",act);
	 System.out.println(act);

	 return "eventDetails";
	 }
	 @GetMapping("/admin")
	 public String admin() {
		 return "admin";
	 }
	@GetMapping("/allDestination")
	public String allDestination( Model model) {
		 List<Destination> listDestination = destinationService.showAllDestination();
	        model.addAttribute("listDestination", listDestination);
	        List<Events> listEvents = eventsService.showAllEvents();
	        model.addAttribute("listEvents", listEvents);
		return "allDestination";
	}
	@GetMapping("/allEvents")
	public String allEvents(Model model) {
		 List<Destination> listDestination = destinationService.showAllDestination();
	        model.addAttribute("listDestination", listDestination);
	        List<Events> listEvents = eventsService.showAllEvents();
	        model.addAttribute("listEvents", listEvents);
		return "allEvents";
	}
}
