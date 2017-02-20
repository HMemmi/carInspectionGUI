package com.kth.sda.seminar2.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.kth.sda.seminar2.integration.InspectionDTO;

public class PaymentFormPanel extends JPanel implements ActionListener {

	private JLabel credicardNumber;
	private JLabel amount;
	private JTextField credicardNumberField;
	private JTextField amountField;
	private JButton btn;
	private PaymentListener paymentListener;
	private PaymentObject paymentObject;
	private InspectionDTO inspectionDTO;
	private JTextField changeField;
	private JLabel change;

	public PaymentFormPanel(InspectionDTO found) {
		this.inspectionDTO=found;
		credicardNumber = new JLabel("Number");
		amount = new JLabel("amount");
		credicardNumberField = new JTextField(10);
		amountField = new JTextField(10);
		changeField = new JTextField(10);
		change = new JLabel();
		btn = new JButton("Pay");
		btn.addActionListener(this);
		

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		add(credicardNumber, gc);
		// new row
		gc.gridx = 1;
		gc.gridy = 0;
		add(credicardNumberField, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		add(amount, gc);

		// new row
		gc.gridx = 1;
		gc.gridy = 1;
		add(amountField, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(btn, gc);

		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		add(change, gc);

		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		add(changeField, gc);

		Border out = BorderFactory.createTitledBorder("Pay for Inspection");
		Border inner = BorderFactory.createEtchedBorder();
		setBorder(BorderFactory.createCompoundBorder(out, inner));

	}

	public void actionPerformed(ActionEvent e) {

		if ((credicardNumberField.getText().length() > 0) && (amount.getText().length() > 0)) {
			int credicardNumber = Integer.parseInt(credicardNumberField.getText());
			int amount = Integer.parseInt(amountField.getText());
			paymentObject = new PaymentObject(inspectionDTO, credicardNumber, amount);

		}
		if (paymentObject != null) {
			paymentListener.paymentEmmited(paymentObject);
		}

	}

	public void setPaymentListener(PaymentListener paymentListener) {
		this.paymentListener = paymentListener;

	}

	public void setChangeField(int text) {
		this.changeField.setText(String.valueOf(text));
		
	}

	public void setInspectionDTO(InspectionDTO inspectionDTO) {
		this.inspectionDTO = inspectionDTO;
	}
	
	

}
