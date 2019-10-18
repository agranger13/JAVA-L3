package Modele;

public class PokemonCard extends Card{
	private String type;
	private int hp;
	private Attack[] attacks;
	
	public PokemonCard(String cardName, String image, String type, int hp, Attack[] attacks) {
		super(cardName, image);
		this.type = type;
		this.hp = hp;
		this.attacks = attacks;
	}

	//Getters and Setters
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public Attack[] getAttacks() {
		return attacks;
	}

	public void setAttacks(Attack[] attacks) {
		this.attacks = attacks;
	}

	public String toString() {
		String attackString = "";
		for(int i =0; i< this.attacks.length;i++) {
			attackString += "\tattack"+i+" : " + this.attacks[i].toString();
			if(i< this.attacks.length-1) {
				attackString += "\n";
			}
		}
		
		return 	"POKEMON"+
				"\nname : " + super.getCardName() + 
				"\ntype : " + this.type + 
				"\nhp : " + this.hp +
				"\nattacks : " + attackString;
	}

	
	
}
