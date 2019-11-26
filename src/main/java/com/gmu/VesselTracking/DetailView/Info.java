package com.gmu.VesselTracking.DetailView;

public class Info {
	private String Attribute;
	private String value;
	
	public Info(String type, String val) {
		Attribute = type;
		value = val;
	}

	public String getInfoType() {
		return Attribute;
	}

	public void setInfoType(String infoType) {
		this.Attribute = infoType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}	
}
