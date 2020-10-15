package app;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Item extends JButton {
	String name;
	String description = "";
	float price;
	boolean available = true;
	
	public Item(String name, float price) {
		try {
			Image image = ImageIO.read(getClass().getResource("/res/" + name.toLowerCase() + ".png"));
			this.setIcon(new ImageIcon(image));
		}catch(Exception e){
			System.out.println(e);
		}
		this.name = name;
		this.price = price;
		this.setText(this.name + " $" + (float) this.price);
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("Added some crappy " + name.toLowerCase() + " to your stupid cart.");
				Cart.getCart().self.addItem(new Item(name, price));
			}
		});
	}
	
	
}
