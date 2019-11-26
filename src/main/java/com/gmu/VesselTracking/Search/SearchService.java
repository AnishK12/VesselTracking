
package com.gmu.VesselTracking.Search;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.gmu.VesselTracking.Search.SearchHistoryPackage.SearchHistoryService;
import com.gmu.VesselTracking.Search.SearchHistoryPackage.SearchHistoryRepo;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@StyleSheet("styles.css")
@Route(value = "search")
public class SearchService extends VerticalLayout implements HasUrlParameter<String> {
	
	@Autowired
	ShipRepo repo;
	@Autowired
	SearchHistoryRepo shRepo;
	String searchParam;
	QueryModel qModel;
	SearchHistoryService cModel;
	
	Logger logger = LoggerFactory.getLogger(Ships.class);
	
	public SearchService() {
		UI.getCurrent().getPage().addStyleSheet("styles.css");
	}

	@Override
	public void setParameter(BeforeEvent event, String parameter) {
		searchParam = parameter;
		qModel = new QueryModel(this, searchParam, repo);
	}

	@Cacheable("Ships")
	public void postResults(List<Ships> shipsList) {
		HorizontalLayout navBar = new HorizontalLayout();
		
		Button homeButton = new Button("Home");
		homeButton.addClickListener( e-> {
			homeButton.getUI().ifPresent(ui -> {
				ui.navigate("welcome");
				ui.getPage().reload();});
		});
		
		Button accountButton = new Button("Account");
		accountButton.addClickListener( e-> {
			accountButton.getUI().ifPresent(ui -> {
				ui.navigate("account");
				ui.getPage().reload();});
		});
		
		Button logOutButton = new Button("Sign Out");
		logOutButton.addClickListener( e-> {
			logOutButton.getUI().ifPresent(ui -> {
				ui.navigate("home");
				ui.getPage().reload();});
		});
		
		Button SearchHistoryOutButton = new Button("Search History");
		SearchHistoryOutButton.addClickListener( e-> {
			SearchHistoryOutButton.getUI().ifPresent(ui -> {
				ui.navigate("searchHistory");
				ui.getPage().reload();});
		});
		
		Button FollowingShipsOutButton = new Button("Following Ships");
		FollowingShipsOutButton.addClickListener( e-> {
			FollowingShipsOutButton.getUI().ifPresent(ui -> {
				ui.navigate("followingShips");
				ui.getPage().reload();});
		});
		
		navBar.add(homeButton, accountButton, SearchHistoryOutButton, FollowingShipsOutButton, logOutButton );
		add(navBar);
		
		Grid<Ships> grid = new Grid<>();
		grid.addColumn(Ships::getPropertiesname).setHeader("Ship Name");
		grid.addColumn(Ships::getPropertiesstartportportName).setHeader("Origin Port");
		grid.addColumn(Ships::getPropertiesendportportName).setHeader("Destination Port");	
		grid.addColumn(TemplateRenderer
			       .<Ships>of("<a href=[[item.link]]>Details</a>")
			       .withProperty("link", Ships::getLink)
			).setHeader("Detail View Link");
		grid.setItems(shipsList);
		grid.setHeight("1000px");
		grid.setWidth("1000px");
		logger.info("Search Grid Loaded for " + searchParam);
		add(grid);
	}
	
}