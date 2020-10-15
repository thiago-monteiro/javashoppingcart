package app;

import java.awt.Component;
import java.awt.Font;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Cart extends JTextArea{
	public static Cart self;
	private ArrayList<Item> items;
	private HashMap<String, Integer> totals;
    private float money = 465.1f;
	
	private Cart() {
		items = new ArrayList();
		totals = new HashMap();
	    setFont(new Font("Sans Serif", Font.BOLD, 16));
	    setLineWrap(true);
	    setWrapStyleWord(true);
	    setEditable(false);
	    setText("No Items\n\nMoney: " + money);
	}
	
	public static Cart getCart() {
		if (self == null) {
			self = new Cart();
		}
		return self;
	}
	public ArrayList getItems() {
		return items;
	}
	public void addItem(Item item) {
		
		if(money > item.price){
			items.add(item);
			//System.out.println(items.size());
			
			money -= item.price;
			
			
			if (!totals.containsKey(item.name)){
				totals.put(item.name, 1);
			}
			else {
				totals.put(item.name, totals.get(item.name) + 1);
			}
			
			setText("");
			
			
			for (Map.Entry<String, Integer> entry : totals.entrySet()) {
			    String key = entry.getKey();
			    Integer value = entry.getValue();
			    
			    append(key + " " + value.toString() + "\n");
			    
			    
			}
			append("\nMoney: " +  money);
		}
		else {
			Object[] options = {"Yes! ME NEED MOOOOONNNNEEEEYY!!",
                    "No! How dare you insult me!"};
			Component frame = null;
			int n = JOptionPane.showOptionDialog(frame ,
			    "ARE YA GANNA SELL SOMETHIN'?",
			    "Welcome to the new game show YOU'RE BROKE!!!",
			    JOptionPane.YES_NO_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    options,
			    options[1]);
			if (n == JOptionPane.YES_OPTION) {
                money += 2;
                items.remove(items.size() - 1);
            }
		}
	}
}
