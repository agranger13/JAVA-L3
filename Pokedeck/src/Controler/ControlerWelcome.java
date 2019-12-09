package Controler;

import java.awt.event.ActionEvent;

import javax.swing.event.ChangeEvent;

import Model.Pokedeck;
import View.MainPanel;
import View.PanelCreateCard;
import View.PanelViewCards;
import View.PanelWelcomePage;

public class ControlerWelcome extends Controler{

	public ControlerWelcome(PanelWelcomePage panelWelcome, PanelViewCards panelViewCard,MainPanel panelMain) {
		super(panelWelcome, panelViewCard, panelMain);
		panelWelcome.addListenerButtons(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == panelWelcome.getButtonCreate()) {
			Pokedeck myPoke = new Pokedeck(panelWelcome.getNameOfPokedeck().getText());
			Pokedeck.savePokedeck(myPoke);
			panelViewCard.initView(myPoke);
			panelMain.nextCard();
		}else if(e.getSource() == panelWelcome.getButtonImport()) {
			Pokedeck myPoke = Pokedeck.importPokecdeck(panelWelcome.getNameOfPokedeck().getText());
			if(myPoke != null) {
				panelViewCard.initView(myPoke);
				panelMain.actualizeListener();
				panelMain.nextCard();
			}else {
				System.out.println("wrong name");
			}
		}else if (e.getSource() == panelMain.getButtonHome()) {
			panelViewCard.remove(0);
			panelMain.previousCard();
			panelMain.revalidate();
			panelMain.repaint();
		}else if (e.getSource() == panelMain.getButtonSave()) {
			Pokedeck.savePokedeck(panelViewCard.getMyPoke());
		}
	}

}
