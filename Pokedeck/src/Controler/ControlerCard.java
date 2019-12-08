package Controler;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Model.Attack;
import Model.Card;
import Model.EnergyCard;
import Model.Pokedeck;
import Model.PokemonCard;
import Model.TrainerCard;
import View.MainPanel;
import View.PanelCreateCard;
import View.PanelViewCards;
import View.PanelWelcomePage;

public class ControlerCard extends Controler implements ChangeListener{

	public ControlerCard( PanelViewCards panelViewCard, PanelCreateCard panelCreateCard, MainPanel panelMain) {
		super(panelViewCard, panelCreateCard, panelMain);
		panelViewCard.addListenerButtons(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		ArrayList<JButton[]> buttons = panelViewCard.getButtons();
		for(int i = 0; i<buttons.size(); i++) {
			JButton[] buttonCard = buttons.get(i);
			if(e.getSource() == buttonCard[0]) {
				Pokedeck myPoke = panelViewCard.getMyPoke();
				Card card = myPoke.getCard(i);
				String test = card.getClass().getSimpleName();
				
				if(test.compareTo("EnergyCard")==0) {
					panelCreateCard.selectTab(1);
					panelCreateCard.setInputsEnergy(0, card.getCardName());
					panelCreateCard.setInputsEnergy(1, card.getType());
					
				}else if(test.compareTo("PokemonCard")==0) {
					panelCreateCard.selectTab(0);
					panelCreateCard.setInputsPokemon(0, card.getCardName());
					panelCreateCard.setInputsPokemon(1, card.getType());
					panelCreateCard.setInputsPokemon(2, ((PokemonCard) card).getHp()+"");
					
					ArrayList<Attack> attacks = ((PokemonCard) card).getAttacks();
					for(int j = 0; j< attacks.size(); j++) {
						panelCreateCard.addAttack();
						panelCreateCard.setInputsAttacks(j,0, attacks.get(j).getName());
						panelCreateCard.setInputsAttacks(j,1, attacks.get(j).getPower()+"");
						panelCreateCard.setInputsAttacks(j,2, attacks.get(j).getDesc());
					}
					
				}else if(test.compareTo("TrainerCard")==0) {
					panelCreateCard.selectTab(2);
					panelCreateCard.setInputsTrainer(0, card.getCardName());
					panelCreateCard.setInputsTrainer(1, card.getType());
					panelCreateCard.setInputsTrainer(2, ((TrainerCard) card).getText());
					panelCreateCard.setInputsTrainer(3, ((TrainerCard) card).getTrainerRule());
				}
				
				panelCreateCard.setICard(i);
				break;
			}else if(e.getSource() == buttonCard[1]) {
				Pokedeck myPoke = panelViewCard.getMyPoke();
				myPoke.removeCard(i);
				panelViewCard.remove(0);
				panelViewCard.initView(myPoke);
				panelViewCard.addListenerButtons(this);
				panelViewCard.revalidate();
				break;
			}
			
		}
		
	}

	public void actualizeListener() {
		panelViewCard.addListenerButtons(this);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		panelMain.revalidate();
		panelMain.repaint();
	}
}
