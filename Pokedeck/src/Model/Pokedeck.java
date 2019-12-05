package Model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

public class Pokedeck {
	private String name;
	private ArrayList<Card> listCards;

	public Pokedeck(String name) {
		this.listCards = new ArrayList<>();
		this.name = name;
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
	
	public String getName() {
		return name;
	}
	
	public static Pokedeck importPokecdeck(String nameFile) {
		GsonBuilder gBuild = new GsonBuilder().setPrettyPrinting();
		gBuild.registerTypeAdapter(Card.class, new CardAdapterJson());
		
		Gson gson = gBuild.create();
		try (Reader reader = new FileReader(System.getProperty("user.dir")+"\\"+nameFile+".json")) {
			
            // Convert JSON to JsonElement, and later to String
			Pokedeck jsonPoke = gson.fromJson(reader, Pokedeck.class);
			return jsonPoke;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}
	
	

	public static void savePokedeck(Pokedeck poke) {
		GsonBuilder gBuild = new GsonBuilder().setPrettyPrinting();
		gBuild.registerTypeAdapter(Card.class, new CardAdapterJson());
		
		Gson gson = gBuild.create();
		try (FileWriter writer = new FileWriter(System.getProperty("user.dir")+"\\" + poke.getName() + ".json")) {
			gson.toJson(poke, writer);
		} catch (IOException e) {
            e.printStackTrace();
        }
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
