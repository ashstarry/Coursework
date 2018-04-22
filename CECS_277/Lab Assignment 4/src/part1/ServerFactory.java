package part1;

public class ServerFactory implements ComputerAbstractFactory {
	private String RAM;
	private String CPU;

	ServerFactory(String r, String c)
	{
		RAM = r;
		CPU = c;
	}
	
	public Computer createComputer()
	{
		return new PC(RAM, CPU);
	}
}//end class
