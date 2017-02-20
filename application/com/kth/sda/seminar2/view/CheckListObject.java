package com.kth.sda.seminar2.view;

import java.util.ArrayList;

import com.kth.sda.seminar2.integration.InspectionCheckListDTO;

public class CheckListObject {
	ArrayList<InspectionCheckListDTO> inspectionCheckListDTO;
	public CheckListObject(ArrayList<InspectionCheckListDTO> inspectionCheckListDTO){
		this.inspectionCheckListDTO=inspectionCheckListDTO;
		
	}
	public ArrayList<InspectionCheckListDTO> getInspectionCheckListDTO() {
		return inspectionCheckListDTO;
	}
	public void setInspectionCheckListDTO(ArrayList<InspectionCheckListDTO> inspectionCheckListDTO) {
		this.inspectionCheckListDTO = null;
	}
	

	
	
}
