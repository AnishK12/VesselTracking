package com.gmu.VesselTracking.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gmu.VesselTracking.Model.Ships;

import com.gmu.VesselTracking.service.SearchService;

@Controller
public class SearchController {
	@Autowired
	private SearchService searchService;
	// private ShipRepo repo;
	
//	@GetMapping("/ships")
//	public String listShips(Model model) {
//		model.addAttribute("ships", searchService.findByName("name"));
//		return "search";
//	}
	
	@RequestMapping("/test")
	public String home() {
		return "test";
	}
	
	@RequestMapping("/ships")
	@ResponseBody 
	public List<Ships> getShips() {
		return searchService.findAll();
	}
	
//	@RequestMapping("/ships/{id}")
//	@ResponseBody 
//	public Optional<Ships> getShip(@PathVariable("id")int id) {
//		System.out.println(searchService.findById(id));
//		return searchService.findById(id);
//	}
	
//	@RequestMapping("/ships/{id}")
//	public String getShipByOrigin(@PathVariable("id")String id) {
//		searchService.findBypropertiesstartportportnameContaining(id);
//		return "welcomebasic";
//	}

	// Uncomment the system.out.println to see it properly populate and be ready to forward. ThymeLeaf 
	// is the only way I can see to build a table normally however it breaks all web pages if we use it.
	@GetMapping("/ships/China")
	public String listShips(Model model) {
		model.addAttribute("shipss",searchService.findBypropertiesstartportportnameContaining("China"));
		// System.out.println(searchService.findBypropertiesstartportportnameContaining("China"));
		return "search";
	}
	
}
