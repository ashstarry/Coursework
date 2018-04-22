
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
	
	public void setEmpty()
	{
		this.head = null;
	}
	
	public int getSize()
	{
		return size;
	}
	
	
	public void display()
	{
		node temp = head;
		if (size == 0) 
        {
            System.out.print("The List is empty");
        }    
        
		while(temp != null)
        {
        	temp.display();
        	System.out.print(" ");
        	temp = temp.getNext();	
        		
        }
               
    }
	
	public void add(String element)
	{
		node temp = new node(element);
		node current = head;
		if(size == 0)
		{
			temp.setNext(head);
			head = temp;
			
		}
		else
		{
			while(current.getNext() != null)
			{
				current = current.getNext();
			}
			
			current.setNext(temp);
			
		}
		
		size++;
	}
	public void addNode(node element)
	{
		node current = head;
		if(size == 0)
		{
			head.setNext(element);
			head = element;
		}
		else
		{
			while(current.getNext() != null)
			{
				current = current.getNext();
			}
			
			current.setNext(element);
		}
		
		size++;
	}
	public void delete(String delete)
	{
		
		node current = head;
		node previous = null;
		
		if(delete.compareTo(current.getElement()) == 0)
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
				if(delete.compareTo(current.getElement()) == 0)
				{
					break;
				}
				
			}
			if(current == null)
			{
				System.out.println("The entered word was not found. Retruning to main menu.");
			}
			else if(delete.compareTo(current.getElement()) == 0)
			{
				previous.setNext(current.getNext());
				
			}
			
		}
		
		
	}
	
	public void toList(String equation)
	{
		for(int i = 0; i < equation.length(); i++)
		{
			String element = "";
			if(equation.charAt(i) == '(' || equation.charAt(i) == ')' || equation.charAt(i) == '^' || equation.charAt(i) == '+' || equation.charAt(i) == '-' || equation.charAt(i) == '*' || equation.charAt(i) == '/')
			{
				element += equation.charAt(i);
			}
			else if(equation.charAt(i) == '0' || equation.charAt(i) == '1' || equation.charAt(i) == '2' || equation.charAt(i) == '3' || equation.charAt(i) == '4' || equation.charAt(i) == '5' || equation.charAt(i) == '6' ||equation.charAt(i) == '7' || equation.charAt(i) == '8' || equation.charAt(i) == '9')
			{
				element += equation.charAt(i);
				while(i+1 < equation.length())
				{
					i++;
					if(equation.charAt(i) == '0' || equation.charAt(i) == '1' || equation.charAt(i) == '2' || equation.charAt(i) == '3' || equation.charAt(i) == '4' || equation.charAt(i) == '5' || equation.charAt(i) == '6' ||equation.charAt(i) == '7' || equation.charAt(i) == '8' || equation.charAt(i) == '9')
					{
						element += equation.charAt(i);
					}
					else
					{
						i--;
						break;
					}
					
				}
			}
			else
			{
				element += "bad";
			}
			
			add(element);
		}	
	}
	
	public void toDouble()
	{
		String element;
		node current = head;
		while(current != null)
		{
			element = current.getElement();
			if(element.compareTo("(") != 0 && element.compareTo(")") != 0 && element.compareTo("+") != 0 && element.compareTo("-") != 0 && element.compareTo("*") != 0 && element.compareTo("/") != 0 && element.compareTo("^") != 0 && element.compareTo("bad") != 0)
			{
				current.setNumber(Double.parseDouble(current.getElement()));
				current.setIsNumber(true);
			}
			current = current.getNext();
		}
	}
	
	public void setRank()
	{
		String element;
		node current = head;
		while(current != null)
		{
			element = current.getElement();
			if(element.compareTo("^") == 0)
			{
				current.setRank(4);
			}
			else if(element.compareTo("*") == 0 || element.compareTo("/") == 0)
			{
				current.setRank(3);
			}
			else if(element.compareTo("+") == 0 || element.compareTo("-") == 0)
			{
				current.setRank(2);
			}
			else if(element.compareTo("(") == 0 || element.compareTo(")") == 0)
			{
				current.setRank(1);
			}
			current = current.getNext();
		}
		
	}
	public boolean isValid()
	{
		boolean isValid = true;
		String element;
		int pLeft = 0, pRight = 0, operator = 0, operand = 0, bad = 0;
		node current = head;
		while(current != null)
		{
			element = current.getElement();
			//System.out.println(element);
			if(element.compareTo("(") == 0)
			{
				pLeft += 1;
			}
			if(element.compareTo(")") == 0)
			{
				pRight += 1;
			}
			if(element.compareTo("+") == 0 || element.compareTo("-") == 0|| element.compareTo("*") == 0|| element.compareTo("/") == 0 || element.compareTo("^") == 0)
			{
				operator += 1;
			}
			if (element.compareTo("bad") == 0)
			{
				bad += 1;
			}
			if(element.compareTo("(") != 0 && element.compareTo(")") != 0 && element.compareTo("+") != 0 && element.compareTo("-") != 0 && element.compareTo("*") != 0 && element.compareTo("/") != 0 && element.compareTo("^") != 0)
			{
				operand += 1;
			}
			
			current = current.getNext();
		}
		/*System.out.println(" pLeft= " + pLeft);
		System.out.println(" pRight = " + pRight);
		System.out.println(" Operand = " + operand);
		System.out.println(" Operator = " + operator);
		*/
		if(bad > 0)
		{
			System.out.println("The equation you entered contained a invalid element. Returning to menu.");
			isValid = false;
		}
		
		else if(operator + 1 == 1 && operand == 1)
		{
			System.out.println("The equation you entered contained spaces. Please input the equation without using spaces. Returning to menu.");
			isValid = false;
		}
		else if(pLeft != pRight)
		{
			System.out.println("The equation you entered contained an uneven number of right and left parenthesis or contained spaces. Returning to menu.");
			isValid = false;
		}
		else if(operand  != operator + 1)
		{
			System.out.println("The equation you entered had either too many or not enough operators and operands. Returning to menu.");
			isValid = false;
		}
		
		
		return isValid;
	}
	
	public void postFix()
	{
		LinkedList stack = new LinkedList();
		LinkedList queue = new LinkedList();
		node current = head;
		setRank();
		do
		{
			node temp;
			if(current.getRank() == 0)	
			{
				temp = current;
				queue.add(temp.getElement());
			}
			else
			{
				temp = current;
				stack.add(temp.getElement());
				
			}
			
			if(stack.head != null)
			{
				stack.setRank();
				node stackCurrent = stack.head;
				node stackPrevious = null;
				while(stackCurrent.getNext() != null)
				{
					stackPrevious = stackCurrent;
					stackCurrent =stackCurrent.getNext();
					
				}
				
				if(stackPrevious != null)
				{
				//here
				if(stackCurrent.getRank() > stackPrevious.getRank() && current.getNext() != null)
				{
					setRank();
					current = current.getNext();
					queue.add(current.getElement());
					queue.add(stackCurrent.getElement());
					stack.delete(stackCurrent.getElement());
					
				
				}
				if(stackCurrent.getRank() == 1 && stackPrevious.getRank() == 1 && current.getNext() != null)
				{
					current = current.getNext();
					stack.add(current.getElement());
					stack.delete(stackCurrent.getElement());
					stack.delete(stackPrevious.getElement());
					
				}
				if(stackCurrent.getRank() == stackPrevious.getRank() && stackCurrent.getRank() != 1 && current.getNext() != null)
				{
					
					queue.add(stackCurrent.getElement());
					stack.delete(stackCurrent.getElement());
					
						
				}
				if(stackCurrent.getRank() < stackPrevious.getRank() && current.getNext() != null)
				{
					if(stackCurrent.getRank() != 1)
					{
						queue.add(stackPrevious.getElement());
						stack.delete(stackPrevious.getElement());
					}
					
				}
				
			} //here
			}
		
			current = current.getNext();
		}while(current != null);
		
		if(current == null)
		{
				while(stack.head != null)
				{
					node stackTemp = stack.head;
					while(stackTemp.getNext() != null)
					{
						stackTemp = stackTemp.getNext();
					}
					
					queue.add(stackTemp.getElement());
					stack.delete(stackTemp.getElement());
				}
		}
		queue.removeParenthesis();
		head = queue.head;
		System.out.println("Postfix Equation: ");
		queue.display();
	}
	public void removeParenthesis()
	{
		setRank();
		node current = head;
		while(current != null)
		{
			if(current.getRank() == 1)
			{
				delete(current.getElement());
				current = head;
				
			}
			
				current = current.getNext();
		}
	}
	public double calculate(LinkedList equationList)
	{
		double answer = 0;
		equationList.toDouble();
		node operator = equationList.head;
		node operand1 = equationList.head;
		node operand2 = null;
		setRank();
		while(operator.getRank() < 2)
		{
			operator = operator.getNext();
		}
		while(operand1.getNext() != operator)
		{
			operand1 = operand1.getNext();
		}
		if(operand1 != equationList.head)
		{
			operand2 = equationList.head;
		}
		if(operand2 != null)
		{
			if(operator.getElement().compareTo("^") == 0)
			{
				answer += Math.pow(operand2.getNumber(), operand1.getNumber());
				delete(operator.getElement());
				delete(operand1.getElement());
				delete(operand2.getElement());
			}
			if(operator.getElement().compareTo("*") == 0)
			{
				answer += operand2.getNumber() * operand1.getNumber();
				delete(operator.getElement());
				delete(operand1.getElement());
				delete(operand2.getElement());
			}
			if(operator.getElement().compareTo("/") == 0)
			{
				answer += operand2.getNumber() / operand1.getNumber();
				delete(operator.getElement());
				delete(operand1.getElement());
				delete(operand2.getElement());
			}
			if(operator.getElement().compareTo("+") == 0)
			{
				answer += operand2.getNumber() + operand1.getNumber();
				delete(operator.getElement());
				delete(operand1.getElement());
				delete(operand2.getElement());
			}
			if(operator.getElement().compareTo("-") == 0)
			{
				answer += operand2.getNumber() - operand1.getNumber();
				delete(operator.getElement());
				delete(operand1.getElement());
				delete(operand2.getElement());
			}
		}
		if(equationList.head != null)
		{
		do
		{
			operator = equationList.head;
			operand1 = equationList.head;
			operand2 = null;
			while(operator.getRank() < 2)
			{
				operator = operator.getNext();
			}
			while(operand1.getNext() != operator)
			{
				operand1 = operand1.getNext();
			}
			if(operator.getElement().compareTo("^") == 0)
			{
				answer = Math.pow(answer, operand1.getNumber());
				delete(operator.getElement());
				delete(operand1.getElement());
			}
			if(operator.getElement().compareTo("*") == 0)
			{
				answer = answer * operand1.getNumber();
				delete(operator.getElement());
				delete(operand1.getElement());
			}
			if(operator.getElement().compareTo("/") == 0)
			{
				answer = answer / operand1.getNumber();
				delete(operator.getElement());
				delete(operand1.getElement());
				
			}
			if(operator.getElement().compareTo("+") == 0)
			{
				answer = answer + operand1.getNumber();
				delete(operator.getElement());
				delete(operand1.getElement());
			}
			if(operator.getElement().compareTo("-") == 0)
			{
				answer = answer - operand1.getNumber();
				delete(operator.getElement());
				delete(operand1.getElement());

			}
			
		}while (equationList.head != null);
		}	
		
		return answer;
	}
	public String toString()
	{
		return head.getElement();
	}
}
