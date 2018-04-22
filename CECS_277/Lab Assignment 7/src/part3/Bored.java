package part3;
/**
 * 
 * Bored State
 *
 */
public class Bored implements State
{

	@Override
	public void execute(Robot r) {
		// TODO Auto-generated method stub
		System.out.println("Sing");
		System.out.println("Now that Roomba has sung, he is now feeling Happy");
		r.setCurrentState(r.getHappyState());
		r.getHappyState().execute(r);
	}

}
