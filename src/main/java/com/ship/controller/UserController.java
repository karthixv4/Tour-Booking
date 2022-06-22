package com.ship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ship.model.Users;
import com.ship.service.UserService;



@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/admin/viewUsers")
	   public String listUsers(Model model) {
		   
	        List<Users> listUsers = userService.showAllUsers();
	        model.addAttribute("listUsers", listUsers);
	         
	        return "UsersList";
	    }
	@GetMapping("/admin/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		  userService.removeUser(id);
          
	       
	        return "redirect:/admin/viewUsers";
	}
}
