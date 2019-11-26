package com.gmu.VesselTracking.DetailView;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FollowingShips {
	
	@Id
	Integer shipId;
	Integer userId;
	String shipName;
	
	public FollowingShips() {
		
	}
	
	public FollowingShips(Integer shipId, Integer userId, String shipName) {
		this.shipId = shipId;
		this.shipName = shipName;
		this.userId = userId;
	}
	
	public Integer getShipId() {
		return shipId;
	}
	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	
	
	
}