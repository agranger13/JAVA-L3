package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Vue.PanelClavier;
import Vue.PanelEcran;

public class ControleurCalcul implements ActionListener{
	private PanelEcran pEcran;
	private PanelClavier pClavier;
	
	public ControleurCalcul( PanelEcran pEcran, PanelClavier pClavier) {
		this.pEcran = pEcran;
		this.pClavier = pClavier;
		
		pClavier.addListenerClavier(this);
	}

	public void actionPerformed(ActionEvent e) {
		JButton []touches = pClavier.getTouches();
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == touches[i]) {
				String rString = pEcran.getLabelResultat().getText();
				if(rString.contains(".")) {
					rString = "";
				}
				
				pEcran.getLabelResultat().setText(rString+touches[i].getText());
			}
			
		}
	}	
	
	
}
