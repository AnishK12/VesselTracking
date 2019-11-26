package com.gmu.VesselTracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class VesselTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(VesselTrackingApplication.class, args);
		
	} 

}
