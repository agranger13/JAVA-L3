package Modele;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

public class Pokedeck {
	ArrayList<Card> listCards;

	public Pokedeck() {
		this.listCards = new ArrayList<>();
	}
	
	public Pokedeck(ArrayList<Card> listCards) {
		this.listCards = listCards;
	}
	
	public void addCard(Card c) {
		listCards.add(c);
	}
	
	public void removeCard(int i) {
		listCards.remove(i);
	}
	
	public void removeCard(Card c) {
		listCards.remove(c);
	}
	
	public Card getCard(int i) {
		return listCards.get(i);
	}
	

	public String toString() {
		String pokedeckString = "";
		
		Iterator it = listCards.iterator();
		while(it.hasNext()) {
			pokedeckString += it.next() + "\n\n";
		}
		
		return pokedeckString;
	}
	
}
