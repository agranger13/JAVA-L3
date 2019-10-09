import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public abstract class Fichier implements LecteurFichier{
	protected File fichier;
	
	Fichier(String f){
		fichier = new File(f);
	}

	public String lireFichier() throws IOException {
		FileInputStream in = null;
		String affichage = "";
		try {
			in = new FileInputStream(this.fichier);
			char buff;
			while(Character.isDefined(buff = (char)in.read())) {
				affichage += buff;
			}
			in.close();
			return affichage;
		} finally {
			if(in != null) {
				in.close();
			}
		}
	}
	
	public File getFichier() {
		return fichier;
	}

	public void setFichier(File fichier) {
		this.fichier = fichier;
	}
}
