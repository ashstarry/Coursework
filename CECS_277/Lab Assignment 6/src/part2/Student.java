package part2;

import java.io.Serializable;

public class Student implements Serializable {

	private String lastName;
	private String firstName;
	private int ID;
	
	public Student() {
		// TODO Auto-generated constructor stub
		lastName = " ";
		firstName = " ";
		ID = 0;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public int hashCode()
	{
		final int HASH_MULTIPLIER = 29;
		int h = HASH_MULTIPLIER * firstName.hashCode() + lastName.hashCode();
		h = HASH_MULTIPLIER * h + ((Integer)ID).hashCode();
		return h;
	}
	
	
	public String toString()
	{
		return lastName + ", " + firstName + "\t" + ID;
	}

	

	
	
}
