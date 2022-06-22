package com.ship.service;

	import java.io.File;
	import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.ship.model.Destination;
import com.ship.model.Users;
import com.ship.repository.DestinationRepo;
import com.ship.repository.EventsRepo;



	@Service
public class DestinationService {
	

		public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
		
		@Autowired
		private DestinationRepo destinationRepo;
		
		@Autowired
		private EventsRepo eventsRepo;
		
		public void addDestination(Destination destination) {
			destinationRepo.save(destination);
		}
		public void removeDestination(Long id) {
			destinationRepo.deleteById(id);
		}
		public void removeDestinationandFile(Long Id,String fileName) {
			try {
				if (Id != 0 && fileName != null) {
					destinationRepo.deleteDestinationWithFile(Id, fileName); 
				
					String path = uploadDirectory + "/" + fileName;
					System.out.println("Path=" + path);
					File fileToDelete = new File(path);
					fileToDelete.delete();
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		public List<Destination> showAllDestination(){
		
			return destinationRepo.findAll();
		}
		public Optional<Destination> getDestinationById(Long id){
			return destinationRepo.findById(id);
			}
	public void removeEvents(Long id) {
		eventsRepo.EventDestination(id);
	}

	}


