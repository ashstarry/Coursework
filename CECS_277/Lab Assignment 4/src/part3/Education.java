package part3;

/**
 * 
 * @author Breeland Abrams
 * Education Class
 */
public class Education 
{
	private String degree;
	private String major;
	private int researches;
	/**
	 * Default Education constructor
	 */
	public Education()
	{
		degree = "BS";
		major = "Engineering";
		researches = 0;
	}
	/**
	 * 
	 * @param d
	 * @param m
	 * @param re
	 * Overloaded education constructor
	 */
	public Education(String d, String m, int re)
	{
		degree = d;
		major = m;
		researches = re;
	}
	/**
	 * 
	 * @param d
	 * Method for setting Degree level
	 */
	public void setDegree(String d)
	{
		degree = d;
	}
	/**
	 * 
	 * @return
	 * Method for returning degree level
	 */
	public String getDegree()
	{
		return degree;
	}
	/**
	 * 
	 * @param m
	 * Method for setting major
	 */
	public void setMajor(String m)
	{
		major = m;
	}
	/**
	 * 
	 * @return
	 * Method for returning major
	 */
	public String getMajor()
	{
		return major;
	}
	/**
	 * 
	 * @param r
	 * Method for setting researches conducted
	 */
	public void setResearches(int r)
	{
		researches = r;
	}
	/**
	 * 
	 * @return
	 * Method for returning researches conducted
	 */
	public int getResearches()
	{
		return researches;
	}
}

