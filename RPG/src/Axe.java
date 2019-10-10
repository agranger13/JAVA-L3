
public class Axe extends Weapon{
	private static final double DAMAGE = 10;
	public Axe() {
		super(DAMAGE);
		// TODO Auto-generated constructor stub
	}
	
	public Axe(double damage) {
		super(damage);
	}
	
	public String ascii_art() {
		return	"/’-./\\_  \n"+// What’s wrong here ?
				":   ||,>  \n" +
				"\\.-’||    \n"+// And here ?
				"    ||     \n" +
				"    ||     \n" +
				"    ||     \n";}
}
