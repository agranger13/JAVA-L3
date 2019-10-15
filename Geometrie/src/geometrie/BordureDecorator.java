package geometrie;

public class BordureDecorator extends Decorator{
	private float epaisseur;
	
	
	public BordureDecorator(float epaisseur, FormeGeo forme) {
		super(forme);
		this.epaisseur = epaisseur;
	}


	@Override
	public void dessiner() {
		// TODO Auto-generated method stub
		
	}
}
