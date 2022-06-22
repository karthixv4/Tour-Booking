package com.ship.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ship.model.Activities;





public interface ActivitiesRepo extends JpaRepository< Activities, Long> {
@Query(value="SELECT a FROM Activities a WHERE events_events_id LIKE ?1")
	public List<Activities> findAll(Long id);
}
