//
//  upDate.cpp
//  Program 04: Overloading Operators
//  CECS 282
//  Created by Breeland Abrams on 11/1/17.
//  Copyright © 2017 Breeland Abrams. All rights reserved.
//

#include "upDate.hpp"
#include <iostream>
#include <string>
#include <math.h>
using namespace std;

int upDate::counter = 0;

int Greg2Julian(int month, int day, int year)
{
    int JD = day-32075+1461*(year+4800+(month-14)/12)/4+367*(month-2-(month-14)/12*12)/12-3*((year+4900+(month-14)/12)/100)/4;
    return JD;
}

void Julian2Greg(int JD, int &month, int &day, int &year)
{
    int i, j, k, l, n;
    l = JD + 68569;
    n = 4 * l / 146097;
    l = l - (146097 * n + 3) / 4;
    i = 4000 * (l + 1) / 1461001;
    l = l -1461 * i /4 +31;
    j = 80 * l / 2447;
    k = l - 2447 * j / 80;
    l = j / 11;
    j = j + 2 - 12 * l;
    i = 100 * (n-49) + i + l;
    
    year = i;
    month = j;
    day = k;
    
}


upDate::upDate()
{
    dptr = new int[3];
    dptr[0] = 5;
    dptr[1] = 11;
    dptr[2] = 1959;
    counter += 1;
    
}

upDate::upDate(int m, int d, int y)
{
    dptr = new int[3];
    dptr[0] = m;
    dptr[1] = d;
    dptr[2] = y;
    counter++;
}

upDate::upDate(const upDate &date)
{
    dptr = new int[3];
    dptr[0] = date.dptr[0];
    dptr[1] = date.dptr[1];
    dptr[2] = date.dptr[2];
    counter++;
}

upDate::~upDate()
{
    delete[] dptr;
    counter--;
}
int upDate::getMonth()
{
    return dptr[0];
}
int upDate::getDay()
{
    return dptr[1];
}
int upDate::getYear()
{
    return dptr[2];
}

int upDate::julian()
{
    return Greg2Julian(getMonth(), getDay(), getYear());
}

int upDate::GetDateCount()
{
    return counter;
}

//Overloaded Addition - Object + integer
upDate upDate::operator+(int i)
{
    upDate temp(dptr[0], dptr[1], dptr[2]);
    int JD = Greg2Julian(temp.dptr[0], temp.dptr[1], temp.dptr[2]);
    JD += i;
    Julian2Greg(JD, temp.dptr[0], temp.dptr[1], temp.dptr[2]);
    return upDate(temp.dptr[0], temp.dptr[1], temp.dptr[2]);
}

//Overloaded Addition - Integer + Object
upDate operator+(int i, upDate date)
{
    return date + i;
   
}
//Overloaded Increment - Prefix
upDate upDate::operator++()
{
    int JD = Greg2Julian(dptr[0], dptr[1], dptr[2]);
    JD += 1;
    Julian2Greg(JD, dptr[0], dptr[1], dptr[2]);
    return upDate(dptr[0], dptr[1], dptr[2]);
}
//Overloaded Increment - Postfix
upDate upDate::operator++(int i)
{
    int JD = Greg2Julian(dptr[0], dptr[1], dptr[2]);
    JD += 1;
    Julian2Greg(JD, dptr[0], dptr[1], dptr[2]);
    return upDate(dptr[0], dptr[1], dptr[2]);
}
//Overloaded Subtraction - Object - Integer
upDate upDate::operator-(int i)
{
    upDate temp(dptr[0], dptr[1], dptr[2]);
    int JD = Greg2Julian(temp.dptr[0], temp.dptr[1], temp.dptr[2]);
    JD -= i;
    Julian2Greg(JD, temp.dptr[0], temp.dptr[1], temp.dptr[2]);
    return upDate(temp.dptr[0], temp.dptr[1], temp.dptr[2]);
}
//Overloaded Subtraction - Two Objects
int operator-(const upDate& a, const upDate& b)
{
    int JDA = Greg2Julian(a.dptr[0], a.dptr[1], a.dptr[2]);
    int JDB = Greg2Julian(b.dptr[0], b.dptr[1], b.dptr[2]);
    return JDA - JDB;
}
//Overloaded Decrement - Prefix
upDate upDate::operator--()
{
    int JD = Greg2Julian(dptr[0], dptr[1], dptr[2]);
    JD -= 1;
    Julian2Greg(JD, dptr[0], dptr[1], dptr[2]);
    return upDate(dptr[0], dptr[1], dptr[2]);
}
//Overloaded Decrement - Postfix
upDate upDate::operator--(int i)
{
    int JD = Greg2Julian(dptr[0], dptr[1], dptr[2]);
    JD -= 1;
    Julian2Greg(JD, dptr[0], dptr[1], dptr[2]);
    return upDate(dptr[0], dptr[1], dptr[2]);
}
//Overloaded Boolean - ==
bool operator==(const upDate& a, const upDate& b)
{
    int JDA = Greg2Julian(a.dptr[0], a.dptr[1], a.dptr[2]);
    int JDB = Greg2Julian(b.dptr[0], b.dptr[1], b.dptr[2]);
    return JDA == JDB;
}
//Overloaded Operator - =
void upDate::operator=(const upDate& a)
{
    dptr[0] = a.dptr[0];
    dptr[1] = a.dptr[1];
    dptr[2] = a.dptr[2];
}
//Overloaded Boolean - <
bool operator<(const upDate& a, const upDate& b)
{
    int JDA = Greg2Julian(a.dptr[0], a.dptr[1], a.dptr[2]);
    int JDB = Greg2Julian(b.dptr[0], b.dptr[1], b.dptr[2]);
    return JDA < JDB;
}
//Overloaded Boolean - >
bool operator>(const upDate& a, const upDate& b)
{
    int JDA = Greg2Julian(a.dptr[0], a.dptr[1], a.dptr[2]);
    int JDB = Greg2Julian(b.dptr[0], b.dptr[1], b.dptr[2]);
    return JDA > JDB;
}
//Overloaded Ostream - cout
ostream& operator<<(ostream& os, const upDate& d)
{
    os << d.dptr[0] << "/" << d.dptr[1] << "/" << d.dptr[2];
    return os;
}














