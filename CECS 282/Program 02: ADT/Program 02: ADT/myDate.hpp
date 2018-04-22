//
//  myDate.hpp
//  Program 02: ADT
//
//  Created by Breeland Abrams on 9/26/17.
//  Copyright © 2017 Breeland Abrams. All rights reserved.
//

#ifndef myDate_hpp
#define myDate_hpp
#include <stdio.h>
#include <string>
using namespace std;

int Greg2Julian(int, int, int);
void Julian2Greg(int, int&, int&, int&);
class myDate
{
private:
    int month, day, year;
public:
    myDate();
    myDate(int M, int D, int Y);
    void display();
    string toString();
    void incrDate(int N);
    void decrDate(int N);
    int daysBetween(myDate D);
    int getMonth();
    int getDay();
    int getYear();
    int dayOfYear();
    string dayOfWeek();
};
#endif /* myDate_hpp */

