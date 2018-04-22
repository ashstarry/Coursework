//
//  Card.cpp
//  Program 01: War
//
//  Created by Breeland Abrams on 9/7/17.
//  Copyright © 2017 Breeland Abrams. All rights reserved.
//

#include "Card.h"
#include <iostream>
#include <string>
using namespace std;

            Card::Card()
            {
                suit = ' ';
                rank = "";
            }
    
            Card::Card(char s, string r)
            {
                suit = s;
                rank = "";
            }
    
            void Card::setCard(char s, string r)
            {
                suit = s;
                rank = r;
            }
    
            int Card::getValue()
            {
                if(rank == "A")
                {
                    value = 1;
                }
                if(rank == "2")
                {
                    value = 2;
                }
                if(rank == "3")
                {
                    value = 3;
                }
                if(rank == "4")
                {
                    value = 4;
                }
                if(rank == "5")
                {
                    value = 5;
                }
                if(rank == "6")
                {
                    value = 6;
                }
                if(rank == "7")
                {
                    value = 7;
                }
                if(rank == "8")
                {
                    value = 8;
                }
                if(rank == "9")
                {
                    value = 9;
                }
                if(rank == "10")
                {
                    value = 10;
                }
                if(rank == "J")
                {
                    value = 11;
                }
                if(rank == "Q")
                {
                    value = 12;
                }
                if(rank == "K")
                {
                    value = 13;
                }
                
                return value;
            }
    
            string Card::rankToString()
            {
                string sRank = " ";
                if(rank == "A")
                {
                    sRank = "Ace";
                }
                if(rank == "2")
                {
                    sRank = "2";
                }
                if(rank == "3")
                {
                    sRank = "3";
                }
                if(rank == "4")
                {
                    sRank = "4";
                }
                if(rank == "5")
                {
                    sRank = "5";
                }
                if(rank == "6")
                {
                    sRank = "6";
                }
                if(rank == "7")
                {
                    sRank ="7";
                }
                if(rank == "8")
                {
                    sRank = "8";
                }
                if(rank == "9")
                {
                    sRank = "9";
                }
                if(rank == "10")
                {
                    sRank = "10";
                }
                if(rank == "J")
                {
                    sRank = "Jack";
                }
                if(rank == "Q")
                {
                    sRank = "Queen";
                }
                if(rank == "K")
                {
                    sRank = "King";
                }
             
                return sRank;

            }
    
            void Card::showCard()
            {
               if(suit == 'S')
               {
                   if(rank == "10")
                   {
                       cout << rankToString() << " of Spades \n";
                       
                       cout << " --------- \n";
                       cout << "["<< rank <<"       ]\n";
                       cout << "[    *    ]\n";
                       cout << "[   * *   ]\n";
                       cout << "[  * * *  ]\n";
                       cout << "[ *  *  * ]\n";
                       cout << "[    *    ]\n";
                       cout << "[       "<< rank <<"]\n";
                       cout << " --------- \n";

                   }
                   else
                   {
                       cout << rankToString() << " of Spades \n";
                       
                       cout << " --------- \n";
                       cout << "["<<rank<<"        ]\n";
                       cout << "[    *    ]\n";
                       cout << "[   * *   ]\n";
                       cout << "[  * * *  ]\n";
                       cout << "[ *  *  * ]\n";
                       cout << "[    *    ]\n";
                       cout << "[        "<<rank<<"]\n";
                       cout << " --------- \n";

                   }
               }
                if(suit == 'H')
                {
                    if(rank == "10")
                    {
                        cout << rankToString() << " of Hearts \n";
                        
                        cout << " --------- \n";
                        cout << "["<< rank <<"       ]\n";
                        cout << "[  ** **  ]\n";
                        cout << "[ *  *  * ]\n";
                        cout << "[  *   *  ]\n";
                        cout << "[   * *   ]\n";
                        cout << "[    *    ]\n";
                        cout << "[       "<< rank <<"]\n";
                        cout << " --------- \n";

                    }
                    else
                    {
                        cout << rankToString() << " of Hearts \n";
                        
                        cout << " --------- \n";
                        cout << "["<<rank<<"        ]\n";
                        cout << "[  ** **  ]\n";
                        cout << "[ *  *  * ]\n";
                        cout << "[  *   *  ]\n";
                        cout << "[   * *   ]\n";
                        cout << "[    *    ]\n";
                        cout << "[        "<<rank<<"]\n";
                        cout << " --------- \n";
                    }
                }
                if(suit == 'D')
                {
                    if(rank == "10")
                    {
                        cout << rankToString() << " of Diamonds \n";
                        
                        cout << " --------- \n";
                        cout << "["<< rank <<"       ]\n";
                        cout << "[    *    ]\n";
                        cout << "[   * *   ]\n";
                        cout << "[  *   *  ]\n";
                        cout << "[   * *   ]\n";
                        cout << "[    *    ]\n";
                        cout << "[       "<< rank <<"]\n";
                        cout << " --------- \n";

                    }
                    else
                    {
                      cout << rankToString() << " of Diamonds \n";
                        
                      cout << " --------- \n";
                      cout << "["<<rank<<"        ]\n";
                      cout << "[    *    ]\n";
                      cout << "[   * *   ]\n";
                      cout << "[  *   *  ]\n";
                      cout << "[   * *   ]\n";
                      cout << "[    *    ]\n";
                      cout << "[        "<<rank<<"]\n";
                      cout << " --------- \n";
                    }
                }
                if(suit == 'C')
                {
                    if(rank == "10")
                    {
                        cout << rankToString() << " of Clubs \n";
                        
                        cout << " --------- \n";
                        cout << "["<< rank <<"       ]\n";
                        cout << "[    *    ]\n";
                        cout << "[ *  *  * ]\n";
                        cout << "[  * * *  ]\n";
                        cout << "[    *    ]\n";
                        cout << "[    *    ]\n";
                        cout << "[       "<< rank <<"]\n";
                        cout << " --------- \n";
                    }
                    else
                    {
                        cout << rankToString() << " of Clubs \n";
                        
                        cout << " --------- \n";
                        cout << "["<<rank<<"        ]\n";
                        cout << "[    *    ]\n";
                        cout << "[ *  *  * ]\n";
                        cout << "[  * * *  ]\n";
                        cout << "[    *    ]\n";
                        cout << "[    *    ]\n";
                        cout << "[        "<<rank<<"]\n";
                        cout << " --------- \n";
                        
                    }
                    
                }
                
            }

