#Win Conditions for the game. Coins must be in the same order as one of these to win the game
$WIN_CON_1 = "HTHTHTHTHT"
$WIN_CON_2 = "THTHTHTHTH"

# Main Game Function
def game()
  # Inital State of Coints
  stateCurr = ["H", "H", "H", "H", "H", "T", "T", "T", "T", "T"]
  stateOrigin = stateCurr.dup
  # Empty Space Indexer
  empty = nil
  # Iniital Turns
  turns = 5
  # Both state and turns updated as game progresses
  # Main Game loop. Plays game for 5 Turns.
  while turns > 0 
    # Display State and Turns Remaining at beginning of each turn
    puts("Turns Remaining: ", turns, "\nCurrent State:", stateCurr.join, "\n")
    # Prompt user input for moving coins
    puts("Select the left position of the coin pair you want to move by spcacing/backspacing you cursor over it", stateCurr.join)
    i = gets.length.to_i-1
    #Input Validation for user input. If i isnt between 1 and the length of the current state, reprompt for another number
    while (i > stateCurr.length-1)
      puts("Please select a valid starting point.", stateCurr.join)
      i = gets.length.to_i-1
    end
    # Validates consecutive coins
    while(stateCurr[i] == "-" || stateCurr[i+1] == "-")
      puts("You selected an invalid pair. Please select a pair of two consecutive coins.", stateCurr.join)
      i = gets.length.to_i-1
      #Input Validation for user input. If i isnt between 1 and 9, reprompt for another number
      while (i > stateCurr.length-1)
        puts("Please select a valid starting point.", stateCurr.join)
      i = gets.length.to_i-1
      end
    end
    #Rearange Coins based on user input
    if (stateCurr.length == 10)
      stateCurr.unshift("-")
      stateCurr.unshift("-")
      stateCurr.push ("-")
      stateCurr.push ("-")
      puts("Which empty space would you like to move the coins to? Select the leftmost area in the pairs.", stateCurr.join)
      j = gets.length.to_i-1

      # Validates consecutive empty spaces
      while((j >= stateCurr.length-1) || (stateCurr[j] != "-" || stateCurr[j+1] != "-"))
        puts("You selected an invalid pair. Please select the leftmost point of two consecutive empty slots.", stateCurr.join)
        j = gets.length.to_i-1
      end

      while(i == j)
          puts("Cant move coins to the same position. Please pick a different spot.", stateCurr.join)
          j = gets.length.to_i-1
          while((j >= stateCurr.length-1) || (stateCurr[j] != "-" || stateCurr[j+1] != "-"))
            puts("You selected an invalid pair. Please select the leftmost point of two consecutive empty slots.", stateCurr.join)
            j = gets.length.to_i-1
           
          end
         
      end

      while(i == stateOrigin.length-2 && j == stateCurr.length-2)
        puts("Cant move coins to the same position. Please pick a different spot.", stateCurr.join)
        j = gets.length.to_i-1
        while((j >= stateCurr.length ) || (stateCurr[j] != "-" || stateCurr[j+1] != "-"))
          puts("You selected an invalid pair. Please select the leftmost point of two consecutive empty slots.", stateCurr.join)
          j = gets.length.to_i-1
        end
      end
     
      # If front of the line is selected
      if (j == 0)
        
        stateCurr[j] = stateOrigin[i]
        stateCurr[j+1] = stateOrigin[i+1]
        stateCurr[i+2] = "-"
        stateCurr[i+3] = "-"
        stateCurr.pop(2)
      # If back of the line is selected
      else
        stateCurr[j] = stateOrigin[i]
        stateCurr[j+1] = stateOrigin[i+1]
        stateCurr[i+2] = "-"
        stateCurr[i+3] = "-"
        stateCurr = stateCurr.drop(2)
      end
      
    else 
      #Move Selected pair to empty spot
      puts("Moving coins to intermediate empty slot")
      stateCurr[empty] = stateCurr[i]
      stateCurr[empty + 1] = stateCurr[i + 1]
      stateCurr[i] = "-"
      stateCurr[i + 1] = "-"
    end

    if(stateCurr[0] == "-" && stateCurr[1] == "-")
      stateCurr = stateCurr.drop(2)
    elsif(stateCurr[stateCurr.length-2] == "-" && stateCurr[stateCurr.length-1] == "-")
      stateCurr.pop(2)
    end
  
    #Set Index of empty slot for next turn
    empty = 0
    for x in 0..stateCurr.length-1 do
      if(stateCurr[x] == "-")
        empty = x
        break
      end
    end
    
    #Reset Origin for next turn
    stateOrigin = stateCurr.dup
    #Decrememnt turn counter at end of each turn
    turns = turns - 1

    puts("-------------------------------------------------------------------------------------------------------------------------------")
  end
  
  puts("Turns Remaining: ", turns, "\nCurrent State:", stateCurr.join, "\n")

  if(stateCurr == $WIN_CON_1 || stateCurr == $WIN_CON_2)
    puts("Game Over. You Win")
  else
    puts("Game Over. Better Luck Next Time")
  end
end

# Run Program
game