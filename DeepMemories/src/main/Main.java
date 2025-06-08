package main;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Deep Memories");

		// Define o favicon (ícone da janela)
		ImageIcon icon = new ImageIcon(Main.class.getResource("/logos/Logo.png")); // Altere o caminho se necessário
		window.setIconImage(icon.getImage());

		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThread();
	}
}
