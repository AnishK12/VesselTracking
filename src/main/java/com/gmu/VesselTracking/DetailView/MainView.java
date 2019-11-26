
package com.gmu.VesselTracking.DetailView;

import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.gmu.VesselTracking.Search.ShipRepo;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.vaadin.leaflet.LeafletPointSelector;

@SuppressWarnings("serial")
@Route("detail_view")
@StyleSheet("styles.css")
public class MainView extends VerticalLayout implements HasUrlParameter<Integer>{
	
	private DetailViewPresenter presenter;
	private LeafletPointSelector map;
	private Integer vesselID;
	@Autowired
	private ShipRepo repo;
	@Autowired
	private FollowingShipsRepo followingRepo;
	private boolean isFollowing = false;
	
	
	public MainView() {
		UI.getCurrent().getPage().addStyleSheet("styles.css");
		
		routerLink();
	}
	
	@Override
	public void setParameter(BeforeEvent event, @OptionalParameter Integer parameter) {
		vesselID = parameter;
		presenter = new DetailViewPresenter(this, repo, vesselID);
		
	}
	
	@Override
	protected void onAttach(AttachEvent attachEvent) {		
		ServletContext servletContext = VaadinServlet.getCurrent().getServletContext();
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).getAutowireCapableBeanFactory()
				.autowireBean(this);
	}
	
	public void routerLink() {
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
	}
	
	@Cacheable("Ships")
	public void addDetailViews(String name, double x, double y, String startPort, String endPort, String shipType, String cargoType, String deadWeight, String buildYear) {
		
		map = new LeafletPointSelector();
		map.setHeight("600px");
        map.setWidth("1000px");
		Point createPoint = new GeometryFactory().createPoint(new Coordinate(x,y));
        map.setValue(createPoint);
        Div div = new Div();
        div.add(map);
        HorizontalLayout mainLayout = new HorizontalLayout();
        VerticalLayout subLayout = new VerticalLayout();
        mainLayout.add(div);
        
        List<Info> shipInfo = Arrays.asList(
        		new Info("Name", name),
        		new Info("Origin Port", startPort),
        		new Info("Destination Port", endPort),
        		new Info("Ship Type", shipType),
        		new Info("Cargo Type", cargoType),
        		new Info("Dead Weight Tonnage", deadWeight),
        		new Info("Build Year", buildYear));
        
        Grid<Info> grid = new Grid<>(Info.class);
        grid.setItems(shipInfo);
        grid.setHeight("500px");
        grid.setWidth("500px");;
        
//        Button btnSearch = new Button("Apply filter");
//        btnSearch.setIcon(FontAwesome.SEARCH);
//        btnSearch.addClickListener(e->{
//        e.getButton().setIcon(FontAwersome.CANCEL)
//        e.getButton().setCaption("Cancel filter");
//        });
        
        Button b2 = new Button("Follow Ship");
        b2.addClickListener(e->{
        	Notification.show(presenter.SetFollowShipStatue(isFollowing, followingRepo));
        	this.isFollowing = !this.isFollowing;
        	if (isFollowing) {
        		b2.setText("Unfollow Ship");
        	}else {
        		b2.setText("Follow Ship");
        	}
        });
//        b2 = new Button("Follow Ship", e -> {
//            Notification.show(presenter.SetFollowShipStatue(isFollowing, followingRepo));
//            if(isFollowing) {
//            	
//            	b2.setText("Unfollowing");
//            }
//            this.isFollowing = !this.isFollowing;
// 
//        });
        
        subLayout.add(grid, b2);
        mainLayout.add(subLayout);
        add(mainLayout);
        
		
	}
}

