package com.ship.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ship.model.Activities;
import com.ship.model.Destination;
import com.ship.repository.ActivitiesRepo;

@Service
public class ActivitiesService {
	
	@Autowired
	private ActivitiesRepo activitiesRepo;
	public void addActivities(Activities activities) {
		activitiesRepo.save(activities);
	}
	public void removeActivities(Long id) {
		activitiesRepo.deleteById(id);
	}
	public List<Activities> getActivitiesById(Long id){
		return activitiesRepo.findAll(id);
		}
	public List<Activities> showAllActivities(){
		
		return activitiesRepo.findAll();
	}
	
}
