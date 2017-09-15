import java.util.ArrayList;
import java.util.List;


public class ListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Fruit> lst=new ArrayList<Fruit>();
		lst.add(new Orange());
		lst.add(new Apple());
		
	}

	
}

interface Fruit{
	String getName();
}
class Orange implements Fruit{
	@Override
	public String getName() {
		return "Orange";
	}
}
class Apple implements Fruit{
	@Override
	public String getName() {
		return "Apple";
	}
}