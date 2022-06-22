package com.ship.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="tickets_website")
public class Tickets {
	
	 @Id
	 @Column(name="Tickets_Id")
	 @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	 
	 @Column
	private String Name;
	 
	 @Column
	 private Long Phone;
	 
	 @Column
	 private String EventDate;
 

	@Column
	private Long Adults;
	 
	 @Column
	private Long Kids;
	 
	 @Column
	 private String EventName;
	 
	 @Column
	 private String DestinationName;
	 
	 
	@Column
     private String users;
	
	@Column
	private Long Cost;

	


	public String getEventDate() {
		return EventDate;
	}


	public void setEventDate(String eventDate) {
		EventDate = eventDate;
	}


	public Long getPhone() {
		return Phone;
	}


	public void setPhone(Long phone) {
		Phone = phone;
	}


	public Long getId() {
		return id;
	}


	public Long getCost() {
		return Cost;
	}


	public void setCost(Long cost) {
		Cost = cost;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public String getEventName() {
		return EventName;
	}


	public void setEventName(String eventName) {
		EventName = eventName;
	}


	public String getDestinationName() {
		return DestinationName;
	}


	public void setDestinationName(String destinationName) {
		DestinationName = destinationName;
	}





	public String getUsers() {
		return users;
	}


	public void setUsers(String users) {
		this.users = users;
	}


	public void setName(String name) {
		Name = name;
	}


	public Long getAdults() {
		return Adults;
	}


	public void setAdults(Long adults) {
		Adults = adults;
	}


	public Long getKids() {
		return Kids;
	}


	public void setKids(Long kids) {
		Kids = kids;
	}


	 
	
	
}
