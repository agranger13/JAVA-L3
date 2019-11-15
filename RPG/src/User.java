
public class User {
	private double sold;
	private String name;
	
	User(String name){
		sold = 100;
		this.name = name;
	}
	
	public boolean sold(double price) {
		if(sold > price) {
			sold -= price;
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		
		return name + ", il vous reste: " + sold + "$";
	}
}
