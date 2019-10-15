package geometrie;

public class CouleurDecorator extends Decorator{
	private String couleur;
	
	
	public CouleurDecorator(String couleur, FormeGeo forme) {
		super(forme);
		this.couleur = couleur;
	}


	@Override
	public void dessiner() {
		// TODO Auto-generated method stub
		
	}

	
}
