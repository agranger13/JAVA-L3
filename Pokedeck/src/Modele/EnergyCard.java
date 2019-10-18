package Modele;

public class EnergyCard extends Card{
	private String type;

	public EnergyCard(String cardName, String image, String type) {
		super(cardName, image);
		this.type = type;
	}

	//Getters and Setters
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return "ENERGY" + 
				"\ntype : " + type;
	}
}
