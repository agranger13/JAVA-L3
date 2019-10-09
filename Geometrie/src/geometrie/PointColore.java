package geometrie;

public class PointColore extends Point{
	private String couleur;
	
	PointColore(){
		couleur = "UNDEFINED";
	}
	
	PointColore(int x, int y, String c){
		super(x,y);
		couleur = c;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
}
