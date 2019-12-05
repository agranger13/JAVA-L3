package Model;

public class TrainerCard extends Card{
	private String text;
	private String trainerRule;
	
	public TrainerCard(String cardName, String image, String type, String text, String trainerRule) {
		//super(cardName, image,type, "Trainer");
		super(cardName, image, type);
		this.text = text;
		this.trainerRule = trainerRule;
	}

	
	//Getters and Setters

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTrainerRule() {
		return trainerRule;
	}

	public void setTrainerRule(String trainerRule) {
		this.trainerRule = trainerRule;
	}
	
	public String toString() {
		return 	"TRAINER" +
				"\nname : " + super.getCardName() + 
				"\ntype : " + super.getType() +
				"\ntext : " + text +
				"\ntrainer rules : " + trainerRule;
	}
	
}
