package com.kth.sda.seminar2.view;

import com.kth.sda.seminar2.integration.InspectionDTO;
import com.kth.sda.seminar2.model.Inspection;

public class PaymentObject {
	private InspectionDTO inspectionDTO;
	private int numberCard;
	private int amount;
	
	public PaymentObject(InspectionDTO inpectionDTO,int numberCard, int amount) {
	this.inspectionDTO=inpectionDTO;
	this.numberCard=numberCard;
	this.amount=amount;
	}

	public int getNumberCard() {
		return numberCard;
	}

	public int getAmount() {
		return amount;
	}

	public InspectionDTO getInpectionDTO() {
		return this.inspectionDTO;
	}
	
	
	
	

}
