/**
 * 
 * @author Breeland Abrams
 *Class for determining money used to pay with
 */
public class MonetaryUnit {
	
	String monetaryUnit;
	double monetaryValue;
	
	/**
	 * 
	 * @param value
	 * @param unit
	 * Constructor for MonetaryUnit including parameters for unit name and unit value
	 */
	public MonetaryUnit(double value, String unit)
	{
		monetaryUnit = unit;
		monetaryValue = value;
	}
	
	
	/**
	 * 
	 * @return
	 * Method returning the value of the monetary unit
	 */
	double getValue()
	{
		return monetaryValue;
	}

}
