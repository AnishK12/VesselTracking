  package com.gmu.VesselTracking.Search.SearchHistoryPackage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gmu.VesselTracking.Accounts.SearchKey;
import com.gmu.VesselTracking.Accounts.User;

@Controller
@SessionAttributes("user")
public class SearchHistoryService {
	
	@Autowired
	private SearchHistoryRepo searchHistoryRepo;
	
	@RequestMapping(value = "/searchShip", method = RequestMethod.POST)
	@Cacheable("SearchHistory")
	public ModelAndView searchPage(HttpSession session, @ModelAttribute("searchKey") SearchKey searchKey) {
		User user = (User) session.getAttribute("sessionUser");
		SearchHistory s = new SearchHistory(); 
		s.setKey(searchKey.getKey());
		s.setUserId(user.getUserid());
		searchHistoryRepo.save(s);
		ModelAndView mav = new ModelAndView("redirect:/search/" + searchKey.getKey());
		return mav;
	}

}