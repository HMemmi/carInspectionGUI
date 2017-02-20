package com.kth.sda.seminar2.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.kth.sda.seminar2.view.InspectionCheckListPanel;

public class Inspection {
	private String licenseNumber;
	private String desc;
	private int cost;
	
	private HashMap<String,InspectionCheckListPanel> inspectionCheckListPanel;
	
	public Inspection(String licenseNumber,String desc,int cost){
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

	public HashMap<String, InspectionCheckListPanel> getInspectionCheckList() {
		return inspectionCheckListPanel;
	}

	public int pay(int amount) {
		return amount-this.cost;
		
	}



	

}
