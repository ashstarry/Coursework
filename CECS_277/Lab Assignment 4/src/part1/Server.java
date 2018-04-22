package part1;

public class Server extends Computer
{
	private String RAM;
	private String CPU;
	
	Server(String r, String c)
	{
		RAM = r;
		CPU = c;
	}
	
	public String getRAM()
	{
		return RAM;
	}

	public String getCPU()
	{
		return CPU;
	}
}//end class

