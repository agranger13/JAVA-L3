package Modele;

public class EnergyCard extends Card{
	
	public EnergyCard(String cardName, String image, String type) {
		//super(cardName, image, type, "Energy");
		super(cardName, image, type);
	}

	//Getters and Setters
	
	public String toString() {
		return "ENERGY" + 
				"\ntype : " + super.getType();
	}
}
