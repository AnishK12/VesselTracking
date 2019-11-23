package com.gmu.VesselTracking.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ships {
	
	String type;                          
    String propertiesname;                
	String propertiesdescription;       
	String propertiesstartportportname; 
	String propertiesendportportname;    
	String propertiescargocargotype;    
	String propertiesshiptypeshiptype;    
	String geometrytype;                  
	double geometrycoordinates0;          
	double geometrycoordinates1; 
	@Id
	Integer id;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPropertiesname() {
		return propertiesname;
	}
	public void setPropertiesname(String propertiesname) {
		this.propertiesname = propertiesname;
	}
	public String getPropertiesdescription() {
		return propertiesdescription;
	}
	public void setPropertiesdescription(String propertiesdescription) {
		this.propertiesdescription = propertiesdescription;
	}
	public String getPropertiesstartportportName() {
		return propertiesstartportportname;
	}
	public void setPropertiesstartportportName(String propertiesstartportportName) {
		this.propertiesstartportportname = propertiesstartportportName;
	}
	public String getPropertiesendportportName() {
		return propertiesendportportname;
	}
	public void setPropertiesendportportName(String propertiesendportportName) {
		this.propertiesendportportname = propertiesendportportName;
	}
	public String getPropertiescargocargotype() {
		return propertiescargocargotype;
	}
	public void setPropertiescargocargotype(String propertiescargocargotype) {
		this.propertiescargocargotype = propertiescargocargotype;
	}
	public String getPropertiesshiptypeshiptype() {
		return propertiesshiptypeshiptype;
	}
	public void setPropertiesshiptypeshiptype(String propertiesshiptypeshiptype) {
		this.propertiesshiptypeshiptype = propertiesshiptypeshiptype;
	}
	public String getGeometrytype() {
		return geometrytype;
	}
	public void setGeometrytype(String geometrytype) {
		this.geometrytype = geometrytype;
	}
	public double getGeometrycoordinates0() {
		return geometrycoordinates0;
	}
	public void setGeometrycoordinates0(double geometrycoordinates0) {
		this.geometrycoordinates0 = geometrycoordinates0;
	}
	public double getGeometrycoordinates1() {
		return geometrycoordinates1;
	}
	public void setGeometrycoordinates1(double geometrycoordinates1) {
		this.geometrycoordinates1 = geometrycoordinates1;
	}
	public Integer getID() {
		return id;
	}
	public void setID(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Ships [type=" + type + ", propertiesname=" + propertiesname + ", propertiesdescription="
				+ propertiesdescription + ", propertiesstartportportName=" + propertiesstartportportname
				+ ", propertiesendportportName=" + propertiesendportportname + ", propertiescargocargotype="
				+ propertiescargocargotype + ", propertiesshiptypeshiptype=" + propertiesshiptypeshiptype
				+ ", geometrytype=" + geometrytype + ", geometrycoordinates0=" + geometrycoordinates0
				+ ", geometrycoordinates1=" + geometrycoordinates1 + ", id=" + id + "]";
	}            
	
	
}
