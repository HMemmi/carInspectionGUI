package com.kth.sda.seminar2.integration;

public class InspectionCheckListDTO {

	private String operation ;
	private boolean result;
	
	public InspectionCheckListDTO(String operation, boolean result) {
		this.operation=operation;
		this.result=result;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
	public String toString(){
		return "Operation= "+this.getOperation()+" result= "+this.getResult()+"\n";
	}
	
	
	
}
