package com.ola.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ola.modal.User;
import com.ola.service.OlaService;
@Controller 
public class UserController {
	@Autowired
	OlaService olaService;

	@RequestMapping("/registrationUser")
	public String showform(Model m) {
		System.out.println("testUser");
		m.addAttribute("command", new User());
		return "registrationUser";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") User user) {
		try {
			olaService.getUserDao().registerUser(user);
			;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/viewUser";// will redirect to viewemp request mapping
	}

	@RequestMapping("/viewUser")
	public String viewUser(Model m) {
		List<User> list = null;
		try {
			list = olaService.getUserDao().getAllUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.addAttribute("list", list);

		return "viewUser";

	}
	
	 @RequestMapping("/deleteUser")
	    public String deleteUser(@ModelAttribute("user") User user){
	    	olaService.unregisterUser(user);
	    	return "redirect:/viewUser";
	    }
}
