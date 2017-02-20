package com.kth.sda.seminar2.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.kth.sda.seminar2.controll.InspectionController;

public class View extends JFrame {
	private InspectionView inspectionView;

	private InspectionController inspectionCtrl;

	public View(InspectionController inspectionCtrl) {
		super("view");// sending a String to the sup constructor for naming the
						// Frame

		this.inspectionCtrl = inspectionCtrl;
		
		
		JLabel starts=new JLabel("Press ctrl_s to start new inspection");
		JLabel exits=new JLabel("Press ctrl_x to close the application");
		
		
		JPanel p=new JPanel();
		BoxLayout b=new BoxLayout(p,BoxLayout.Y_AXIS);
		p.setLayout(b);
		p.add(starts);
	
		p.add(exits);
	
		setLayout(new BorderLayout());
		add(p,BorderLayout.CENTER);
		
		setJMenuBar(toolbar());
		setVisible(true);
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JMenuBar toolbar() {

		JMenuBar menuBar = new JMenuBar();
		JMenu inspection = new JMenu("Inspection");
		JMenuItem start = new JMenuItem("Start");
		JMenuItem exit = new JMenuItem("Exit");
		inspection.add(start);
		inspection.add(exit);
		menuBar.add(inspection);
		
		inspection.setMnemonic(KeyEvent.VK_I);
		start.setMnemonic(KeyEvent.VK_S);
		start.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		exit.setMnemonic(KeyEvent.VK_X);
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}});
		
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inspectionView = new InspectionView(inspectionCtrl);
				inspectionView.setTitle("Add new Component");
				inspectionView.setSize(700, 500);
				inspectionView.setResizable(false);
				inspectionView.setVisible(true);
				// inspectionView.setDefaultCloseOperation(1);

			}
		});

		return menuBar;

	}

}
