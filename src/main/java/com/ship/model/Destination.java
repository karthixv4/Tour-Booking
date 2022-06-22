package com.ship.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="destination_website")
public class Destination {
	
		 @Id
		 @Column(name="Destination_Id")
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
			
			

				public Long getId() {
				return Id;
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
