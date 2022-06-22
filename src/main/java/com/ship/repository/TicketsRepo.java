package com.ship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ship.model.Activities;
import com.ship.model.Tickets;

public interface TicketsRepo extends JpaRepository< Tickets, Long> {

	@Query(value="SELECT a FROM Tickets a WHERE users LIKE %?1%")
	public List<Tickets> findAll(String user);
	
}
