package com.kth.sda.seminar2.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.kth.sda.seminar2.integration.InspectionDTO;

public class ElementPrint extends JPanel {
	JTextArea h;
	public ElementPrint(){
		h=new JTextArea();
		setLayout(new BorderLayout() );
		add(new JScrollPane(h),BorderLayout.CENTER);
	}
	
	
	public void addText(InspectionDTO found, int amount, int change, String text) {
	h.setText(null);
	h.append("Receipt for you inspection\n");
	h.append("licenseNumber= "+found.getLicenseNumber()+"\n");	
	h.append("price= "+found.getCost()+"\n");
	h.append("Amount= "+amount+"\n");
	h.append("change= "+change+"\n");
	//h.append(text);
	}



	public void addText(InspectionDTO found) {
		h.setText(null);
		h.append("Receipt for you inspection\n");
		h.append("licenseNumber= "+found.getLicenseNumber()+"\n");	
		h.append("price= "+found.getCost()+"\n");
		h.append("CheckListInspection= "+found.getInspectionCheckList()+"\n");
		
		
	}

}
