package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeListener;

import Model.Pokedeck;
import View.MainPanel;
import View.PanelCreateCard;
import View.PanelViewCards;
import View.PanelWelcomePage;

public abstract class Controler implements ActionListener{
	protected PanelWelcomePage panelWelcome;
	protected PanelViewCards panelViewCard;
	protected PanelCreateCard panelCreateCard;
	protected MainPanel panelMain;
	
	public Controler(PanelWelcomePage panelWelcome, PanelViewCards panelViewCard, MainPanel panelMain) {
		this.panelWelcome = panelWelcome;
		this.panelViewCard = panelViewCard;
		this.panelMain = panelMain;
	}
	
	public Controler(PanelViewCards panelViewCard, PanelCreateCard panelCreateCard, MainPanel panelMain ) {
		this.panelViewCard = panelViewCard;
		this.panelCreateCard = panelCreateCard;
		this.panelMain = panelMain;
	}

	public abstract void actionPerformed(ActionEvent e);

}
