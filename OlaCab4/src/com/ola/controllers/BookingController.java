package com.ola.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ola.modal.Cab;
import com.ola.modal.User;
import com.ola.modal.UserHistory;
import com.ola.service.OlaService;

@Controller
public class BookingController {
	@Autowired 
	OlaService olaService;
	
	@RequestMapping(value = "/bookCab", method = RequestMethod.GET)
	public String cabBooking(@ModelAttribute("user") User user) {
		Cab cabBooking = olaService.cabBooking(user);
		if(cabBooking == null){
			return "redirect:/unsuccessful";
		}
		return "redirect:/successful";// will redirect to viewemp request mapping
	}
	
	@RequestMapping(value="/cabCancel",method = RequestMethod.GET)
	public String cabCancel(@ModelAttribute("user") User user){
		String userId = user.getUserId();
		UserHistory userHistory = olaService.getUserHistory(userId);
		String cabName = userHistory.getCabName();
		try {
			Cab cab = olaService.getCabDao().getCab(cabName);
			olaService.cabCancel(cab);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/successful";
		
		
	}

	
	@RequestMapping(value="/unsuccessful")
	@ResponseBody
	public String unsuccess(Model m){
		return "Your cab not available";
				}
		
	@RequestMapping(value="/successful")
	@ResponseBody
	public String success(Model m){
		return "Your cab Has Been Successful";
				}
		
		@RequestMapping(value="/CabCancel")
		public String cancel(Model m){
			return "Your cab Has Been Cancel";
		
	}
}
