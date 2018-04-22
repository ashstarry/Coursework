package part1;
public abstract class Computer {
	public abstract String getRAM();
	public abstract String getCPU();

	public String toString()
	{
		return "CPU: " + getCPU() + "\nRAM: " + getRAM();
	}
}//end class
