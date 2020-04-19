package View;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import Controler.Controler;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

public class PanelCreateCard extends JPanel {
	private String []arrayCard = {"Pokemon","Energy","Trainer"};
	private JTabbedPane panelCard;
	
	private JPanel panelPokemon;
	private JPanel panelEnergy;
	private JPanel panelTrainer;
	
	private JTextArea[] inputsPokemon;
	private JTextArea[] inputsEnergy;
	private JTextArea[] inputsTrainer;
	private ArrayList<JTextArea[]> inputsAttacks; 

	private JButton[] actionButtonsPokemon;
	private JButton[] actionButtonsEnergy;
	private JButton[] actionButtonsTrainer;
	
	private int iCard = -1;
	public PanelCreateCard() {
		setBackground(new Color(0,0,0,0));
		panelCard = new JTabbedPane();	
		createTabPokemon();
		createTabEnergy();
		createTabTrainer();
		panelCard.addTab(arrayCard[0],panelPokemon);
		panelCard.addTab(arrayCard[1],panelEnergy);
		panelCard.addTab(arrayCard[2],panelTrainer);
		add(panelCard);
	}

	private void createTabPokemon() {
		panelPokemon = new JPanel();
		panelPokemon.setBackground(new Color(0,0,0,0));
		panelPokemon.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		inputsAttacks = new ArrayList<JTextArea[]>();
		inputsPokemon = new JTextArea[3];
		
		inputsPokemon[0] = new JTextArea(1,20);
		inputsPokemon[1] = new JTextArea(1,10);
		inputsPokemon[2] = new JTextArea(1,5);
		
		gbc.insets = new Insets(1,1,1,1);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelPokemon.add(new JLabel("Card name : "),gbc);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		panelPokemon.add(inputsPokemon[0],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelPokemon.add(new JLabel("Type : "),gbc);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		panelPokemon.add(inputsPokemon[1],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelPokemon.add(new JLabel("HP : "),gbc);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		panelPokemon.add(inputsPokemon[2],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelPokemon.add(new JLabel("Attack : "),gbc);

		
		actionButtonsPokemon = new JButton[3];
		actionButtonsPokemon[0] = new JButton("+");
		gbc.gridx = 4;
		panelPokemon.add(actionButtonsPokemon[0],gbc);
		
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridy = 8;
		gbc.gridx= 2;
		actionButtonsPokemon[1] = new JButton("Edit");
		panelPokemon.add(actionButtonsPokemon[1],gbc);
		gbc.gridx= 3;
		actionButtonsPokemon[2] = new JButton("Create");
		panelPokemon.add(actionButtonsPokemon[2],gbc);
		
	}
	
	public void addAttack() {
		GridBagConstraints gbc = new GridBagConstraints();
		
		JTextArea nameAttack = new JTextArea(1,10);
		JTextArea powerAttack = new JTextArea(1,5);
		JTextArea descAttack = new JTextArea(2,15);
		
		inputsAttacks.add(new JTextArea[] {nameAttack, powerAttack, descAttack});
		
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		gbc.gridy = 2+inputsAttacks.size();
		panelPokemon.add(inputsAttacks.get(inputsAttacks.size()-1)[0],gbc);
		gbc.gridx = 2;
		panelPokemon.add(inputsAttacks.get(inputsAttacks.size()-1)[1],gbc);
		gbc.gridx = 3;
		panelPokemon.add(inputsAttacks.get(inputsAttacks.size()-1)[2],gbc);
	}
	
	private void createTabEnergy() {
		panelEnergy = new JPanel();
		panelEnergy.setLayout(new GridBagLayout());
		panelEnergy.setBackground(new Color(0,0,0,0));
		GridBagConstraints gbc = new GridBagConstraints();
		inputsEnergy = new JTextArea[2];
		
		inputsEnergy[0] = new JTextArea(1,20);
		inputsEnergy[1] = new JTextArea(1,10);
		
		gbc.insets = new Insets(1,1,1,1);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelEnergy.add(new JLabel("Card name : "),gbc);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		panelEnergy.add(inputsEnergy[0],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelEnergy.add(new JLabel("Type : "),gbc);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		panelEnergy.add(inputsEnergy[1],gbc);
		
		actionButtonsEnergy = new JButton[2];
		
		gbc.gridy = 2;
		gbc.gridx= 2;
		actionButtonsEnergy[0] = new JButton("Edit");
		panelEnergy.add(actionButtonsEnergy[0],gbc);
		gbc.gridx= 3;
		actionButtonsEnergy[1] = new JButton("Create");
		panelEnergy.add(actionButtonsEnergy[1],gbc);
	}
	
	private void createTabTrainer() {
		panelTrainer = new JPanel();
		panelTrainer.setLayout(new GridBagLayout());
		panelTrainer.setBackground(new Color(0,0,0,0));
		GridBagConstraints gbc = new GridBagConstraints();
		inputsTrainer = new JTextArea[4];
		
		inputsTrainer[0] = new JTextArea(1,20);
		inputsTrainer[1] = new JTextArea(1,10);
		inputsTrainer[2] = new JTextArea(2,20);
		inputsTrainer[3] = new JTextArea(2,20);
		
		gbc.insets = new Insets(1,1,1,1);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelTrainer.add(new JLabel("Card name : "),gbc);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		panelTrainer.add(inputsTrainer[0],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelTrainer.add(new JLabel("Type : "),gbc);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		panelTrainer.add(inputsTrainer[1],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelTrainer.add(new JLabel("Text : "),gbc);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		panelTrainer.add(inputsTrainer[2],gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		panelTrainer.add(new JLabel("Trainer rule : "),gbc);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 1;
		panelTrainer.add(inputsTrainer[3],gbc);
		
		actionButtonsTrainer = new JButton[2];
		
		gbc.gridy = 4;
		gbc.gridx= 2;
		actionButtonsTrainer[0] = new JButton("Edit");
		panelTrainer.add(actionButtonsTrainer[0],gbc);
		gbc.gridx= 3;
		actionButtonsTrainer[1] = new JButton("Create");
		panelTrainer.add(actionButtonsTrainer[1],gbc);
	}
	
	public void selectTab(int i) {
		panelCard.setSelectedIndex(i);
	}
	
	public void addListenerAllButtons(Controler c) {
		for (int i = 0; i<actionButtonsPokemon.length; i++) {
			actionButtonsPokemon[i].addActionListener(c);
		}
		for (int i = 0; i<actionButtonsEnergy.length; i++) {
			actionButtonsEnergy[i].addActionListener(c);
		}
		for (int i = 0; i<actionButtonsTrainer.length; i++) {
			actionButtonsTrainer[i].addActionListener(c);
		}
	}

	public int getICard() {
		return iCard;
	}
	
	public void setICard(int i) {
		iCard = i;
	}
	
	public JTextArea[] getInputsPokemon() {
		return inputsPokemon;
	}

	public JTextArea[] getInputsEnergy() {
		return inputsEnergy;
	}

	public JTextArea[] getInputsTrainer() {
		return inputsTrainer;
	}

	public ArrayList<JTextArea[]> getInputsAttacks() {
		return inputsAttacks;
	}

	public JButton[] getActionButtonsPokemon() {
		return actionButtonsPokemon;
	}

	public JButton[] getActionButtonsEnergy() {
		return actionButtonsEnergy;
	}

	public JButton[] getActionButtonsTrainer() {
		return actionButtonsTrainer;
	}
	public void setInputsPokemon(int i, String string) {
		this.inputsPokemon[i].setText(string);
	}

	public void setInputsEnergy(int i, String string) {
		this.inputsEnergy[i].setText(string);
	}

	public void setInputsTrainer(int i, String string) {
		this.inputsTrainer[i].setText(string);
	}

	public void setInputsAttacks(int i,int j, String string) {
		this.inputsAttacks.get(i)[j].setText(string);
	}
}
