package com.gmu.VesselTracking.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SearchHistory {
	private String username;
	private String search;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SearchHistoryModel [username=" + username + ", search=" + search + "]";
	}

	
}
