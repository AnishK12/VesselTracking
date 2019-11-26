package com.gmu.VesselTracking.Search;

import java.util.List;


public class QueryModel {

	public QueryModel(SearchService searchService, String searchParam, ShipRepo repo) {
		List<Ships> shipsList = repo.findBypropertiesstartportportnameContaining(searchParam);
		searchService.postResults(shipsList);
	}

}