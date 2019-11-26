package com.gmu.VesselTracking.DetailView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

import com.gmu.VesselTracking.Accounts.User;
import com.gmu.VesselTracking.Search.ShipRepo;
import com.gmu.VesselTracking.Search.Ships;
import com.vaadin.flow.server.VaadinSession;


public class DetailViewPresenter {

		//private View view;
		private Ships vessel;
		private MainView detailViewPage;
		private ShipRepo repo;
		private Integer vesselId;
		
		Logger logger = LoggerFactory.getLogger(Ships.class);
		
		public DetailViewPresenter(MainView detailViewPage, ShipRepo repo, Integer vesselID) {
			//this.vessel = vessel;
			this.detailViewPage = detailViewPage;
			this.repo = repo;
			this.vesselId = vesselID;
			
			sendDetails();
			
		}
		
		@Cacheable("Ships")
		public void sendDetails() {
			vessel = repo.findById(vesselId).orElse(new Ships());	
			logger.info("Detail View accessed for ship: " + vessel.getPropertiesname());
			
			this.detailViewPage.addDetailViews(vessel.getPropertiesname(), vessel.getGeometrycoordinates0(), vessel.getGeometrycoordinates1(), 
					vessel.getPropertiesstartportportName(), vessel.getPropertiesendportportName(), vessel.getPropertiesshiptypeshiptype(), 
					vessel.getPropertiescargocargotype(), vessel.getPropertiesdeadweight(), vessel.getPropertiesbuildyear());
		}

		@Cacheable("Ships")
		public String SetFollowShipStatue(boolean isFollowing, FollowingShipsRepo fRepo) {
			Ships tempVessel = repo.findById(vesselId).orElse(new Ships());
			String message;
			User user = (User)VaadinSession.getCurrent().getSession().getAttribute("sessionUser");
			
			if(isFollowing == false) {
				fRepo.save(new FollowingShips(tempVessel.getID(), user.getUserid(), tempVessel.getPropertiesname()));
				message = "Following Ship - " + tempVessel.getPropertiesname();
				logger.info(user.getUsername() + " followed Ship: " + tempVessel.getPropertiesname());
			}
			else {
				fRepo.deleteById(tempVessel.getID());
				message = "Unfollowing Ship - " + tempVessel.getPropertiesname();
				logger.info(user.getUsername() + " unfollowed Ship: " + tempVessel.getPropertiesname());
			}
			return message;
		}
}