package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Vue.PanelClavier;
import Vue.PanelEcran;

public class ControleurCalcul implements ActionListener{
	private PanelEcran pEcran;
	private PanelClavier pClavier;
	
	private String tempOpe = "";
	private String tempVal = "";
	
	public ControleurCalcul( PanelEcran pEcran, PanelClavier pClavier) {
		this.pEcran = pEcran;
		this.pClavier = pClavier;
		
		pClavier.addListenerClavier(this);
	}

	public void actionPerformed(ActionEvent e) {
		JButton []operations = pClavier.getOperationsBoutons();
		
		if(e.getSource() == operations[4]) {
			
		}
		
		for(int i = 0; i < 4; i++) {
			if(e.getSource() == operations[i]) {
				
				if(tempOpe.length()==0) {
					tempOpe += operations[i].getText();
					tempVal = pEcran.getLabelResultat().getText();
					pEcran.getLabelResultat().setText("0.00");
				}
			}			
		}
		
		JButton []touches = pClavier.getTouches();
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == touches[i]) {
				String rString = pEcran.getLabelResultat().getText();
				if(Double.parseDouble(rString) == 0) {
					rString = "";
				}
				
				pEcran.getLabelResultat().setText(rString+touches[i].getText());
			}			
		}
	}	
	
	
}