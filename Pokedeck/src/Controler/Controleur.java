package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Pokedeck;
import View.MainPanel;
import View.PanelViewCards;
import View.PanelWelcomePage;

public class Controleur implements ActionListener{
	private PanelWelcomePage panelWelcome;
	private PanelViewCards panelViewCard;
	private MainPanel panelMain;
	
	public Controleur(PanelWelcomePage panelWelcome, PanelViewCards panelViewCard, MainPanel panelMain) {
		this.panelWelcome = panelWelcome;
		this.panelViewCard = panelViewCard;
		this.panelMain = panelMain;
		
		panelWelcome.addListenerButtons(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == panelWelcome.getButtonCreate()) {
			Pokedeck myPoke = new Pokedeck(panelWelcome.getNameOfPokedeck().getText());
			Pokedeck.savePokedeck(myPoke);
			panelMain.nextCard();
		}else if(e.getSource() == panelWelcome.getButtonImport()) {
			Pokedeck myPoke = Pokedeck.importPokecdeck(panelWelcome.getNameOfPokedeck().getText());
			if(myPoke != null) {
				panelMain.nextCard();
			}else {
				System.out.println("wrong name");
			}
		}
	}

}
