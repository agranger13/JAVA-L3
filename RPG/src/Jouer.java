
public class Jouer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeaponStore store = new WeaponStore();
		store.addWeapon(new Axe());
		store.addWeapon(new Hammer());
		store.addWeapon(new Hammer(30));
		store.addWeapon(new Hammer(70));
		store.addWeapon(new Axe(100));
		
		store.showStock();
		
		
	}

}
