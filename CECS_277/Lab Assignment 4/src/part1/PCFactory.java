package part1;

public class PCFactory implements ComputerAbstractFactory 
{
	private String RAM;
	private String CPU;

	PCFactory(String r, String c)
	{
		RAM = r;
		CPU = c;
	}
	
	public Computer createComputer()
	{
		return new PC(RAM, CPU);
	}
}//end class

