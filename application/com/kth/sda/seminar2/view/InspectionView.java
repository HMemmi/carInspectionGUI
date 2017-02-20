package com.kth.sda.seminar2.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.kth.sda.seminar2.controll.InspectionController;
import com.kth.sda.seminar2.integration.CreditCardDTO;
import com.kth.sda.seminar2.integration.InspectionDTO;
import com.kth.sda.seminar2.integration.InspectionCheckListDTO;

public class InspectionView extends JFrame {
	private InspectionFormSearchPanel inspectionFormSearchPanel;
	private PaymentFormPanel paymentFormPanel;
	private InspectionCheckListPanel inspectionCheckListPanel;
	private InspectionDTO found = null;
	private ArrayList<InspectionCheckListDTO> inspectionCheckListDTO = null;
    private PrintToolbar printToolbar;
    private ElementPrint elementPrint;
    private int amount;
    private int change;
	public InspectionView(InspectionController inspectionCtrl) {

		paymentFormPanel = new PaymentFormPanel(found);
		paymentFormPanel.setVisible(false);
		
		printToolbar=new PrintToolbar();
		printToolbar.setVisible(false);
		
		elementPrint=new ElementPrint();
		elementPrint.setVisible(false);

		inspectionFormSearchPanel = new InspectionFormSearchPanel(inspectionCtrl);
		String[] displayStatusAndNumber = inspectionCtrl.startNewInspection();

		inspectionCheckListPanel = new InspectionCheckListPanel(inspectionCheckListDTO);
		inspectionCheckListPanel.setVisible(false);

		inspectionFormSearchPanel.getDisplayNumber().setText("Display number is " + displayStatusAndNumber[0]);

		inspectionFormSearchPanel.getDoorStatus().setText(displayStatusAndNumber[1]);
		inspectionFormSearchPanel.getBtnDoor().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				inspectionFormSearchPanel.getDoorStatus().setText(inspectionCtrl.closeDoor());

			}
		});

		inspectionFormSearchPanel.setActionListener(new SearchListener() {
			public void SearchEmmited(InspectionFormObject inspectionFormObject) {
				InspectionDTO inspectionDTO = new InspectionDTO(inspectionFormObject.getLicenseNumber(), "", 0);
				found = inspectionCtrl.searchMatchingLincenseNumber(inspectionDTO);
				if (found == null)
					inspectionFormSearchPanel.getCost().setText("Wrong LicenseNumber");
				else {
					inspectionFormSearchPanel.getCost().setText(String.valueOf(found.getCost()));
					paymentFormPanel.setInspectionDTO(found);
					paymentFormPanel.setVisible(true);
				}

			}
		});

		paymentFormPanel.setPaymentListener(new PaymentListener() {

			public void paymentEmmited(PaymentObject paymentObject) {
				CreditCardDTO creditCardDTO = new CreditCardDTO(paymentObject.getNumberCard());

				change = inspectionCtrl.pay(paymentObject.getInpectionDTO(), creditCardDTO,
						paymentObject.getAmount());
				amount=paymentObject.getAmount();
				paymentFormPanel.setChangeField(change);
				inspectionCheckListDTO = inspectionCtrl.getAllInspections(found);
				inspectionCheckListPanel.setInspectionCheckListDTO(inspectionCheckListDTO);
				inspectionCheckListPanel.createComponents();
				inspectionCheckListPanel.setVisible(true);
				printToolbar.setVisible(true);
				printToolbar.getPrintPay().setVisible(true);
				printToolbar.getPrintRes().setVisible(false);
			}
		});

		inspectionCheckListPanel.setCheckListListener(new CheckListListener() {

			public void checkListEmmited(CheckListObject checkListObject) {
				inspectionCtrl.addCheckList(found, checkListObject.getInspectionCheckListDTO());
				System.out.println(checkListObject.getInspectionCheckListDTO());
				printToolbar.getPrintRes().setVisible(true);
				inspectionCheckListPanel.reset();
			}
		});
		
		
		printToolbar.setListener(new PrintListener(){

			public void textEmmited(TextFromToolbar textFromToolbar) {
				if(textFromToolbar.getBtn().getText().equals("pay"))
				{
					elementPrint.setVisible(true);
					elementPrint.addText(found,amount,change,textFromToolbar.getBtn().getText());
					//elementPrint.addText(textFromToolbar.getText());
				}
				else
				{
					elementPrint.setVisible(true);
					elementPrint.addText(found);
				}
				
			}});

		setLayout(new BorderLayout());
		add(printToolbar, BorderLayout.NORTH);
		add(inspectionFormSearchPanel, BorderLayout.WEST);
		add(elementPrint, BorderLayout.CENTER);
		add(paymentFormPanel, BorderLayout.EAST);
		add(inspectionCheckListPanel, BorderLayout.SOUTH);

	}

}
