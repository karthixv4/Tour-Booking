package com.ship;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ship.controller.EventsController;


@SpringBootApplication
public class VoyageApplication {

	public static void main(String[] args) {
		new File(EventsController.uploadDirectory).mkdir();
		SpringApplication.run(VoyageApplication.class, args);
	}

}
