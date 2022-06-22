package com.ship.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ship.model.Destination;
import com.ship.model.Events;
import com.ship.service.ActivitiesService;
import com.ship.service.DestinationService;
import com.ship.service.EventsService;




@Controller
public class EventsController {
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	@Autowired
	private EventsService eventsService;
	
	@Autowired
	private DestinationService destinationService;
	
	@Autowired
	private ActivitiesService activitiesService;
	
	
	 @GetMapping("/admin/addEvent")
	 public String showAddEventForm(Model model) {
	        model.addAttribute("events", new Events());
	        model.addAttribute("destination", destinationService.showAllDestination());
	    

	        return "addEvents";
	    }
	    //adding book to db
	    @PostMapping("/admin/saveEvents")
		public String saving( @Valid Events events,final @RequestParam("file") MultipartFile file) 
				throws IOException {
			
				
				String fileName = file.getOriginalFilename();
				String filePath = Paths.get(uploadDirectory, fileName).toString();
				String fileType = file.getContentType();
				

				// Save the file locally
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();

				
				events.setFileName(fileName);
				events.setFilePath(filePath);
				events.setFileType(fileType);
				
				eventsService.addEvents(events);
				
			
			return "redirect:/admin/EventsList";
		
		}
	    @GetMapping("/admin/EventsList")
	    public String listEvents(Model model) {
	        List<Events> listEvents = eventsService.showAllEvents();
	        model.addAttribute("listEvents", listEvents);
	        List<Destination> listDestination = destinationService.showAllDestination();
	        model.addAttribute("listDestination", listDestination);
	         
	        return "EventList";
	    }
@GetMapping("/admin/delete2/{id}/{deletedFileName}")
public String deleteEvent(@PathVariable("id") Long id, @PathVariable("deletedFileName") String deletedFileName) {
	String path = null;
	File file =null;

		path = uploadDirectory + "/" + deletedFileName;
		file = new File(path);
		if(file.exists()) {
			
			eventsService.removeEventandFile(id, deletedFileName);
			return "redirect:/admin/EventsList";
		
		}else {
			eventsService.removeEvents(id);
		}
		return "adminpanel";
}

}
