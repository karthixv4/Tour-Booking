package com.ship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


import com.ship.model.Events;



public interface EventsRepo extends JpaRepository<Events, Long> {
	
	  @Transactional
	  @Modifying
	  @Query("delete from Events b where b.Id like ?1 and fileName like ?2") 
	  public void deleteEventWithFile(Long id, String fileName);
	  
	  @Query("SELECT u FROM Events u WHERE destination_destination_id LIKE ?1") 
	  public List<Events> findAll(Long id);
	  
	  @Transactional
	  @Modifying
	@Query("DELETE FROM Events b where destination_destination_id LIKE ?1")
	 public void EventDestination(Long id);
}
