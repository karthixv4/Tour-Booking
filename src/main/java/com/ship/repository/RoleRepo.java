package com.ship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ship.model.Role;



@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

	public Role findByName(String name);

}
