//
//  Deck.cpp
//  Program 01: War
//
//  Created by Breeland Abrams on 9/7/17.
//  Copyright © 2017 Breeland Abrams. All rights reserved.
//

#include <stdio.h>
#include <string>
#include "Card.h"
#include "Deck.h"
#include <iostream>
using namespace std;

            Deck::Deck()
            {
                char s[4] = {'H', 'D', 'C', 'S'};
                string r[13] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
                for(int i = 0; i < 4; i++)
                {
                    for(int j = 0; j < 13; j++)
                    {
                        data[topCard].setCard(s[i], r[j]);
                        topCard++;
                    }
                }
                topCard = 0;
            }
            void Deck::refreshDeck()
            {
                topCard = 0;
                char s[4] = {'H', 'D', 'C', 'S'};
                string r[13] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
                for(int i = 0; i < 4; i++)
                {
                    for(int j = 0; j < 13; j++)
                    {
                        data[topCard].setCard(s[i], r[j]);
                        topCard++;
                    }
                }
                topCard = 0;
                
            }
    
            Card Deck::deal()
            {
                Card top = data[topCard];
                topCard++;
                return top;
            }
    
            void Deck::shuffle()
            {
                Card temp;
                for(int i = 0; i < 52; i++)
                {
                    int x = rand() % 52;
                    temp = data[i];
                    data[i] = data[x];
                    data[x] = temp;
                }
            }
    
            void Deck::showDeck()
            {
                int i = topCard;
                while(i <= cardsRemaining())
                {
                    data[i].showCard();
                    i++;
                }
                
            }
    
            int Deck::cardsRemaining()
            {
                return 52-topCard;
            }

