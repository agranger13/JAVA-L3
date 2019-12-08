package View;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
import javax.swing.JScrollBar;

public class PanelViewCards extends JPanel {
	private Pokedeck myPoke;
	public PanelViewCards() {
		this.setBackground(new Color(0,0,0,0));
		setLayout(new GridLayout(0, 1, 0, 0));
	}
	
	public void initView(Pokedeck myPoke) {
		
		this.myPoke = myPoke;
		JPanel panelListCards = new JPanel();
		panelListCards.setBackground(new Color(0,0,0,0));
		panelListCards.setLayout(new GridLayout(0, 1, 0, 0));
		
		for(int i = 0; i<myPoke.getLength(); i++) {
			String test = myPoke.getCard(i).getClass().getSimpleName();
			System.out.println(test.compareTo("EnergyCard")==0);
			if(test.compareTo("EnergyCard")==0) {
				panelListCards.add(createListElementEnergy((EnergyCard) myPoke.getCard(i)));
			}else if(test.compareTo("PokemonCard")==0) {
				panelListCards.add(createListElementPokemon((PokemonCard) myPoke.getCard(i)));
			}else if(test.compareTo("TrainerCard")==0) {
				panelListCards.add(createListElementTrainer((TrainerCard) myPoke.getCard(i)));
			}
		}
		
		JScrollPane scrollPane = new JScrollPane(panelListCards);
		scrollPane.setBackground(new Color(0,0,0,0));
		add(scrollPane);
	}
	
	private JPanel createListElementPokemon(PokemonCard card) {
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
		gbc_lblName.insets = new Insets(0, 0, 5, 0);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		panel.add(lblName, gbc_lblName);
		
		JLabel lblType = new JLabel(card.getType());
		lblType.setFont(new Font(lblType.getFont().getName(),Font.PLAIN,20));
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 2;
		panel.add(lblType, gbc_lblType);
		
		JLabel lblHp = new JLabel(Integer.toString(card.getHp())+" HP");
		lblHp.setFont(new Font(lblHp.getFont().getName(),Font.PLAIN,20));
		GridBagConstraints gbc_lblHp = new GridBagConstraints();
		gbc_lblHp.insets = new Insets(0, 0, 5, 5);
		gbc_lblHp.gridx = 3;
		gbc_lblHp.gridy = 2;
		panel.add(lblHp, gbc_lblHp);
		
		JButton btnEditer = new JButton("Editer");
		GridBagConstraints gbc_btnEditer = new GridBagConstraints();
		gbc_btnEditer.gridheight = 2;
		gbc_btnEditer.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditer.gridx = 3;
		gbc_btnEditer.gridy = 3;
		panel.add(btnEditer, gbc_btnEditer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 0, 5);
		gbc_btnSupprimer.gridheight = 2;
		gbc_btnSupprimer.anchor = GridBagConstraints.WEST;
		gbc_btnSupprimer.gridx = 4;
		gbc_btnSupprimer.gridy = 3;
		panel.add(btnSupprimer, gbc_btnSupprimer);
		return panel;
	}
	
	private JPanel createListElementTrainer(TrainerCard card) {
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
		
		JLabel lblType = new JLabel(card.getType());
		lblType.setFont(new Font(lblType.getFont().getName(),Font.PLAIN,20));
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 2;
		panel.add(lblType, gbc_lblType);
		
		JButton btnEditer = new JButton("Editer");
		GridBagConstraints gbc_btnEditer = new GridBagConstraints();
		gbc_btnEditer.gridheight = 2;
		gbc_btnEditer.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditer.gridx = 3;
		gbc_btnEditer.gridy = 3;
		panel.add(btnEditer, gbc_btnEditer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 0, 5);
		gbc_btnSupprimer.gridheight = 2;
		gbc_btnSupprimer.anchor = GridBagConstraints.WEST;
		gbc_btnSupprimer.gridx = 4;
		gbc_btnSupprimer.gridy = 3;
		panel.add(btnSupprimer, gbc_btnSupprimer);
		
		return panel;
	}
	
	private JPanel createListElementEnergy(EnergyCard card) {
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
		
		JLabel lblType = new JLabel(card.getType());
		lblType.setFont(new Font(lblType.getFont().getName(),Font.PLAIN,20));
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 2;
		panel.add(lblType, gbc_lblType);
		
		JButton btnEditer = new JButton("Editer");
		GridBagConstraints gbc_btnEditer = new GridBagConstraints();
		gbc_btnEditer.gridheight = 2;
		gbc_btnEditer.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditer.gridx = 3;
		gbc_btnEditer.gridy = 3;
		panel.add(btnEditer, gbc_btnEditer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 0, 5);
		gbc_btnSupprimer.gridheight = 2;
		gbc_btnSupprimer.anchor = GridBagConstraints.WEST;
		gbc_btnSupprimer.gridx = 4;
		gbc_btnSupprimer.gridy = 3;
		panel.add(btnSupprimer, gbc_btnSupprimer);
		
		return panel;
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
}

