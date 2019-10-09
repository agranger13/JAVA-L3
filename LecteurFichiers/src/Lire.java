import java.io.IOException;

public class Lire {
	public static void main(String[] args) {
		FichierTXT fT = new FichierTXT("texte.txt");
		FichierCSV fc = new FichierCSV("tab.csv");
		try {
			System.out.println("Lire fichier :\n"+fc.lireFichier());
			System.out.println("\nReverse :\n"+fT.lireFichierReverse());
			System.out.println("\nPalindromique :\n"+ fT.lireFichierPalindromique());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
