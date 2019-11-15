package Vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreMere {
	public static void main(String[] args) {
		JPanel panel = new PanelFils();
		
		JFrame window = new JFrame("hello world");
		window.setSize(800,800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		window.setContentPane(panel);
	}
}
