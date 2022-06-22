package com.ship.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ship.model.Activities;
import com.ship.model.Destination;
import com.ship.model.Events;
import com.ship.repository.ActivitiesRepo;
import com.ship.service.ActivitiesService;
import com.ship.service.EventsService;

@Controller
public class ActivitiesController {

	@Autowired
	private ActivitiesService activitiesService;
	
	@Autowired
	private ActivitiesRepo activitiesRepo;
	
	@Autowired
	private EventsService eventsService;
	
	@GetMapping("/admin/activities")
	public String showform(Model model) {
		model.addAttribute("activities", new Activities());
		model.addAttribute("events",eventsService.showAllEvents());
		return "addActivities";
	}
	
	  @PostMapping("/admin/addActivities")
			public String saving( @Valid Activities activities) 
					 {
				
					activitiesService.addActivities(activities);
				
				return "redirect:/home";
			
			}
	  @GetMapping("/admin/viewActivities")
	  public String view(Model model) {
		  List<Activities> listActivities = activitiesService.showAllActivities();
	        model.addAttribute("listActivities", listActivities);
	        List<Events> listEvents = eventsService.showAllEvents();
	        model.addAttribute("listEvents", listEvents);
		  return "activitiesList";
	  }
	  @GetMapping("/admin/delete4/{id}")
	  public String delete(@PathVariable("id") Long id) {
		  activitiesService.removeActivities(id);
		  return "redirect:/viewActivities";
	  }
}
