import java.io.FileInputStream;
import java.io.IOException;

public class FichierTXT extends Fichier{

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
		System.out.println(lu.length());
		
		for(int i = 0; i<lu.length() ; i++) {
			
			affichage += lu.charAt(lu.length()-i-1);
		}
		return affichage;
	}

	@Override
	public void CompareFichier() {
		// TODO Auto-generated method stub
		
	}

}
