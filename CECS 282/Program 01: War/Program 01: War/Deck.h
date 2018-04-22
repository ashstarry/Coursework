//
//  Deck.h
//  Program 01: War
//
//  Created by Breeland Abrams on 9/21/17.
//  Copyright © 2017 Breeland Abrams. All rights reserved.
//

#ifndef Deck_h
#define Deck_h
#include "Card.h"

class Deck
{
private:
    Card data[53];
    int topCard = 0;
    
public:
    Deck();
    void refreshDeck();
    Card deal();
    void shuffle();
    void showDeck();
    int cardsRemaining();
};


#endif /* Deck_h */
