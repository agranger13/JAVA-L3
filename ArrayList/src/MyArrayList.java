
public class MyArrayList <T>{
	private T[] element;
	public final static int len = 10;
	private int length;
	
	MyArrayList(){
		element = (T[]) new Object[len];
		length = 0;
	}
	public int size() {
		return length-1;
	}
	public boolean add(T e) {
		
		if(length==element.length) {
			
			return false;
		}
		element[length]=e;
		length++;
		return true;
	}

	public T get(int i) {
		return element[i];
	}
	
}

