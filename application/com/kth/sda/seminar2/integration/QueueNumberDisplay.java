package com.kth.sda.seminar2.integration;

public class QueueNumberDisplay {

	private int number;
	
	public QueueNumberDisplay(int number) {
	this.number=number;
	}
	
	public String[] increment(GarageDoor garageDoor){
		String[] doorStatus=new String[2];
		
		doorStatus[0]=String.valueOf(this.number++);
		doorStatus[1]=garageDoor.openDoor();
		return doorStatus;
		
	}
	

}
