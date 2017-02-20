package com.kth.sda.seminar2.controll;

import java.util.ArrayList;

import com.kth.sda.seminar2.integration.CreditCardDTO;
import com.kth.sda.seminar2.integration.ExternalPayementAuthorizationSystem;
import com.kth.sda.seminar2.integration.GarageDoor;
import com.kth.sda.seminar2.integration.InspectionCheckList;
import com.kth.sda.seminar2.integration.InspectionCheckListDTO;
import com.kth.sda.seminar2.integration.InspectionDTO;
import com.kth.sda.seminar2.integration.InspectionRegistry;
import com.kth.sda.seminar2.integration.QueueNumberDisplay;
import com.kth.sda.seminar2.model.Inspection;

public class InspectionController {

	QueueNumberDisplay display;
	InspectionRegistry inspectionRegistry;
	GarageDoor garageDoor;
	ExternalPayementAuthorizationSystem externalPayAuthSys;

	public InspectionController(InspectionCheckList inspectionCheckList, InspectionRegistry inspectionRegistry,
			QueueNumberDisplay display, GarageDoor garageDoor, ExternalPayementAuthorizationSystem externalPayAuthSys) {
		this.display = display;
		this.inspectionRegistry = inspectionRegistry;
		this.garageDoor = garageDoor;
		this.externalPayAuthSys = externalPayAuthSys;
	}

	public String[] startNewInspection() {
		return display.increment(garageDoor);

	}

	public InspectionDTO searchMatchingLincenseNumber(InspectionDTO inspection) {

		return inspectionRegistry.searchMatching(inspection);
	}

	public String closeDoor() {
		return garageDoor.close();

	}

	public boolean request() {
		return true;
	}

	public Inspection createInspection(InspectionDTO found) {
		Inspection inspection = new Inspection(found.getLicenseNumber(), "dd", 2);
		return inspection;

	}

	public int pay(InspectionDTO inspectionDTO, CreditCardDTO creditCardDTO, int amount) {
		Inspection inspection;
		int change = 0;
		if (externalPayAuthSys.isValid(creditCardDTO)) {
			System.out.println(inspectionDTO.getCost());
			inspection = new Inspection(inspectionDTO.getLicenseNumber(), inspectionDTO.getDesc(),
					inspectionDTO.getCost());
			change = inspection.pay(amount);

		}
		return change;
	}

	public ArrayList<InspectionCheckListDTO> getAllInspections(InspectionDTO found) {
		return found.getInspectionCheckList();
		
	}

	public void addCheckList(InspectionDTO found, ArrayList<InspectionCheckListDTO> inspectionCheckListDTO) {
		found.setInspectionCheckList(inspectionCheckListDTO);
	}

}
