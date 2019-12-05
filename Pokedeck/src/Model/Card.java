package Model;

public abstract class Card {
	private static int cardsNumber = 0;
	private String cardName;
	private int id;
	private String image;
	private String type;
	private String classCard;
	
	public Card(String cardName, String image, String type) {
		this.cardName = cardName;
		this.id = ++cardsNumber;
		this.image = image;
		this.type = type;
		//this.classCard = classCard;
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
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
