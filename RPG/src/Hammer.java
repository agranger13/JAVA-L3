
public class Hammer extends Weapon{
	private static final double DAMAGE = 10;
	public Hammer() {
		super(DAMAGE);
	}
	
	public Hammer(double damage) {
		super(damage);
	}
	
	public String ascii_art() {
		return" __\n"+
			  "|_|_|\n" +
			  "  |\n"+
			  "  |\n";
	}
}
