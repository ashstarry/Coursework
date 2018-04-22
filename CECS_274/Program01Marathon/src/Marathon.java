import java.util.Scanner;
public class Marathon 
{
	public static void main(String[] args)
	{
		String name;
		float distance;
		int hours, minutes, seconds;
		
		System.out.println("What is your name?");
		Scanner input = new Scanner(System.in);
		name = input.next();
		
		System.out.println("How many miles did you run?");
		distance = input.nextFloat();
		
		System.out.println("How long did it take? (Hours:Minutes:Seconds)");
		System.out.println("Hours?");
		hours = input.nextInt();
		System.out.println("Minutes?");
		minutes = input.nextInt();
		System.out.println("Seconds?");
		seconds = input.nextInt();
		
		double pace;
		//Converted into minutes
		pace = (double) (((hours* 60) + minutes + (seconds / 60)) / distance);
	
		tenKilometers(name, pace, distance, hours, minutes, seconds);
		
	}
	
	public static void tenKilometers(String name, double pace, float distance, int hours, int minutes, int seconds)
	{
		//Calculate total time to run 10K
		double timeTotal;
		final double TK = 6.21;
		timeTotal = pace * TK;
		//Convert back from all minutes to H:M:S
		// H = hours, M = minutes, S = Seconds, TK = 10K
		int timeHTK, timeMTK, timeSTK; 
		
		timeHTK = (int) Math.floor(timeTotal / 60) ;
		timeMTK = (int) (timeTotal - (timeHTK * 60));
		timeSTK = (int)((timeTotal - Math.floor(timeTotal)) * 60);
	
		marathon(name, pace, timeHTK, timeMTK, timeSTK, distance, hours, minutes, seconds);
	}
	
	public static void marathon(String name, double pace, int timeHTK, int timeMTK, int timeSTK, float distance, int hours, int minutes, int seconds)
	{
		//Calculate total time to run 26.2 miles
		double timeTotal;
		final double M = 26.2;
		timeTotal = pace * M;
		//Convert back from all minutes to H:M:S
		// H = hours, M = minutes, S = Seconds, M = marathon
		int timeHM, timeMM, timeSM; 
				
		timeHM = (int) Math.floor(timeTotal / 60) ;
		timeMM = (int) (timeTotal - (timeHM * 60));
		timeSM = (int)((timeTotal - Math.floor(timeTotal)) * 60);

		printout(name, pace, timeHTK, timeMTK, timeSTK, timeHM, timeMM, timeSM, distance, hours, minutes, seconds);
				
	}
	
	public static void printout(String name, double pace, int timeHTK, int timeMTK, int timeSTK, int timeHM, int timeMM, int timeSM, float distance, int hours, int minutes, int seconds )
	{
		int paceH, paceM, paceS;
		
		paceH = (int) Math.floor(pace / 60);
		paceM = (int) (pace - (paceH * 60));
		paceS = (int) ((pace - Math.floor(pace)) * 60);
		
		System.out.println("Hello " + name);
		System.out.println("Running a distance of " + distance +  " mi with a time of " + hours + ":"+ minutes + ":" +seconds + " (Hours/Minutes/Seconds)"+",");
		System.out.println("Your pace is: " + paceH + ":" + paceM+ ":" + paceS + " (Hours/Minutes/Seconds)");
		System.out.println("At this rate,");
		System.out.println("Your 10K time would be " + timeHTK + ":" + timeMTK + ":" + timeSTK);
		System.out.println("Your marathon time would be " + timeHM + ":" + timeMM + ":" + timeSM);
		System.out.println("Good luck with your training");
	}
}
