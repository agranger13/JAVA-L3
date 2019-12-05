package View;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.swing.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Controler.Controleur;
import Model.Card;
import Model.CardAdapterJson;
import Model.Pokedeck;

public class MainPanel extends JPanel{
	private Image img;
	private JPanel cardPanel = new JPanel();
	private CardLayout cardLayout = new CardLayout();
	private Pokedeck pokedeck;
	private Controleur c;	
	
	MainPanel(){
		cardPanel.setLayout(cardLayout);
		
		PanelWelcomePage panelWelcome = new PanelWelcomePage();
		PanelViewCards panelRight = new PanelViewCards();

		c = new Controleur(panelWelcome, panelRight, this);
		this.img = new ImageIcon(System.getProperty("user.dir")+"\\ressources\\BG_Pokedeck.png").getImage();
		cardPanel.setOpaque(false);
		cardPanel.add(panelWelcome,"welcome");
		cardPanel.add(panelRight,"listCard");
		add(cardPanel);
	}

	
	public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
        
    }
	
	public void nextCard() {
		cardLayout.next(cardPanel);
	}
	
}
