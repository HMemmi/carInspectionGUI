package com.kth.sda.seminar2.startup;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import javax.swing.SwingUtilities;

import com.kth.sda.seminar2.controll.InspectionController;
import com.kth.sda.seminar2.integration.ExternalPayementAuthorizationSystem;
import com.kth.sda.seminar2.integration.GarageDoor;
import com.kth.sda.seminar2.integration.InspectionCheckList;
import com.kth.sda.seminar2.integration.InspectionRegistry;
import com.kth.sda.seminar2.integration.Printer;
import com.kth.sda.seminar2.integration.QueueNumberDisplay;
import com.kth.sda.seminar2.view.View;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				InspectionRegistry inspectionRegistry=new InspectionRegistry();
				InspectionCheckList inspectionCheckList=new InspectionCheckList();
				ExternalPayementAuthorizationSystem externalPayAuthSys=new ExternalPayementAuthorizationSystem();
				QueueNumberDisplay display=new QueueNumberDisplay(1);
				Printer printer=new Printer();
				GarageDoor garageDoor=new GarageDoor();
				
				//PaymentController payCtrl=new PaymentController(externalPayAuthSys,printer);
				InspectionController inspectionCtrl=new InspectionController(inspectionCheckList,inspectionRegistry,display,garageDoor,externalPayAuthSys);	
				new View(inspectionCtrl);
			}
		});
		}

}
