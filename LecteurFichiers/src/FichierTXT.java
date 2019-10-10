import java.io.FileInputStream;
import java.io.IOException;

public class FichierTXT extends Fichier implements LecteurFichier{

	FichierTXT(String f) {
		super(f);
	}

	@Override
	public String lireFichierReverse() throws IOException {
			String[] lu = lireFichier().split("\n");
			
			String affichage="";
			for(int i = 0; i<lu.length ; i++) {
				affichage += lu[lu.length - 1 -i] ;
				if(i<lu.length-1) {
					affichage += '\n';
				}
			}
			return affichage;
	}

	@Override
	public String lireFichierPalindromique() throws IOException {
		String lu = lireFichier();
		String affichage = "";
		
		for(int i = 0; i<lu.length() ; i++) {
			if((int)lu.charAt(lu.length()-i-1)!= 10) {
				affichage += lu.charAt(lu.length()-i-1);
			}
		}
		return affichage;
	}

	@Override
	public void CompareFichier() {
		// TODO Auto-generated method stub
		
	}

}
