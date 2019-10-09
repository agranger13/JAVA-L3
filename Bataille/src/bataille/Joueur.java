/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataille;

import java.util.ArrayList;

/**
 *
 * @author licence
 */
public class Joueur {
    private ArrayList<Carte> paquet;
    private int point;
    
    Joueur(){
        paquet = new ArrayList<Carte>();
        point = 0;
    }
    
    public void ajoutCarte(Carte carte){
        paquet.add(carte);
    }
    
    public Carte piocheCarte(){
        Carte carte = paquet.get(0);
        paquet.remove(0);
        return carte;
    }

    public ArrayList<Carte> getPaquet() {
        return paquet;
    }

    public void gagnePoint(){
        point ++;
    }
    
    public void setPaquet(ArrayList<Carte> paquet) {
        this.paquet = paquet;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
