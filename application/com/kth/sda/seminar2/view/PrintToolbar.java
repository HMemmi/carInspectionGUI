package com.kth.sda.seminar2.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PrintToolbar extends JPanel implements ActionListener{
	
	JButton printPay;
	JButton printRes;
	PrintListener printListener ;
	
	public PrintToolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new FlowLayout(FlowLayout.CENTER));
		printPay = new JButton("pay");
		printRes = new JButton("result");
		
		printPay.addActionListener(this);
		printRes.addActionListener(this);
		
		
		add(printPay);
		add(printRes);

	}
	public JButton getPrintPay() {
		return printPay;
	}
	public JButton getPrintRes() {
		return printRes;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		JButton clicked = (JButton) e.getSource();
		TextFromToolbar textFromToolbar;
	
		textFromToolbar=new TextFromToolbar(clicked);
		
			
		
		if(printListener!=null)
		{
		printListener.textEmmited(textFromToolbar);
		}
			
		
	}
	public void setListener(PrintListener printListener) {
		this.printListener=printListener;
		
	}
	


}
