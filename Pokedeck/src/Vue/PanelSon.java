package Vue;

import java.awt.*;
import javax.swing.*;

//import Controleur.ControleurCalcul;

public class PanelSon extends JPanel{
	//protected ControleurCalcul c;
	private Image img;
	PanelSon(){			
		PanelViewCards panelRight = new PanelViewCards();
		//c = new ControleurCalcul(panEcran, panClavier);
		initBackground(new ImageIcon(System.getProperty("user.dir")+"\\ressources\\BG_Pokedeck.png").getImage());
		
	}
	public void initBackground(Image img) {
		this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
