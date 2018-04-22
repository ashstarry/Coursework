
public class node {
	
	private String word;
	private node next;
	
	public node(String word)
	{
		this.word = word;
		this.next = null;
	}
	
	public String getWord()
	{
		return word;
	}
	
	public void setWord(String word)
	{
		this.word = word;
	}
	
	public node getNext()
	{
		return next;
	}
	
	public void setNext(node next)
	{
		this.next = next;
	}
	
	public void display()
	{
		System.out.print(word);
	}
	
}
