package part5;
/**
 * 
 * Simple Name (Adaptee) Class
 *
 */
public class SimpleName implements NameInterface{
	
	String name;
	
	SimpleName(String s)
	{
		name = s;
	}

	public void setName(String n) {
	name = n;
	}

	public String getName() {
	return name;
	}

}
