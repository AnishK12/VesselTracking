package com.gmu.VesselTracking.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ships {
	@Id
	private String type;
	private String name, crs_type, crs_properties_name, features_type, features_properties_Name, features_properties_description,
	features_properties_startPort_Portname, features_properties_endPort_PortName, features_properties_cargo_CargoType,
	features_properties_shipType_ShipType, features_geometry_type;
	
	private int features_geometry_coordinates;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCrs_type() {
		return crs_type;
	}

	public void setCrs_type(String crs_type) {
		this.crs_type = crs_type;
	}

	public String getCrs_properties_name() {
		return crs_properties_name;
	}

	public void setCrs_properties_name(String crs_properties_name) {
		this.crs_properties_name = crs_properties_name;
	}

	public String getFeatures_type() {
		return features_type;
	}

	public void setFeatures_type(String features_type) {
		this.features_type = features_type;
	}

	public String getFeatures_properties_Name() {
		return features_properties_Name;
	}

	public void setFeatures_properties_Name(String features_properties_Name) {
		this.features_properties_Name = features_properties_Name;
	}

	public String getFeatures_properties_description() {
		return features_properties_description;
	}

	public void setFeatures_properties_description(String features_properties_description) {
		this.features_properties_description = features_properties_description;
	}

	public String getFeatures_properties_startPort_Portname() {
		return features_properties_startPort_Portname;
	}

	public void setFeatures_properties_startPort_Portname(String features_properties_startPort_Portname) {
		this.features_properties_startPort_Portname = features_properties_startPort_Portname;
	}

	public String getFeatures_properties_endPort_PortName() {
		return features_properties_endPort_PortName;
	}

	public void setFeatures_properties_endPort_PortName(String features_properties_endPort_PortName) {
		this.features_properties_endPort_PortName = features_properties_endPort_PortName;
	}

	public String getFeatures_properties_cargo_CargoType() {
		return features_properties_cargo_CargoType;
	}

	public void setFeatures_properties_cargo_CargoType(String features_properties_cargo_CargoType) {
		this.features_properties_cargo_CargoType = features_properties_cargo_CargoType;
	}

	public String getFeatures_properties_shipType_ShipType() {
		return features_properties_shipType_ShipType;
	}

	public void setFeatures_properties_shipType_ShipType(String features_properties_shipType_ShipType) {
		this.features_properties_shipType_ShipType = features_properties_shipType_ShipType;
	}

	public String getFeatures_geometry_type() {
		return features_geometry_type;
	}

	public void setFeatures_geometry_type(String features_geometry_type) {
		this.features_geometry_type = features_geometry_type;
	}

	public int getFeatures_geometry_coordinates() {
		return features_geometry_coordinates;
	}

	public void setFeatures_geometry_coordinates(int features_geometry_coordinates) {
		this.features_geometry_coordinates = features_geometry_coordinates;
	}

	@Override
	public String toString() {
		return "Ships [type=" + type + ", name=" + name + ", crs_type=" + crs_type + ", crs_properties_name="
				+ crs_properties_name + ", features_type=" + features_type + ", features_properties_Name="
				+ features_properties_Name + ", features_properties_description=" + features_properties_description
				+ ", features_properties_startPort_Portname=" + features_properties_startPort_Portname
				+ ", features_properties_endPort_PortName=" + features_properties_endPort_PortName
				+ ", features_properties_cargo_CargoType=" + features_properties_cargo_CargoType
				+ ", features_properties_shipType_ShipType=" + features_properties_shipType_ShipType
				+ ", features_geometry_type=" + features_geometry_type + ", features_geometry_coordinates="
				+ features_geometry_coordinates + "]";
	}
	
}
