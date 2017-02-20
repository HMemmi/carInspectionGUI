package com.kth.sda.seminar2.integration;

import java.util.ArrayList;
import java.util.HashMap;

public class InspectionDTO {
	private String licenseNumber;
	private String desc;
	private int cost;
	private ArrayList<InspectionCheckListDTO> inspectionCheckListDTO;
	
	
	public InspectionDTO(String licenseNumber,String desc,int cost){
		this.licenseNumber=licenseNumber;
		this.desc=desc;
		this.cost=cost;
		inspectionCheckListDTO=new ArrayList<>();
		addToList();
	}

	private void addToList() {
		InspectionCheckListDTO inspectionCheckList1=new InspectionCheckListDTO("inspection1", true);
		InspectionCheckListDTO inspectionCheckList2=new InspectionCheckListDTO("inspection2", true);
		InspectionCheckListDTO inspectionCheckList3=new InspectionCheckListDTO("inspection3", true);
		InspectionCheckListDTO inspectionCheckList4=new InspectionCheckListDTO("inspection4", true);
		InspectionCheckListDTO inspectionCheckList5=new InspectionCheckListDTO("inspection5", true);
		InspectionCheckListDTO inspectionCheckList6=new InspectionCheckListDTO("inspection6", true);
		InspectionCheckListDTO inspectionCheckList7=new InspectionCheckListDTO("inspection7", true);
		InspectionCheckListDTO inspectionCheckList8=new InspectionCheckListDTO("inspection8", true);
		InspectionCheckListDTO inspectionCheckList9=new InspectionCheckListDTO("inspection9", true);
		InspectionCheckListDTO inspectionCheckList10=new InspectionCheckListDTO("inspection6", true);
		InspectionCheckListDTO inspectionCheckList11=new InspectionCheckListDTO("inspection7", true);
		InspectionCheckListDTO inspectionCheckList12=new InspectionCheckListDTO("inspection8", true);
		InspectionCheckListDTO inspectionCheckList13=new InspectionCheckListDTO("inspection9", true);
		inspectionCheckListDTO.add(inspectionCheckList1);
		inspectionCheckListDTO.add(inspectionCheckList2);
		inspectionCheckListDTO.add(inspectionCheckList3);
		inspectionCheckListDTO.add(inspectionCheckList4);
		inspectionCheckListDTO.add(inspectionCheckList5);
		inspectionCheckListDTO.add(inspectionCheckList6);
		inspectionCheckListDTO.add(inspectionCheckList7);
		inspectionCheckListDTO.add(inspectionCheckList8);
		inspectionCheckListDTO.add(inspectionCheckList9);
		inspectionCheckListDTO.add(inspectionCheckList10);
		inspectionCheckListDTO.add(inspectionCheckList11);
		inspectionCheckListDTO.add(inspectionCheckList12);
		inspectionCheckListDTO.add(inspectionCheckList13);
;
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

	public ArrayList<InspectionCheckListDTO> getInspectionCheckList() {
		return this.inspectionCheckListDTO;
	}

	public void setInspectionCheckList(ArrayList<InspectionCheckListDTO> inspectionCheckListDTO) {
		this.inspectionCheckListDTO = inspectionCheckListDTO;
	}



	

}
