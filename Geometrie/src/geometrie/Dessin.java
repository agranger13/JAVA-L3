package geometrie;

import java.util.ArrayList;
import java.util.Iterator;

public class Dessin implements FormeGeo{
	private ArrayList<FormeGeo> formes;
	
	public Dessin() {
		formes = new ArrayList<FormeGeo>();
		formes.add(new Rectangle(5,10,new Point(2,2)));
		// TODO Auto-generated constructor stub
	}
	
	public void dessiner() {
		Iterator it = formes.iterator();
		FormeGeo temp;
		while(it.hasNext()) {
			temp = (FormeGeo) it.next();
			temp.dessiner();
		}
	}

	
}
