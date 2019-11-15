package Vue;

import java.awt.*;
import javax.swing.*;

import Controleur.ControleurCalcul;

public class PanelFils extends JPanel{
	protected ControleurCalcul c;
	PanelFils(){	
		
		JPanel panelRight = new JPanel(new BorderLayout());
		JPanel panelLeft = new JPanel();
		
		PanelEcran panEcran = new PanelEcran();
		PanelClavier panClavier = new PanelClavier();
		
		c = new ControleurCalcul(panEcran, panClavier);
		
		panelRight.add(panEcran,BorderLayout.NORTH);
		panelRight.add(panClavier,BorderLayout.CENTER);
		
		add(panelLeft,BorderLayout.WEST);
		add(panelRight,BorderLayout.CENTER);
	}
	
}
