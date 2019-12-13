package Controler;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;

import Model.Attack;
import Model.Card;
import Model.EnergyCard;
import Model.Pokedeck;
import Model.PokemonCard;
import Model.TrainerCard;
import View.MainPanel;
import View.PanelCreateCard;
import View.PanelViewCards;

public class ControlerEditCreate extends Controler{
	public ControlerEditCreate(PanelViewCards panelViewCard, PanelCreateCard panelCreateCard, MainPanel mainPanel) {
		super(panelViewCard, panelCreateCard, mainPanel);
		panelCreateCard.addListenerAllButtons(this);
		panelCreateCard.setICard(-1);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("controleur");
		JButton[] buttonPokemon = panelCreateCard.getActionButtonsPokemon();
		JButton[] buttonEnergy = panelCreateCard.getActionButtonsEnergy();
		JButton[] buttonTrainer = panelCreateCard.getActionButtonsTrainer();
		Pokedeck myPoke = panelViewCard.getMyPoke();
		int iCard = panelCreateCard.getICard();
		
		if(e.getSource()==buttonPokemon[0]) {
			panelCreateCard.addAttack();
			
		}else if(e.getSource()==buttonPokemon[1] && iCard >= 0) {
			JTextArea[] infos = panelCreateCard.getInputsPokemon();
			ArrayList<JTextArea[]> attacksJText = panelCreateCard.getInputsAttacks();
			
			((PokemonCard) myPoke.getCard(iCard)).setCardName(infos[0].getText());
			((PokemonCard) myPoke.getCard(iCard)).setType(infos[1].getText());
			((PokemonCard) myPoke.getCard(iCard)).setHp(Integer.parseInt(infos[2].getText()));
			
			ArrayList<Attack> attacks = new ArrayList<Attack>();
			for(int i = 0; i< attacksJText.size(); i++) {
				Attack att = new Attack(attacksJText.get(i)[0].getText(),attacksJText.get(i)[2].getText(),Integer.parseInt(attacksJText.get(i)[1].getText()));
				attacks.add(att);
			}
			
			((PokemonCard) myPoke.getCard(iCard)).setAttacks(attacks);
			
		}else if(e.getSource()==buttonPokemon[2]) {
			JTextArea[] infos = panelCreateCard.getInputsPokemon();
			ArrayList<JTextArea[]> attacksJText = panelCreateCard.getInputsAttacks();
			
			String cardName = infos[0].getText();
			String type = infos[1].getText();
			int hp = Integer.parseInt(infos[2].getText());
			
			ArrayList<Attack> attacks = new ArrayList<Attack>();
			for(int i = 0; i< attacksJText.size(); i++) {
				Attack att = new Attack(attacksJText.get(i)[0].getText(),attacksJText.get(i)[2].getText(),Integer.parseInt(attacksJText.get(i)[1].getText()));
				attacks.add(att);
			}
			
			PokemonCard card = new PokemonCard(cardName, "", type, hp, attacks);
			myPoke.addCard(card);
			
		}else if(e.getSource()==buttonEnergy[0] && iCard >= 0) {
			JTextArea[] infos = panelCreateCard.getInputsEnergy();
			
			((EnergyCard) myPoke.getCard(iCard)).setCardName(infos[0].getText());
			((EnergyCard) myPoke.getCard(iCard)).setType(infos[1].getText());
			
		}else if(e.getSource()==buttonEnergy[1]) {
			JTextArea[] infos = panelCreateCard.getInputsEnergy();
			String cardName = infos[0].getText();
			String type = infos[1].getText();
			
			EnergyCard card = new EnergyCard(cardName, "", type);
			myPoke.addCard(card);
			
		}else if(e.getSource()==buttonTrainer[0] && iCard >= 0) {
			JTextArea[] infos = panelCreateCard.getInputsTrainer();
			
			((TrainerCard) myPoke.getCard(iCard)).setCardName(infos[0].getText());
			((TrainerCard) myPoke.getCard(iCard)).setType(infos[1].getText());
			((TrainerCard) myPoke.getCard(iCard)).setText(infos[2].getText());
			((TrainerCard) myPoke.getCard(iCard)).setTrainerRule(infos[3].getText());
			System.out.println(myPoke.getCard(iCard).toString());
		}else if(e.getSource()==buttonTrainer[1]) {
			JTextArea[] infos = panelCreateCard.getInputsTrainer();
			String cardName = infos[0].getText();
			String type = infos[1].getText();
			String text = infos[2].getText();
			String trainerRule = infos[3].getText();
			
			TrainerCard card = new TrainerCard(cardName, "", type,text,trainerRule);
			myPoke.addCard(card);
		}

		panelViewCard.remove(0);
		panelViewCard.initView(myPoke);
		panelMain.actualizeListener();
		
		panelMain.revalidate();
		panelMain.repaint();
	}

}
