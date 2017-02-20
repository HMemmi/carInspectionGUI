package com.kth.sda.seminar2.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.kth.sda.seminar2.integration.InspectionCheckListDTO;

public class InspectionCheckListPanel extends JPanel {

	private ArrayList<InspectionCheckListDTO> inspectionCheckListDTO;
	private JButton btn;
	private CheckListListener checkListListener;
	private ArrayList<InspectionCheckListDTO> checkListAfterMod;
	private HashMap<String, JComboBox<Boolean>> lists;

	public InspectionCheckListPanel(ArrayList<InspectionCheckListDTO> inspectionCheckListDTO) {
		checkListAfterMod = new ArrayList<>();
		lists = new HashMap<>();
		btn = new JButton("check");
		

		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if (checkListListener != null) {
					for (String s : lists.keySet()) {
						checkListAfterMod.add(new InspectionCheckListDTO(s, (Boolean) lists.get(s).getSelectedItem()));

					}
					CheckListObject checkListObject = new CheckListObject(checkListAfterMod);
					if(checkListObject!=null)
					{
					checkListListener.checkListEmmited(checkListObject);
					}
				}

			}
		});

		createComponents();

		Border out = BorderFactory.createTitledBorder("set Check List");
		Border inner = BorderFactory.createEtchedBorder();
		setBorder(BorderFactory.createCompoundBorder(out, inner));

	}

	public void createComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		int i = 0;
		int y = 0;
		if (inspectionCheckListDTO != null) {
			int x = 0;

			while (i < inspectionCheckListDTO.size()) {
				while ((x < 7) && i < inspectionCheckListDTO.size()) {
			
					gc.gridx = x;
					gc.gridy = y;
					gc.weightx=0;
					gc.insets=new Insets(0,5,0,5);
					gc.fill=GridBagConstraints.BOTH;
					
					gc.anchor = GridBagConstraints.LINE_START;

					add(new JLabel(inspectionCheckListDTO.get(i).getOperation()), gc);
					
					gc.fill=GridBagConstraints.BOTH;
					gc.anchor = GridBagConstraints.LINE_END;
					gc.insets=new Insets(5,5,5,0);
					gc.gridx = x+1;
					gc.gridy = y;
				

					JComboBox<Boolean> combo = new JComboBox<>();
					combo.addItem(true);
					combo.addItem(false);
					lists.put(inspectionCheckListDTO.get(i).getOperation(), combo);
					add(combo, gc);
					
					x=x+2;
					
					i++;
				}

				if (i < inspectionCheckListDTO.size())
					x = 0;
				y++;

			}

			gc.gridx = 1;
			gc.gridy = y + 1;
			add(btn, gc);
		}

	}

	public void setInspectionCheckListDTO(ArrayList<InspectionCheckListDTO> inspectionCheckListDTO) {
		this.inspectionCheckListDTO = inspectionCheckListDTO;

	}

	public void setCheckListListener(CheckListListener checkListListener) {
		this.checkListListener = checkListListener;

	}

	public void reset(){
		checkListAfterMod=new ArrayList<>();
	}
}
