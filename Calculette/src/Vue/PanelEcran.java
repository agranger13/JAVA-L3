package Vue;

import java.awt.Color;

import javax.swing.*;

public class PanelEcran extends JPanel{
	private double resultat;
	private JLabel labelResultat;
	
	PanelEcran(){
		setBackground(Color.cyan);
		
		resultat = 0;
		labelResultat = new JLabel(Double.toString(resultat));
		
		add(labelResultat);
	}

	public double getResultat() {
		return resultat;
	}

	public void setResultat(double resultat) {
		this.resultat = resultat;
	}

	public JLabel getLabelResultat() {
		return labelResultat;
	}
	
}
