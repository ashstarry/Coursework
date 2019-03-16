# Check if string is a number. 
# Create string class method to check if stirng is a numeric
class String
  def numeric?
    Float(self) != nil rescue false
  end
end

# Partition Fucntion
def partition()
  #Array to hold n values
  array = []
  # Track the largest and smallest values in the array
  smallest = 0
  largest = 0
  #User input of numbers
  puts("Enter numbers into array. Conclude input by entering anything that's not a number")
  input = gets
  while(!input.numeric?)
    puts("Please Enter a number")
    input = gets
  end
    # Add value to array and update largest/smallest
    array.push(input.to_i)
    smallest = input.to_i
    largest = input.to_i
  
    # Continue taking input, adding to array and updating largest/smalles
    while(input.numeric?)
    input = gets
    if(input.numeric?)
      array.push(input.to_i)
      if(input.to_i < smallest)
        smallest = input.to_i 
      elsif(input.to_i > largest)
        largest = input.to_i
      end
    end
  end
  # Save the original array for later comparison
  original = array.dup
  #Input of test value and input validation for test value
  puts("Enter the test value x")
  x = gets
  while(!x.numeric?)
    puts("Please Enter a valid number")
    x = gets
  end
  
  # If test value is less than all values in array, p = 0
  if(x.to_i < smallest)
    p = 0
    print("Original Array: ", original, "\n")
    print("Partitioned Array", array, "\n")
    print("Parition Index", p, "\n")

  # If test value is greater than all values in array, p = array.length - 1 (end of array)
  elsif(x.to_i > largest)
    p = array.length - 1
    print("Original Array: ", original, "\n")
    print("Partitioned Array", array, "\n")
    print("Parition Index", p, "\n")
  else
    #Initialize left and right pointers
    left = 0
    right = array.length - 1

    # Partition Process. Persists until left pointer equals or is greater than right pointer
    while(right > left)
        # While left pointer is less than or equals test value, increment left
        # Persists while left < right
        while(array[left].to_i <= x.to_i && right > left)
          left += 1
        end

        # While right pointer is greater than test value, decrement right
        # Persists while left < right
        while(array[right].to_i > x.to_i && right > left)
          right -= 1
        end

        # Swap values at array[left] and array[right]
        temp = array[left].to_i
        array[left] = array[right].to_i
        array[right] = temp
    end

    # If only 1 value is less than or equals the test value, right poitner will be a negative value.
    # Therefore, the left pointer is p
    if(left == 0)
      p = left

    # Right points to the first value > p
    # Therefore p = right - 1
    else
      p = right - 1
    end

    # Display Arrays and Partition Index
    print("Original Array: ", original, "\n")
    print("Partitioned Array: ", array, "\n")
    print("Parition Index: ", p, "\n")
  end
  
end

# Run Program
partition