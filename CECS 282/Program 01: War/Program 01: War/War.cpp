//
//
//  Program 01: War
//  Breeland Abrams
//  CECS 282
//  9/7/17.
//
//

#include <iostream>
#include "Deck.h"
#include <string>
using namespace std;
Deck myDeck;
bool initDeck = false;
int main()
{
    int choice;
    cout << "What would you like to do?\n1. Get New Deck\n2. Show Remaining Cards in Deck";
    cout <<"\n3. Shuffle\n4. Play War\n5. Exit";
    cin >> choice;
    switch (choice) {
        case 1:
        {
            myDeck.refreshDeck();
            cout << "\nNew Deck Created.\n";
            initDeck = true;
            main();
            break;
        }
        case 2:
        {
            cout << "\n" << myDeck.cardsRemaining() << " Cards Remaining: \n";
            myDeck.showDeck();
            main();
            break;
        }
        case 3:
        {
            myDeck.shuffle();
            cout << "\nDeck Shuffled.\n";
            main();
            break;
        }
        case 4:
        {
            if(!initDeck)
            {
                cout << "\nPlease Create a new Deck before playing\n";
                main();
            }
            else if(myDeck.cardsRemaining()<2)
            {
                cout << "\nThere are not enough cards remaining in the deck to continue. Please refresh the deck.\n";
                main();
            }
            else
            {
                bool continuePlay = false;
                do
                {
                    int count = myDeck.cardsRemaining();
                    if(count < 2)
                    {
                        cout << "\nThere are not enough cards remaining in the deck to continue.";
                        cout << " Please refresh the deck.\n";
                        main();
                    }
                    Card c1 = myDeck.deal();
                    Card c2 = myDeck.deal();
                    cout << "WAR!!!\nThere are " << count << " cards remaining in the deck.\n........ Dealing ........";
                    cout << "\n Your Card is: \n";
                    c1.showCard();
                    cout << "\n My Card is: \n";
                    c2.showCard();
                    
                    if(c1.getValue() > c2.getValue())
                    {
                        cout << "\nYou win this round\n";
                    }
                    else if (c2.getValue() > c1.getValue())
                    {
                        cout << "\nI win this round\n";
                    }
                    else if (c1.getValue() == c2.getValue())
                    {
                        cout << "\nWe have a tie.\n";
                    }
                    
                    cout << "\nDo you want to play again? (Y/N)\n";
                    
                    char decision;
                    cin >> decision;
                    
                    while(decision != 'y' && decision != 'Y' && decision !='n' && decision != 'N')
                    {
                        cout << "\n Please enter 'y' for yes or 'n' for no.\n";
                        cin >> decision;
                    }
                
                    if(decision == 'y' || decision == 'Y')
                    {
                        continuePlay = true;
                    }
                    else
                    {
                        continuePlay = false;
                    }
                }while(continuePlay);
                main();
            }
        }
        case 5:
        {
            cout << "\nThanks for Playing.\n";
            exit(0);
            break;
        }
        default:
                {
                    cout << "\nPlease choose a valid option from the menu.\n";
                    main();
                    break;
                }
    }

}


