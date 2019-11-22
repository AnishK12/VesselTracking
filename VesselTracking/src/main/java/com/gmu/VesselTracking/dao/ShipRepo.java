package com.gmu.VesselTracking.dao;
import org.springframework.data.repository.CrudRepository;
import com.gmu.VesselTracking.Model.Ships;

public interface ShipRepo extends CrudRepository<Ships, String>{
	
}
