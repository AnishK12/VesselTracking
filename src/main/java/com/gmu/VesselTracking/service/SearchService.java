package com.gmu.VesselTracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gmu.VesselTracking.Model.Ships;
import com.gmu.VesselTracking.dao.ShipRepo;

@Service
public class SearchService {
	@Autowired
	private ShipRepo shipRepo;

	public List<Ships> findAll() {
		return shipRepo.findAll();
	}

	@ResponseBody
	public Optional<Ships> findById(int id) {
		System.out.println(shipRepo.findById(id));
		return shipRepo.findById(id);
	}

	public List<Ships> findBypropertiesstartportportnameContaining(String id) {
		// TODO Auto-generated method stub
		return shipRepo.findBypropertiesstartportportnameContaining(id);
	}
}
