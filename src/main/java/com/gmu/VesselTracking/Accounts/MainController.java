package com.gmu.VesselTracking.Accounts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gmu.VesselTracking.DetailView.FollowingShips;
import com.gmu.VesselTracking.DetailView.FollowingShipsRepo;
import com.gmu.VesselTracking.Search.Ships;
import com.gmu.VesselTracking.Search.SearchHistoryPackage.SearchHistory;
import com.gmu.VesselTracking.Search.SearchHistoryPackage.SearchHistoryRepo;

@Controller
@SessionAttributes("user")
public class MainController {

	@Autowired
	private UserData userData;
	
	@Autowired
	private SearchHistoryRepo searchHistoryRepo;
	
	@Autowired
	private FollowingShipsRepo followShipsRepo;
	
	Logger logger = LoggerFactory.getLogger(Ships.class);

	@RequestMapping("/welcome")
	public ModelAndView welcomePage(HttpSession session) {
		User user = (User) session.getAttribute("sessionUser");
		ModelAndView mav = new ModelAndView("welcome");
		mav.addObject("firstname", user.getFirstname());

		mav.addObject("searchKey", new SearchKey());
		return mav;
	}

	@RequestMapping("/home")
	public ModelAndView firstPage() {
		return new ModelAndView("home");
	}
	
	@RequestMapping("/searchHistory")
	public ModelAndView searchHistoryPage(HttpSession session) {
		User user = (User) session.getAttribute("sessionUser");
		List<SearchHistory> searchListAll = searchHistoryRepo.findAll();
		List<String> searchList = new ArrayList<String>();
		for(SearchHistory s : searchListAll)
		{
			if(s.getUserId().intValue() == user.getUserid().intValue())
				searchList.add(s.getKey());
		}
		ModelAndView mav = new ModelAndView("searchHistory");
		mav.addObject("searchList", searchList);
		return mav;
	}
	
	@RequestMapping("/followingShips")
	public ModelAndView followingShip(HttpSession session) {
		User user = (User) session.getAttribute("sessionUser");
		List<FollowingShips> followShipAll = followShipsRepo.findAll(); 
		List<String> followList = new ArrayList<String>();
		for(FollowingShips s : followShipAll)
		{
			if(s.getUserId().intValue() == user.getUserid().intValue())
				followList.add(s.getShipName());
		}
		ModelAndView mav = new ModelAndView("followingShips");
		mav.addObject("followList", followList);
		return mav;
	}
	
	@RequestMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		Iterable<User> users = userData.findAll();
		Iterator<User> userItr = users.iterator();
		User user = new User();
		
		while (userItr.hasNext()) {
			User nextUser = userItr.next();
			if (nextUser.getUsername().equals(login.getUsername())) { // check if username exists, then check password
				if (nextUser.getPassword().equals(login.getPassword())) {
					user = nextUser;
					session.setAttribute("sessionUser", user);
					mav = new ModelAndView("welcome");
					mav.addObject("firstname", nextUser.getFirstname());
					mav.addObject("searchKey", new SearchKey());
					logger.info("Logged In");
					return mav;
				} else {
					mav = new ModelAndView("login");
					mav.addObject("login", new Login());
					mav.addObject("message", "Password is wrong, try again!");
					logger.error("Error - Password is incorrect");
					return mav;
				}
			}
		}
		mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		mav.addObject("message", "User not found, try again!");
		logger.error("Error - Username not found");
		return mav;
	}

	@RequestMapping("/register")
	public ModelAndView registerPage() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;

	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {
		Iterable<User> users = userData.findAll();
		Iterator<User> userItr = users.iterator();

		while (userItr.hasNext()) {
			User nextUser = userItr.next();
			if (nextUser.getUsername().equals(user.getUsername())) {
				ModelAndView mav = new ModelAndView("register");
				mav.addObject("user", user);
				mav.addObject("message", "Username already exists, try different username!");
				logger.error("Error - Username Already Exists");
				return mav;
			}
		}
		userData.save(user);
		ModelAndView mav = new ModelAndView("welcome", "firstname", user.getFirstname());
		mav.addObject("user", new User());
		mav.addObject("searchKey", new SearchKey());
		session.setAttribute("sessionUser", user);
		logger.info(user.getUsername() + " logged in");
		return mav;
	}

	// update user info
	@RequestMapping("/account")
	public ModelAndView accountPage(HttpSession session) {
		User user = (User) session.getAttribute("sessionUser");
		ModelAndView mav = new ModelAndView("update");
		mav.addObject("user", user);
		return mav;
	}

	// update user Info
	@RequestMapping(value = "/processUpdate", method = RequestMethod.POST)
	public ModelAndView updateInfo(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {

		userData.save(user);
		ModelAndView mav = new ModelAndView("welcome");
		mav.addObject("firstname", user.getFirstname());
		mav.addObject("searchKey", new SearchKey());
		logger.info("Account info changed for " + user.getUsername());
		return mav;
	}
	//logout
	@RequestMapping("/logout")
	public ModelAndView logoutOption(HttpSession session) {
		session.setAttribute("sessionUser", null);
		ModelAndView mav = new ModelAndView("home");
		logger.info("Logged Out");
		return mav;
	}

}
