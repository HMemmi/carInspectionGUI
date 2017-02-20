package com.kth.sda.seminar2.integration;

import java.util.ArrayList;

public class InspectionRegistry {
	private ArrayList<InspectionDTO> inspections;
	
	
	public InspectionRegistry(){
		InspectionDTO ins1=new InspectionDTO("126","dddd",55);
		inspections=new ArrayList<>();
		inspections.add(ins1);
	}

	public InspectionDTO searchMatching(InspectionDTO inspection) {
		for(InspectionDTO i:inspections)
		{
		if(inspection.getLicenseNumber().equals(i.getLicenseNumber()))
		{System.out.println(inspection.getLicenseNumber());
		System.out.println(i.getLicenseNumber());
			return i;}
		}
		return null;
		
	}
	
	

}
