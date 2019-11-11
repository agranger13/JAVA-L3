package Modele;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class TestModele {

	public static void main(String[] args) {
		Pokedeck myCollection = new Pokedeck();		
		
		ArrayList<Attack> attacks = new ArrayList<Attack>();
		attacks.add(new Attack("fire spin","strong attack of fire", 100));
		attacks.add(new Attack("fire spin","strong attack of fire", 100));
		Card cardPokemon = new PokemonCard("Charizard",
				"image.png",
				"fire",
				120,
				attacks);
		System.out.println(cardPokemon.toString() + "\n");
		
		Card cardTrainer = new TrainerCard("Professor's Letter",
				"image.png", 
				"item",
				"Search your deck for up to 2 basic Energy cards",
				"You may play as many Item cards as you like" );
		System.out.println(cardTrainer.toString() + "\n");
	
		
		Card cardEnergy = new EnergyCard("energy", 
				"image.png", 
				"water");
		System.out.println(cardEnergy.toString() + "\n");
		
		myCollection.addCard(cardEnergy);
		myCollection.addCard(cardPokemon);
		myCollection.addCard(cardTrainer);
		
		myCollection.removeCard(cardTrainer);
		
		myCollection.getCard(1).setCardName("Squirtle");
		
		System.out.println("MY COLLECTION  \n" + myCollection.toString() + "\n");
		
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter writer = new FileWriter("A:\\Alexis\\Programmation\\JAVA-L3\\Pokedeck\\test.json")) {
			gson.toJson(myCollection, writer);
		} catch (IOException e) {
            e.printStackTrace();
        }
		
		try (Reader reader = new FileReader("A:\\Alexis\\Programmation\\JAVA-L3\\Pokedeck\\test.json")) {
			
            // Convert JSON to JsonElement, and later to String
			Pokedeck json = gson.fromJson(reader, Pokedeck.class);

            String jsonInString = gson.toJson(json);
			
            System.out.println(jsonInString);

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
