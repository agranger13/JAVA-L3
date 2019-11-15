package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import Controleur.ControleurCalcul;

public class PanelClavier extends JPanel{
	private String[] operations = {"+","-","*","/"};
	private JButton[] operationsBoutons;
	private JButton[] touches;

	private JPanel panelTouches = new JPanel();
	private JPanel panelOperations = new JPanel();
	
	private JTextField inputNombre = new JTextField(10);
	
	PanelClavier(){
		setLayout(new BorderLayout());
		
		panelTouches.setLayout(new GridLayout(4,3));
		panelOperations.setLayout(new GridLayout(5,1));
		
		touches = new JButton[15];
		operationsBoutons = new JButton[5];
		for(int i = 1; i < 10; i++) {
			touches[i] = new JButton(Integer.toString(i));
			panelTouches.add(touches[i]);
		}
		touches[0] = new JButton("0");
		panelTouches.add(touches[0]);
		
		for(int i = 0; i<operations.length;i++) {
			operationsBoutons[i] = new JButton(operations[i]);
			panelOperations.add(operationsBoutons[i]);
		}
		operationsBoutons[4] = new JButton("=");
		panelOperations.add(operationsBoutons[4]);
		
		add(inputNombre,BorderLayout.NORTH);
		add(panelTouches,BorderLayout.CENTER);
		add(panelOperations,BorderLayout.EAST);

	}

	public void addListenerClavier(ControleurCalcul c ) {
		for(int i = 0; i < 10; i++) {
			touches[i].addActionListener(c);
		}
		
		for(int i = 0; i < 5; i++) {
			operationsBoutons[i].addActionListener(c);
		}
		
	}

	public JButton[] getOperationsBoutons() {
		return operationsBoutons;
	}

	public JButton[] getTouches() {
		return touches;
	}
}
