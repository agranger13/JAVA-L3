package singleton;

public class MoteurAudio {
	private String ch;
	private static MoteurAudio instance;
	
	private MoteurAudio(){
		ch = "suuuuuper";
	}
	
	public static MoteurAudio moteurAudio() {
		if(instance == null) {
			instance = new MoteurAudio();
		}
		return instance;
		
	}
	
}
