package com.gmu.VesselTracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmu.VesselTracking.Model.SearchHistory;

public interface SearchHistoryRepo extends JpaRepository<SearchHistory, Integer>{

}
