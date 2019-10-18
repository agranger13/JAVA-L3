package Modele;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	public String toString() {
		String pokedeckString = "";
		
		Iterator it = listCards.iterator();
		while(it.hasNext()) {
			pokedeckString += it.next() + "\n\n";
		}
		
		return pokedeckString;
	}
	
}
