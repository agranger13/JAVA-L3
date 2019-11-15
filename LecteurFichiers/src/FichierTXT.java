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
	public void compareFichierTo(Fichier f) {
		try {
			String[] file1 = super.lireFichier().split("\n");
			String[] file2 = f.lireFichier().split("\n");
			int differences = 0;
			
			for(int i =0, j=0; i<file1.length || j<file2.length ;i++,j++ ) {				
				if(i>= file1.length ) {
					System.out.print(" + " + file2[j]);
					differences ++;
					continue;
				}else if(j >= file2.length ) {
					System.out.print(" + " + file1[i]);
					differences ++;
					continue;
				}
				
				
				if(file1[i].compareTo(file2[j]) == 0) {
					System.out.print(file1[i]);
				}else if(file1[i].compareTo(file2[j]) != 0) {
					if((int)file1[i].charAt(0) == 13) {
						System.out.print(" + " + file2[j]);
					}else {
						System.out.print(" - " + file2[j]);
					}
					differences ++;
				}		
				
			}
			
			System.out.println("\nTotal lines different : " + differences);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
