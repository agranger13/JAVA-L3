/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataille;
import java.util.Random;

/**
 *
 * @author licence
 */
public class Carte {
    public static String[] couleursEnum={"PIQUE","COEUR","TREFLE","CARREAU"};
    public static String[] valeursEnum={"2","3","4","5","6","7","8","9","10","VALET","DAME","ROI","AS"};

    private int idCoul;
    private int idVal;

    Carte(){
        idCoul = 0;
        idVal = 0;
    }
    
    Carte(int parCoul, int parVal ){
        idCoul = parCoul;
        idVal = parVal;
    }

    public int compareTo(Carte carteAdv){
        if(carteAdv.idVal < this.idVal){
            return 1;
        }
        else if(carteAdv.idVal == this.idVal){
            return 0;
        }
        else
            return -1;
    }
    
    public String toString(){
        return this.valeursEnum[idVal] + " " + this.couleursEnum[idCoul];

    }
    
    public int getCouleur() {
        return idCoul;
    }

    public void setCouleur(int couleur) {
        this.idCoul = couleur;
    }

    public int getValeur() {
        return idVal;
    }

    public void setValeur(int valeur) {
        this.idVal = valeur;
    }
    
    
}
