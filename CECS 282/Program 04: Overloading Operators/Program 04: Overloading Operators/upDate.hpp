//
//  upDate.hpp
//  Program 04: Overloading Operators
//
//  Created by Breeland Abrams on 11/1/17.
//  Copyright © 2017 Breeland Abrams. All rights reserved.
//

#ifndef upDate_hpp
#define upDate_hpp

#include <stdio.h>
#include <string>
using namespace std;
int Greg2Julian(int, int, int);
void Julian2Greg(int, int&, int&, int&);
class upDate
{
private:
    int *dptr;
    static int counter;
public:
    upDate();
    upDate(int, int, int);
    upDate(const upDate&);
    upDate operator+(int);
    friend upDate operator+(int, upDate);
    upDate operator-(int);
    friend int operator-(const upDate&, const upDate&);
    upDate operator++();
    upDate operator++(int);
    upDate operator--();
    upDate operator--(int);
    friend bool operator==(const upDate&, const upDate&);
    void operator=(const upDate&);
    friend bool operator<(const upDate&, const upDate&);
    friend bool operator>(const upDate&, const upDate&);
    int getMonth();
    int getDay();
    int getYear();
    static int GetDateCount();
    int julian();
    ~upDate();
    friend ostream& operator<<(ostream&, const upDate&);

};
#endif /* upDate_hpp */
