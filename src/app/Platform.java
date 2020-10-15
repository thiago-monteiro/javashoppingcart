package app;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Platform extends JPanel implements ActionListener{
	private final int WIDTH = 512;
	private final int HEIGHT = 512;
    final static int maxGap = 20;
    JComboBox horGapComboBox;
    JComboBox verGapComboBox;
	GridLayout layout = new GridLayout(0,2);
	JPanel controls;
	
	public Platform() {
		init();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		setBackground(Color.GRAY);
		setLayout(layout);
		controls = new JPanel();
		controls.setLayout(new GridLayout(2, 3));
		createComponent();
		add(controls);
		add(Cart.getCart());
		JScrollPane scrollPane = new JScrollPane(Cart.getCart());
		add(scrollPane);
	}
	
	public void createItem(String name, float price) {
		Item item = new Item(name, price);
		add(item);
	}
	
	private void createComponent() {
		createItem("Bucket", (float) 1.2);
		createItem("Toolbox", (float) 33.2);
		createItem("Shovel", (float) 14.5);
		createItem("Wheelbarrow", (float) 40.5);
	}
	
	private void init() {
		horGapComboBox = new JComboBox();
        verGapComboBox = new JComboBox();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
