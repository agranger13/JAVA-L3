package View;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.swing.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Controler.Controler;
import Controler.ControlerCard;
import Controler.ControlerEditCreate;
import Controler.ControlerWelcome;
import Model.Card;
import Model.CardAdapterJson;
import Model.Pokedeck;

public class MainPanel extends JPanel{
	private Image img;
	private JPanel cardPanel = new JPanel();
	private CardLayout cardLayout = new CardLayout();
	private Controler c1;
	private ControlerCard c2;
	private Controler c3;
	private PanelViewCards panelLeft;
	private PanelCreateCard panelRight;
	private PanelWelcomePage panelWelcome;
	
	private JButton buttonHome;
	private JButton buttonSave;
	
	MainPanel(){
		cardPanel.setLayout(cardLayout);
		
		panelWelcome = new PanelWelcomePage();
		
		JPanel panelCardChoice = new JPanel();
		panelLeft = new PanelViewCards();
		panelRight = new PanelCreateCard();
		c1 = new ControlerWelcome(panelWelcome, panelLeft, this);
		this.img = new ImageIcon(System.getProperty("user.dir")+"\\ressources\\BG_Pokedeck.png").getImage();
		cardPanel.setBackground(new Color(0,0,0,0));
		cardPanel.add(panelWelcome,"welcome");
		
		panelCardChoice.add(panelLeft,BorderLayout.WEST);
		panelCardChoice.add(panelRight,BorderLayout.EAST);
		panelCardChoice.setBackground(new Color(0,0,0,0));
		
		buttonHome = new JButton("Home");
		buttonSave = new JButton("Save my Pokedeck");
		panelCardChoice.add(buttonHome);
		panelCardChoice.add(buttonSave);
		buttonHome.addActionListener(c1);
		buttonSave.addActionListener(c1);
		
		cardPanel.add(panelCardChoice,"listCard");
		add(cardPanel);
	}

	
	public JButton getButtonHome() {
		return buttonHome;
	}


	public JButton getButtonSave() {
		return buttonSave;
	}


	public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
        
    }
	
	public void nextCard() {
		cardLayout.next(cardPanel);
		c2 = new ControlerCard( panelLeft, panelRight,this);
		c3 = new ControlerEditCreate( panelLeft, panelRight, this);
	}
	
	public void previousCard() {
		cardLayout.first(cardPanel);
	}
	
	public void actualizeListener() {
		c2.actualizeListener();
	}
}
