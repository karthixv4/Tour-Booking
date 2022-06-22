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

import com.ship.model.Destination;
import com.ship.model.Events;
import com.ship.service.DestinationService;
import com.ship.service.EventsService;


@Controller
public class DestinationController {

	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	@Autowired
	private DestinationService destinationService;
	
	@Autowired
	private EventsService eventsService;
	
	 @GetMapping("/admin/addDestination")
	 public String showAddDestinationForm(Model model) {
	        model.addAttribute("destination", new Destination());

	        return "addDestination";
	    }
	   
	    @PostMapping("/admin/saveDestination")
		public String saving( @Valid Destination destination,final @RequestParam("file") MultipartFile file) 
				throws IOException {
			
				
				String fileName = file.getOriginalFilename();
				String filePath = Paths.get(uploadDirectory, fileName).toString();
				String fileType = file.getContentType();
				

				// Save the file locally
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();

				
				destination.setFileName(fileName);
				destination.setFilePath(filePath);
				destination.setFileType(fileType);
				
				destinationService.addDestination(destination);
				
			
			return "redirect:/admin/DestinationList";
		
		}
	    @GetMapping("/admin/DestinationList")
	    public String listDestination(Model model) {
	        List<Destination> listDestination = destinationService.showAllDestination();
	        model.addAttribute("listDestination", listDestination);
	        List<Events> listEvents = eventsService.showAllEvents();
	        model.addAttribute("listEvents", listEvents);
	         
	        return "DestinationsList";
	    }
@GetMapping("/admin/delete3/{id}/{deletedFileName}")
public String deleteDestination(@PathVariable("id") Long id, @PathVariable("deletedFileName") String deletedFileName) {
	String path = null;
	File file =null;

		path = uploadDirectory + "/" + deletedFileName;
		file = new File(path);
		if(file.exists()) {
			destinationService.removeEvents(id);
			destinationService.removeDestinationandFile(id, deletedFileName);
			System.out.println("hello bro");
			return "redirect:/admin";
		
		}else {
			destinationService.removeDestination(id);
		}
		return "adminpanel";
}
@GetMapping("/details")
public String details() {
	return "details";
}



}
