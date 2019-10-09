import java.io.IOException;

public interface LecteurFichier {
	public String lireFichier() throws IOException;
	public String lireFichierReverse() throws IOException;
	public String lireFichierPalindromique() throws IOException;
	public void CompareFichier();
}