package com.gmu.VesselTracking.dao;
import org.springframework.data.repository.CrudRepository;
import com.gmu.VesselTracking.Model.Ships;

public interface UserRepo extends CrudRepository<Ships, Integer>{
	
}
