package View;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controler.Controler;
import Controler.ControlerCard;
import Model.Card;
import Model.EnergyCard;
import Model.Pokedeck;
import Model.PokemonCard;
import Model.TrainerCard;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JScrollBar;

public class PanelViewCards extends JPanel{
	private Pokedeck myPoke;
	private ArrayList<JButton[]> buttons;
	private JScrollPane scrollPane;
	
	public PanelViewCards() {
		this.setBackground(new Color(0,0,0,0));
		setLayout(new GridLayout(0, 1, 0, 0));
	}
	
	public void initView(Pokedeck myPoke) {
		buttons = new ArrayList<JButton[]>();
		this.myPoke = myPoke;
		JPanel panelListCards = new JPanel();
		panelListCards.setBackground(new Color(0,0,0,0));
		panelListCards.setLayout(new GridLayout(0, 1, 10, 10));
		
		for(int i = 0; i<myPoke.getLength(); i++) {
			String test = myPoke.getCard(i).getClass().getSimpleName();
			if(test.compareTo("EnergyCard")==0) {
				panelListCards.add(createListElementEnergy((EnergyCard) myPoke.getCard(i),i));
			}else if(test.compareTo("PokemonCard")==0) {
				panelListCards.add(createListElementPokemon((PokemonCard) myPoke.getCard(i),i));
			}else if(test.compareTo("TrainerCard")==0) {
				panelListCards.add(createListElementTrainer((TrainerCard) myPoke.getCard(i),i));
			}
		}
		
		scrollPane = new JScrollPane(panelListCards);
		scrollPane.setBackground(new Color(0,0,0,0));
		scrollPane.setPreferredSize(new Dimension(1000,800));
		scrollPane.getViewport();
		add(scrollPane);
	}
	
	private JPanel createListElementPokemon(PokemonCard card, int i) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,0,30));
		panel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{282, 192, 210, 128, 132, 0};
		gbl_panel.rowHeights = new int[]{77, 25, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblName = new JLabel(card.getCardName());
		lblName.setFont(new Font(lblName.getFont().getName(),Font.PLAIN,30));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.gridwidth = 6;
		gbc_lblName.gridheight = 2;
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		panel.add(lblName, gbc_lblName);
		
		JLabel lblType = new JLabel("Type : " + card.getType());
		lblType.setFont(new Font(lblType.getFont().getName(),Font.PLAIN,20));
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 2;
		panel.add(lblType, gbc_lblType);
		
		JLabel lblHp = new JLabel(Integer.toString(card.getHp())+" HP");
		lblHp.setFont(new Font(lblHp.getFont().getName(),Font.PLAIN,20));
		GridBagConstraints gbc_lblHp = new GridBagConstraints();
		gbc_lblHp.gridx = 3;
		gbc_lblHp.gridy = 2;
		panel.add(lblHp, gbc_lblHp);
		
		JLabel lblAttacks = new JLabel(Card.toHTML(card.attacksToSTring()));
		lblAttacks.setFont(new Font(lblAttacks.getFont().getName(),Font.PLAIN,20));
		GridBagConstraints gbc_lblAttacks = new GridBagConstraints();
		gbc_lblAttacks.gridx = 0;
		gbc_lblAttacks.gridwidth = 6;
		gbc_lblAttacks.gridy = 3;
		panel.add(lblAttacks, gbc_lblAttacks);
		
		JButton btnEdit = new JButton("Edit");
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.gridheight = 2;
		gbc_btnEdit.gridx = 3;
		gbc_btnEdit.gridy = 4;
		panel.add(btnEdit, gbc_btnEdit);
		
		JButton btnRemove = new JButton("Remove");
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.gridheight = 2;
		gbc_btnRemove.anchor = GridBagConstraints.WEST;
		gbc_btnRemove.gridx = 4;
		gbc_btnRemove.gridy = 4;
		panel.add(btnRemove, gbc_btnRemove);

		gbc_btnRemove.insets = new Insets(0, 0, 10, 0);
		buttons.add(new JButton[] {btnEdit,btnRemove});
		
		return panel;
	}
	
	private JPanel createListElementTrainer(TrainerCard card, int i) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,0,30));
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{282, 192, 210, 128, 132, 0};
		gbl_panel.rowHeights = new int[]{77, 25, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblName = new JLabel(card.getCardName());
		lblName.setFont(new Font(lblName.getFont().getName(),Font.PLAIN,30));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.gridwidth = 6;
		gbc_lblName.gridheight = 2;
		gbc_lblName.insets = new Insets(0, 0, 5, 0);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		panel.add(lblName, gbc_lblName);
		
		JLabel lblType = new JLabel("Type : " +card.getType());
		lblType.setFont(new Font(lblType.getFont().getName(),Font.PLAIN,20));
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 2;
		panel.add(lblType, gbc_lblType);
		
		JLabel lbltext = new JLabel(card.getText());
		lbltext.setFont(new Font(lbltext.getFont().getName(),Font.PLAIN,20));
		GridBagConstraints gbc_lbltext = new GridBagConstraints();
		gbc_lbltext.gridwidth = 6;
		gbc_lbltext.gridx = 0;
		gbc_lbltext.gridy = 3;
		panel.add(lbltext, gbc_lbltext);
		
		JLabel lblRules = new JLabel("Trainer rules : " + card.getTrainerRule());
		lblRules.setFont(new Font(lblRules.getFont().getName(),Font.PLAIN,20));
		GridBagConstraints gbc_lblRules = new GridBagConstraints();
		gbc_lblRules.gridwidth = 6;
		gbc_lblRules.gridx = 0;
		gbc_lblRules.gridy = 4;
		panel.add(lblRules, gbc_lblRules);
		
		JButton btnEdit = new JButton("Edit");
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.gridheight = 2;
		gbc_btnEdit.gridx = 3;
		gbc_btnEdit.gridy = 5;
		panel.add(btnEdit, gbc_btnEdit);
		
		JButton btnRemove = new JButton("Remove");
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.gridheight = 2;
		gbc_btnRemove.anchor = GridBagConstraints.WEST;
		gbc_btnRemove.gridx = 4;
		gbc_btnRemove.gridy = 5;
		panel.add(btnRemove, gbc_btnRemove);
		
		buttons.add(new JButton[] {btnEdit,btnRemove});
		
		return panel;
	}
	
	private JPanel createListElementEnergy(EnergyCard card, int i) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,0,30));
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{282, 192, 210, 128, 132, 0};
		gbl_panel.rowHeights = new int[]{77, 25, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblName = new JLabel(card.getCardName());
		lblName.setFont(new Font(lblName.getFont().getName(),Font.PLAIN,30));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.gridwidth = 6;
		gbc_lblName.gridheight = 2;
		gbc_lblName.insets = new Insets(0, 0, 5, 0);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		panel.add(lblName, gbc_lblName);
		
		JLabel lblType = new JLabel("Type : " +card.getType());
		lblType.setFont(new Font(lblType.getFont().getName(),Font.PLAIN,20));
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 2;
		panel.add(lblType, gbc_lblType);
		
		JButton btnEdit = new JButton("Edit");
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.gridheight = 2;
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.gridx = 3;
		gbc_btnEdit.gridy = 3;
		panel.add(btnEdit, gbc_btnEdit);
		
		JButton btnRemove = new JButton("Remove");
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemove.gridheight = 2;
		gbc_btnRemove.anchor = GridBagConstraints.WEST;
		gbc_btnRemove.gridx = 4;
		gbc_btnRemove.gridy = 3;
		panel.add(btnRemove, gbc_btnRemove);
		
		buttons.add(new JButton[] {btnEdit,btnRemove});
		
		return panel;
	}
	
	public void addListenerButtons(ControlerCard c) {
		if(buttons != null) {
			for(int i=0; i<buttons.size();i++) {
				buttons.get(i)[0].addActionListener(c);
				buttons.get(i)[1].addActionListener(c);
			}
			scrollPane.getViewport().addChangeListener(c);
		}
	}
	// to implement, color background of card
	public Color colorOfType(String type) {
		Color color;
		
		switch(type.toLowerCase()) {
			case "fire" :  color = new Color(0,0,0,30); break;
			case "water" :  color = new Color(0,0,0,30); break;
			case "normal" :  color = new Color(0,0,0,30); break;
			case "grass" :  color = new Color(0,0,0,30); break;
			case "electric" :  color = new Color(0,0,0,30); break;
			case "ice" :  color = new Color(0,0,0,30); break;
			case "fighting" :  color = new Color(0,0,0,30); break;
			case "poison" :  color = new Color(0,0,0,30); break;
			case "ground" :  color = new Color(0,0,0,30); break;
			case "flying" :  color = new Color(0,0,0,30); break;
			case "psychic" :  color = new Color(0,0,0,30); break;
			case "rock" :  color = new Color(0,0,0,30); break;
			case "ghost" :  color = new Color(0,0,0,30); break;
			case "dark" :  color = new Color(0,0,0,30); break;
			case "dragon" :  color = new Color(0,0,0,30); break;
			case "steel" :  color = new Color(0,0,0,30); break;
			default : color = new Color(0,0,0,30);
			
		}
		
		return color;
	}
	
	public void setMyPoke(Pokedeck poke) {
		this.myPoke = poke;
	}
	
	public Pokedeck getMyPoke() {
		return myPoke;
	}

	public ArrayList<JButton[]> getButtons() {
		System.out.println(buttons.size());
		return buttons;
	}
}

