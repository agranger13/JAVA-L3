package geometrie;

public abstract class Decorator implements FormeGeo {
	private FormeGeo forme;

	public Decorator(FormeGeo forme) {
		this.forme = forme;
	}
}
