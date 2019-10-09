package geometrie;

public class FormeGeo {
	private Point centre;
	
	
	public FormeGeo(Point centre) {
		this.centre = centre;
	}

	
	public static Point calculerCentre(Point p1, double largeur, double longueur) {
		return new Point( p1.getX()+longueur/2 , p1.getY()+largeur/2);
	}
	
	
	public Point getCentre() {
		return centre;
	}


	public void setCentre(Point centre) {
		this.centre = centre;
	}
}
