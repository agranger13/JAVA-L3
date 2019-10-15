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
public class Rectangle implements FormeGeo {
	public double longueur, largeur;
	public Point coin;
	
	public Rectangle(double longueur, double largeur, Point coin) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.coin = coin;
	}
	
	public void dessiner() {
		// TODO Auto-generated method stub
		System.out.println("dessinnnne un rectangle");
	}
		
	public static Point calculerCentre(Point p1, double largeur, double longueur) {
		return new Point( p1.getX()+longueur/2 , p1.getY()+largeur/2);
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
