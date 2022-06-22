package com.ship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ship.model.Destination;
public interface DestinationRepo extends JpaRepository<Destination, Long> {
	
	  @Transactional
	  @Modifying
	  @Query("delete from Destination b where b.Id like ?1 and fileName like ?2") 
	  public void deleteDestinationWithFile(Long id, String fileName);
	  
	  @Query("SELECT u FROM Destination u WHERE u.Name LIKE %?1%" +
	  " OR u.description like %?1%") 
	  public List<Destination> findAll(String keyword);

	  
}
