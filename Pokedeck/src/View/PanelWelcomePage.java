package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controler.Controleur;

import java.awt.Insets;

public class PanelWelcomePage extends JPanel {
	private JLabel labelWelcome;	
	private JLabel labelInput;
	private JTextArea nameOfPokedeck;
	private JButton buttonImport;
	private JButton buttonCreate;
	
	public PanelWelcomePage() {
		this.setBackground(new Color(0,0,0,0));
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		gridBagLayout.columnWidths = new int[]{42, 299, 164, 65, 71, 269, 0};
		gridBagLayout.rowHeights = new int[]{97, 65, 25, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		setLayout(gridBagLayout);
		
		labelWelcome = new JLabel("WELCOME");
		labelWelcome.setFont(new Font(labelWelcome.getFont().getName(),Font.PLAIN,80));
		
		GridBagConstraints gbc_labelWelcome = new GridBagConstraints();
		gbc_labelWelcome.gridwidth = 6;
		gbc_labelWelcome.anchor = GridBagConstraints.NORTH;
		gbc_labelWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_labelWelcome.gridx = 0;
		gbc_labelWelcome.gridy = 1;
		add(labelWelcome, gbc_labelWelcome);
		
		labelInput = new JLabel("Name of your Pokedeck :");
		GridBagConstraints gbc_labelInput = new GridBagConstraints();
		gbc_labelInput.anchor = GridBagConstraints.EAST;
		gbc_labelInput.insets = new Insets(0, 0, 0, 5);
		gbc_labelInput.gridx = 1;
		gbc_labelInput.gridy = 6;
		add(labelInput, gbc_labelInput);
		
		nameOfPokedeck = new JTextArea(1,20);
		GridBagConstraints gbc_nameOfPokedeck = new GridBagConstraints();
		gbc_nameOfPokedeck.insets = new Insets(0, 0, 0, 5);
		gbc_nameOfPokedeck.gridx = 2;
		gbc_nameOfPokedeck.gridy = 6;
		add(nameOfPokedeck, gbc_nameOfPokedeck);
		
		buttonImport = new JButton("Import");
		
		GridBagConstraints gbc_buttonImport = new GridBagConstraints();
		gbc_buttonImport.insets = new Insets(0, 0, 0, 5);
		gbc_buttonImport.gridx = 4;
		gbc_buttonImport.gridy = 6;
		add(buttonImport, gbc_buttonImport);
		
		buttonCreate = new JButton("Create");
		GridBagConstraints gbc_buttonCreate = new GridBagConstraints();
		gbc_buttonCreate.anchor = GridBagConstraints.WEST;
		gbc_buttonCreate.gridx = 5;
		gbc_buttonCreate.gridy = 6;
		add(buttonCreate, gbc_buttonCreate);
		
	}
	
	public void addListenerButtons(Controleur c) {
		buttonImport.addActionListener(c);
		buttonCreate.addActionListener(c);
	}
	
	public JButton getButtonCreate() {
		return buttonCreate;
	}

	public JButton getButtonImport() {
		return buttonImport;
	}

	public JTextArea getNameOfPokedeck() {
		return nameOfPokedeck;
	}
}
