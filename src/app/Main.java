package app;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main extends JFrame{
	public Main() {
		add(new Platform());
		setResizable(false);
		pack();
		setTitle("Something Strange");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Main m = new Main();
				m.setVisible(true);
			}
		});
	}
}
