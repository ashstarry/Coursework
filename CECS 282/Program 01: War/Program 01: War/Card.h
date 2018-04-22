//
//  Card.h
//  Program 01: War
//
//  Created by Breeland Abrams on 9/21/17.
//  Copyright © 2017 Breeland Abrams. All rights reserved.
//

#ifndef Card_h
#define Card_h
#include <iostream>
using namespace std;
class Card
{
private:
    int value;
    char suit;
    string rank;
public:
    Card();
    Card(char, string);
    void setCard(char, string);
    int getValue();
    string rankToString();
    void showCard();
};

#endif /* Card_h */
