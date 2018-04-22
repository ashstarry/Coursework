
public class LinkedList {

	node head;
	node temp;
	int size = 0;
	
	public LinkedList()
	{
		head = null;
		size = 0;
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
	
	public node getHead()
	{
		return head;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void addStart(int wordCount)
	{
		String word = "";
		String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		
		for(int i = 0; i < wordCount; i++)
		{
			word = "";
			for(int j = 0; j < 5; j++)
			{
				int r;
				r = (int) Math.floor(Math.random() * 25);
				word = word + letters[r];
			}
			node temp = new node(word);
			node current = head;
			node previous = null;
			
			if(size == 0)
			{
				temp.setNext(head);
				head = temp;
			}
			else
			{
				if(temp.getWord().compareTo(current.getWord()) < 0)
				{
					temp.setNext(head);
					head = temp;
				}
				else if(temp.getWord().compareTo(current.getWord()) > 0)
				{
					while(temp.getWord().compareTo(current.getWord()) > 0 && current.getNext() != null)
					{
						previous = current;
						current = current.getNext();
					}
					if(temp.getWord().compareTo(current.getWord()) > 0)
					{
						current.setNext(temp);
					}
					else
					{
						temp.setNext(current);
						previous.setNext(temp);
					}
				}
				
			}
			size++;
		}
		
		
	}
	
	
	public void add()
	{
		String word = "";
		String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		
		for(int i = 0; i < size; i++)
		{
			word = "";
			for(int j = 0; j < 5; j++)
			{
				int r;
				r = (int) Math.floor(Math.random() * 25);
				word = word + letters[r];
			}
		}
		
		node temp = new node(word);
		node current = head;
		node previous = null;
		if(temp.getWord().compareTo(current.getWord()) < 0)
		{
			temp.setWord("*" + word + "*");
			temp.setNext(head);
			head = temp;
		}
		else if(temp.getWord().compareTo(current.getWord()) > 0)
		{
			while(temp.getWord().compareTo(current.getWord()) > 0 && current.getNext() != null)
			{
				previous = current;
				current = current.getNext();
			}
			if(temp.getWord().compareTo(current.getWord()) > 0)
			{
				temp.setWord("*" + word + "*");
				current.setNext(temp);
			}
			else
			{
				temp.setWord("*" + word + "*");
				temp.setNext(current);
				previous.setNext(temp);
			}
		}
		
		
	}
	
	
	public void delete(String delete)
	{
		
		node current = head;
		node previous = null;
		
		if(delete.compareTo(current.getWord()) == 0)
		{
			head = head.getNext();
			
		}
		else
		{
			while(current != null)
			{
				previous = current;
				current = current.getNext();
				if(current == null)
				{
					break;
				}
				if(delete.compareTo(current.getWord()) == 0)
				{
					break;
				}
				
			}
			if(current == null)
			{
				System.out.println("The entered word was not found. Retruning to main menu.");
			}
			else if(delete.compareTo(current.getWord()) == 0)
			{
				previous.setNext(current.getNext());
				
			}
			
		}
		
		
	}
	
	public void display()
	{	int counter = 1;
		node temp = head;
		if (size == 0) 
        {
            System.out.print("The List is empty");
        }    
		while(temp != null)
        {
        	temp.display();
        	if(temp.getWord().charAt(0) == '*')
        	{
        		String word = temp.getWord();
        		word = word.replace("*", "");
        		temp.setWord(word);
        	}
        	System.out.print(" ");
        	
        	temp = temp.getNext();	
        	if(counter % 12 == 0)
        	{
        		System.out.println("");
        	}
        	counter++;
        		
        }
               
    }
	public String toString()
	{
		return head.getWord();
	}
	

}
