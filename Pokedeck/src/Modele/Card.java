package Modele;

public abstract class Card {
	private static int cardsNumber = 0;
	private String cardName;
	private int id;
	private String image;
	
	public Card(String cardName, String image) {
		this.cardName = cardName;
		this.id = ++cardsNumber;
		this.image = image;
	}
	
	public abstract String toString();
	
	//Getters and Setters
	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public int getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
