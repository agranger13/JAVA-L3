
public abstract class Weapon {
	protected double damage;

	public Weapon(double damage) {
		this.damage = damage;
	}
	
	public abstract String ascii_art();
	
	public double getDamage() {
		return damage;
	}
	public void setDamage(double damage) {
		this.damage = damage;
	}
}
