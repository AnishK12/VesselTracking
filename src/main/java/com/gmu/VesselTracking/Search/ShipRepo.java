package com.gmu.VesselTracking.Search;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipRepo extends JpaRepository<Ships, Integer>{

	List<Ships> findBypropertiesname(String propertiesname);
	List<Ships> findBypropertiesstartportportname(String portName);
	List<Ships> findBypropertiesstartportportnameLike(String string);
	List<Ships> findBypropertiesstartportportnameContaining(String string);
	Optional<Ships> findById(Integer vesselID);
}