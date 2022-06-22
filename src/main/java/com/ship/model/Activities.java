package com.ship.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="activities_website")
public class Activities {
	
	@Id
	 @Column(name="Activities_Id")
	 @GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String Name;
private String description;

@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
private Events events;


public Events getEvents() {
	return events;
}
public void setEvents(Events events) {
	this.events = events;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
