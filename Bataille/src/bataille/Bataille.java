package bataille;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Granger Alexis
 */
public class Bataille {

    public static void main(String[] args) {
        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();
        
        // Creation du jeu de 52 carte
        ArrayList<Carte> jeu = new ArrayList<Carte>();
        for(int i = 0; i < Carte.couleursEnum.length; i++){
            for(int j = 0;j < Carte.valeursEnum.length; j++){
                Carte carte = new Carte (i,j);
                jeu.add(carte);
            }
        }

        // Melange du jeu
        for(int i = 0; i<5; i++){
            Collections.shuffle(jeu);
        }

        // Distribution
        for(int i = 0; i<jeu.size() ;i++){
            if(i%2 == 0){
                joueur1.ajoutCarte(jeu.get(i));
            }
            else {
                joueur2.ajoutCarte(jeu.get(i));
            }
        }
        
        
        // Les joueurs jouent
        
        // Cartes brulees si egalite
        ArrayList<Carte> carteBrulee = new ArrayList<Carte>();
        
        while(joueur1.getPaquet().size() != 0 && joueur2.getPaquet().size() != 0){
            Carte cJ1 = joueur1.piocheCarte();
            Carte cJ2 = joueur2.piocheCarte();
            
            if(cJ1.compareTo(cJ2) > 0){
                joueur1.gagnePoint();
                
                if(carteBrulee.size()>0) {
                	for(int i = 0; i<carteBrulee.size(); i++) {
                		joueur1.ajoutCarte(carteBrulee.get(i));
                	}
                	carteBrulee.clear();
                }
                
                joueur1.ajoutCarte(cJ1);
                joueur1.ajoutCarte(cJ2);
            }
            else if(cJ1.compareTo(cJ2) < 0){
                joueur2.gagnePoint();
                
                if(carteBrulee.size()>0) {
                	for(int i = 0; i<carteBrulee.size(); i++) {
                		joueur2.ajoutCarte(carteBrulee.get(i));
                	}
                	carteBrulee.clear();
                }
                
                joueur2.ajoutCarte(cJ2);
                joueur2.ajoutCarte(cJ1);
            }
            else{
                // Brule une carte pour chaque joueur puis recommence la manche
            	carteBrulee.add(cJ1);
            	carteBrulee.add(cJ2);
            	
            	carteBrulee.add(joueur1.piocheCarte());
            	carteBrulee.add(joueur2.piocheCarte());
            }
            
            System.out.println("Nb cartes restantes J1 : " + joueur1.getPaquet().size());
            System.out.println("Nb cartes restantes J2 : " + joueur2.getPaquet().size());
            System.out.println("-----------------------------");
        }
        
        // Affiche les scores puis le gagnant
        System.out.println("\n\tRESULTAT");
        System.out.println("---------------------------");
        System.out.println("| Score de joueur 1 : " + joueur1.getPoint() + " |");
        System.out.println("| Score de joueur 2 : " + joueur2.getPoint() + " |");
        System.out.println("---------------------------");
        
        if(joueur1.getPoint() > joueur2.getPoint()){
            System.out.println("\n----->Joueur 1 est le gagnant<-----");
        }
        else {
            System.out.println("\n----->Joueur 2 est le gagnant<-----");
        }
    }
    
}
