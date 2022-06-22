package com.ship.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ship.model.Activities;
import com.ship.model.Destination;
import com.ship.model.Events;
import com.ship.model.Users;
import com.ship.repository.EventsRepo;


@Service
public class EventsService {
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	
	@Autowired
	private EventsRepo eventsRepo;
	
	public void addEvents(Events events) {
		eventsRepo.save(events);
	}
	public void removeEvents(Long id) {
		eventsRepo.deleteById(id);
	}
	public void removeEventandFile(Long Id,String fileName) {
		
		
		try {
			if (Id != 0 && fileName != null) {
				 eventsRepo.deleteEventWithFile(Id, fileName); 
			
				String path = uploadDirectory + "/" + fileName;
				System.out.println("Path=" + path);
				File fileToDelete = new File(path);
				fileToDelete.delete();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public List<Events> showAllEvents(){
	
		return eventsRepo.findAll();
	}
	public Optional<Events> getEventsById(Long id){
		return eventsRepo.findById(id);
		}
	
	public List<Events> showEventsById(Long id){
		return eventsRepo.findAll(id);
	}
	

}
