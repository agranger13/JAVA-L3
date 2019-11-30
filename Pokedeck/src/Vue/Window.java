package Vue;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {
	public static void main(String[] args) {
		JPanel panel = new PanelSon();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame window = new JFrame("hello world");
		window.setSize(screenSize.width,screenSize.height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		window.setContentPane(panel);
	}
}
