package Model;

import java.util.ArrayList;

public class PokemonCard extends Card{
	private int hp;
	private ArrayList<Attack> attacks;
	
	public PokemonCard(String cardName, String image, String type, int hp, ArrayList<Attack> attacks) {
		//super(cardName, image, type, "Pokemon");
		super(cardName, image, type);
		this.hp = hp;
		this.attacks = attacks;
	}

	//Getters and Setters
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public ArrayList<Attack> getAttacks() {
		return attacks;
	}

	public void setAttacks(ArrayList<Attack> attacks) {
		this.attacks = attacks;
	}
	
	public void addAttack(Attack attack) {
		this.attacks.add(attack);
	}
	public void removeAttack(Attack attack) {
		this.attacks.remove(attack);
	}

	public String toString() {
		String attackString = "";
		for(int i =1; i<= this.attacks.size();i++) {
			attackString += "\tattack"+i+" : " + this.attacks.get(i-1).toString();
			if(i< this.attacks.size()) {
				attackString += "\n";
			}
		}
		
		return 	"POKEMON"+
				"\nname : " + super.getCardName() + 
				"\ntype : " + super.getType() + 
				"\nhp : " + this.hp +
				"\nattacks : \n" + attackString;
	}

	
	
}
