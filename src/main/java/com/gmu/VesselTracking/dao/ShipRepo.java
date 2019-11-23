package com.gmu.VesselTracking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmu.VesselTracking.Model.Ships;

public interface ShipRepo extends JpaRepository<Ships, Integer>{

	List<Ships> findBypropertiesname(String propertiesname);
	List<Ships> findBypropertiesstartportportname(String portName);
	List<Ships> findBypropertiesstartportportnameLike(String string);
	List<Ships> findBypropertiesstartportportnameContaining(String string);
}
