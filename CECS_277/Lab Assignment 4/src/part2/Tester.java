package part2;
import java.util.Scanner;
class Tester {
	  public static void main(String[] args)
	  {
	    Scanner input = new Scanner(System.in);
	    int n = input.nextInt();
	    int[] list = new int[n];
	    
	    for(int i = 0; i < n; i++)
	    {
	      list[i] = input.nextInt();    
	  	}
	    
	    for(int j = 0; j < n; j++)
	    {
	      String temp = String.valueOf(list[j]);
	      if(temp.charAt(0) == '1' && temp.charAt(1) == '9' && temp.charAt(2) == '0')
	      {
	    	  System.out.println("?");
	      }
	      else if((list[j] % 10) == 1 ) //S=1
	      {
	    	  if(temp.charAt(0) == '1' && temp.charAt(1) == '9' && temp.charAt(2) == '0')
		      {
		    	  System.out.println("?");
		      }
	    	  else
	    	  {
	    		 System.out.println("+");
	    	  }
	    	  
	      }
	      else if((list[j] % 10) == 4 )// S=4
	      {
	    	  if(temp.charAt(0) == '1' && temp.charAt(1) == '9' && temp.charAt(2) == '0')
		      {
		    	  System.out.println("?");
		      }
	    	  else if(temp.charAt(0) == '9')
	    	 {
	    		 System.out.println("*");
	    	 }
	    	 else
	    	 {
	    		 System.out.println("+");
	    	 }
	      }
	      else if((list[j] % 100) == 78 ) // S=78
	      {
	    	  if(temp.charAt(0) == '1' && temp.charAt(1) == '9' && temp.charAt(2) == '0')
		      {
		    	  System.out.println("?");
		      }
	    	  else
		      {
		    	System.out.println("+");
		      }
	      }
	      else if((list[j] % 100) == 35 )//S=S35
	      {
	    	  if(temp.charAt(0) == '1' && temp.charAt(1) == '9' && temp.charAt(2) == '0')
		      {
		    	  System.out.println("?");
		      }
	    	  else
	    	  {
		    	  System.out.println("-");
	    	  }
	      }
	      
	    }
	  }
}
