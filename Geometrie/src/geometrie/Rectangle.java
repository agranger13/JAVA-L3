/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometrie;

/**
 *
 * @author licence
 */
public class Rectangle extends FormeGeo {
	public double longueur, largeur;
	public Point coin;
	
	public Rectangle(double longueur, double largeur, Point coin) {
		super(calculerCentre(coin,longueur,largeur));
		this.longueur = longueur;
		this.largeur = largeur;
		this.coin = coin;

		
	}
	
	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public Point getCoin() {
		return coin;
	}

	public void setCoin(Point coin) {
		this.coin = coin;
	}
	
   
}
