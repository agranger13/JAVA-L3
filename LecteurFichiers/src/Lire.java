import java.io.IOException;

public class Lire {
	public static void main(String[] args) {
		FichierTXT fT = new FichierTXT("texte.txt");
		FichierCSV fc = new FichierCSV("tab.csv");
		try {
			System.out.println("\n###########################");
			System.out.println("Lire fichier :\n"+fc.lireFichier());
			
			System.out.println("\n###########################");
			System.out.println("Reverse :\n"+fT.lireFichierReverse());
			
			System.out.println("\n###########################");
			System.out.println("Palindromique :\n"+ fT.lireFichierPalindromique());
			
			System.out.println("\n###########################");
			System.out.println("Diff :\n - : line changed in file2\n + : line added in file2\n");
			fT.compareFichierTo(new FichierTXT("texte2.txt"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
