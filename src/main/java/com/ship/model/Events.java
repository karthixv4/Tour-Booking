package com.ship.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="events_website")
public class Events {
	
	 @Id
	 @Column(name="Events_Id")
	 @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long Id;
	

	@Column
	 private String Name;
	 @Column
	 private String description;
	 
	 @Column(name = "file_name")
		private String fileName;
		
		@Column(name = "file_path")
		private String filePath;
		
		@Column(name = "file_type")
		private String fileType;
		
		
		@Column(name="Duration")
		private String Duration;
		
		@ManyToOne(fetch = FetchType.LAZY)
		private Destination destination;
		
		@Column
		private Long Cost;
		
			public Long getCost() {
			return Cost;
		}

		public void setCost(Long cost) {
			Cost = cost;
		}

			public String getDuration() {
			return Duration;
		}

		public void setDuration(String duration) {
			Duration = duration;
		}

			public Long getId() {
			return Id;
		}

		public Destination getDestination() {
				return destination;
			}

			public void setDestination(Destination destination) {
				this.destination = destination;
			}

		public void setId(Long id) {
			Id = id;
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

			public String getFileName() {
				return fileName;
			}

			public void setFileName(String fileName) {
				this.fileName = fileName;
			}

			public String getFilePath() {
				return filePath;
			}

			public void setFilePath(String filePath) {
				this.filePath = filePath;
			}

			public String getFileType() {
				return fileType;
			}

			public void setFileType(String fileType) {
				this.fileType = fileType;
			}

}
