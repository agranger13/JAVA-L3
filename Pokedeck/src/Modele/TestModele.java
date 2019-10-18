package Modele;

public class TestModele {

	public static void main(String[] args) {
		Pokedeck myCollection = new Pokedeck();		
		
		Attack[] attacks = new Attack[2];
		attacks[0] = new Attack("fire spin","strong attack of fire", 100);
		attacks[1] = new Attack("fire spin","strong attack of fire", 100);
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
		System.out.println("MY COLLECTION  \n" + myCollection.toString() + "\n");
		
	}

}
