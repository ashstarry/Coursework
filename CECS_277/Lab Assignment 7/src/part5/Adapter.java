package part5;
/**
 * 
 * Class to adapt SimpleName Into FullName
 *
 */
public class Adapter implements FullNameInterface {

	SimpleName s;
	String fn, ln;
	public Adapter(SimpleName sn) {
		// TODO Auto-generated constructor stub
		s = sn;
		fn = s.getName().split(" ")[0];
		ln = s.getName().split(" ")[1];
		
	}

	@Override
	public void setFirstName(String f) {
		// TODO Auto-generated method stub
		fn = f;
	}

	@Override
	public void setLastName(String l) {
		// TODO Auto-generated method stub
		ln = l;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return fn;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return ln;
	}

	

}
