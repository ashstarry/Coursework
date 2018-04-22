package part1;

public class Test {
	public static void main(String[] args)
	{
		Computer PC = ComputerFactory.getComputer( new PCFactory("2GB", "Intel") );
		System.out.println("PC Configuration:\n" + PC);
		
		Computer ser = ComputerFactory.getComputer( new ServerFactory("10GB", "Intel") );
		System.out.println("Server Configuration:\n" + ser);
		
	}
}//end class


