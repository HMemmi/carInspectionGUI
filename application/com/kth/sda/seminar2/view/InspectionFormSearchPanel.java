package com.kth.sda.seminar2.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.kth.sda.seminar2.controll.InspectionController;

public class InspectionFormSearchPanel extends JPanel {

	private JLabel licenseNumber;
	private JLabel doorStatus;
	private JLabel displayNumber;
	private JTextField licenseNumberField;
	private JTextField cost;
	private JButton btn;
	private JButton btndoor;
	private SearchListener searchListener;
	private InspectionFormObject inspectionFormObject;
	private InspectionController inspectionCtrl;

	public InspectionFormSearchPanel(InspectionController inspectionCtrl) {

		this.inspectionCtrl = inspectionCtrl;

		createComponents();

		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (licenseNumberField.getText().length() > 0) {
					inspectionFormObject = new InspectionFormObject(licenseNumberField.getText(), "", 0);
				}
				if (inspectionFormObject != null) {
					searchListener.SearchEmmited(inspectionFormObject);
				}

			}
		});

	}

	private void createComponents() {

		licenseNumber = new JLabel("LiceseNumber");
		doorStatus = new JLabel();
		displayNumber = new JLabel();
		licenseNumberField = new JTextField(10);
		cost = new JTextField(10);
		btn = new JButton("cost");
		btndoor = new JButton("close");

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		add(displayNumber, gc);

		// new row
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		add(doorStatus, gc);

		gc.gridx = 1;
		gc.gridy = 1;

		add(btndoor, gc);

		// new row
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		add(licenseNumber, gc);

		// new row

		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		add(licenseNumberField, gc);

		// new row
		gc.gridx = 1;
		gc.gridy = 3;
		add(cost, gc);

		gc.gridx = 1;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(btn, gc);

		Border out = BorderFactory.createTitledBorder("Search Inspection");
		Border inner = BorderFactory.createEtchedBorder();
		setBorder(BorderFactory.createCompoundBorder(out, inner));
		// new Row

	}

	public JTextField getCost() {
		return cost;
	}

	public JButton getBtnDoor() {
		return btndoor;
	}

	public JLabel getDisplayNumber() {
		return displayNumber;
	}

	public JLabel getDoorStatus() {
		return doorStatus;
	}

	public void setActionListener(SearchListener searchListener) {
		this.searchListener = searchListener;

	}

}
