package com.gmu.VesselTracking.Controllers;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.gmu.VesselTracking.Model.*;
import com.gmu.VesselTracking.dao.ShipRepo;
import com.gmu.VesselTracking.dao.UserRepo;

@Controller
public class TestController {
	@Autowired
	ShipRepo repo;
	UserRepo userData;

	@RequestMapping("/welcome")
	public ModelAndView welcomePage() {
		return new ModelAndView("welcome");
	}
	
	@RequestMapping("/database")
	public String databasePage() {
		return "database";
	}
	
	@RequestMapping("/addShip")
	public String addShip(Ships ship) {
		repo.save(ship);
		return "home";
	}

	@RequestMapping("/home")
	public ModelAndView firstPage() {
		return new ModelAndView("home");
	}

	@RequestMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}

//	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
//	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
//			@ModelAttribute("login") Login login) {
//		ModelAndView mav = null;
//		Iterable<User> users = userData.findAll();
//		Iterator<User> userItr = users.iterator();
//		
//		while(userItr.hasNext()) {
//			User nextUser = userItr.next();
//			if(nextUser.getUsername().equals(login.getUsername())) { //check if username exists, then check password
//				if(nextUser.getPassword().equals(login.getPassword())) {
//					mav = new ModelAndView("welcome");
//					mav.addObject("firstname", nextUser.getFirstname());
//					return mav;
//				} else {
//					mav = new ModelAndView("login");
//					mav.addObject("login", new Login());
//					mav.addObject("message", "Password is wrong, try again!");
//					return mav;
//				}
//			}
//		}
//		mav = new ModelAndView("login");
//		mav.addObject("login", new Login());
//		mav.addObject("message", "User not found, try again!");
//		return mav;
//	}
//
//	@RequestMapping("/register")
//	public ModelAndView registerPage() {
//		ModelAndView mav = new ModelAndView("register");
//		mav.addObject("user", new User());
//		return mav;
//
//	}
//
//	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
//	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
//			@ModelAttribute("user") User user) {
//		Iterable<User> users = userData.findAll();
//		Iterator<User> userItr = users.iterator();
//		
//		while(userItr.hasNext()) {
//			User nextUser = userItr.next();
//			if(nextUser.getUsername().equals(user.getUsername())) { 
//				ModelAndView mav = new ModelAndView("register");
//				mav.addObject("user", new User());
//				mav.addObject("message", "Username already exists, try different username!");
//				return mav;
//			}
//		}
//		userData.save(user);
//		return new ModelAndView("welcome", "firstname", user.getFirstname());
//	}
}