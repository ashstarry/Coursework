package part5;
/**
 * 
 * Test Class for Adapter Pattern Program
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleName s1 = new SimpleName("Breeland Abrams");
		SimpleName s2 = new SimpleName("David Ibarra");
		
		Adapter a1 = new Adapter(s1);
		Adapter a2 = new Adapter(s2);
		
		System.out.println(a1.getFirstName());
		System.out.println(a1.getLastName());
		
		System.out.println(a2.getFirstName());
		System.out.println(a2.getLastName());
	}

}
