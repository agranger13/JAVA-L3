import java.util.ArrayList;
import java.util.Iterator;

public class WeaponStore {
	ArrayList<Weapon> store;
	int number_weapons;
	
	public WeaponStore() {
		store = new ArrayList<Weapon>();
		number_weapons = 0;
	}
	
	public WeaponStore(ArrayList<Weapon> listW) {
		store = listW;
		number_weapons = listW.size();
	}
	
	public void addWeapon (Weapon w) {
		store.add(w);
		number_weapons ++;
	}
	
	public double price (Weapon w) {
		if (w instanceof Axe) {
			return 30 + (w.getDamage()/100)*30;
		}else if (w instanceof Hammer) {
			return 20+ (w.getDamage()/100)*20;
		}
		return 0;
	}
	
	public void showStock () {
		Iterator it = store.iterator();
		Weapon temp;
		while(it.hasNext()) {
			temp = (Weapon) it.next();
			System.out.println(temp.ascii_art());
			System.out.println("damage : " +temp.getDamage());
			System.out.println("prix : " +this.price(temp));
		}	
	}
}
