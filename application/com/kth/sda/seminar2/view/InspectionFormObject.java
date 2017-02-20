package com.kth.sda.seminar2.view;

public class InspectionFormObject {
	private String licenseNumber;
	private String desc;
	private int cost;
	public InspectionFormObject(String licenseNumber,String desc,int cost){
		this.licenseNumber=licenseNumber;
		this.desc=desc;
		this.cost=cost;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public String getDesc() {
		return desc;
	}
	public int getCost() {
		return cost;
	}
	
	

}
