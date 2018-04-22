//
//  Breeland Abrams
//  CECS 282-05
//  Program 02: ADT
//  10/3/17
//  Created by Breeland Abrams on 9/26/17.
//  Copyright © 2017 Breeland Abrams. All rights reserved.
//

#include "myDate.hpp"
#include <iostream>
#include <string>
#include <math.h>
using namespace std;
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

myDate::myDate()
{
    myDate::month = 5;
    myDate::day = 11;
    myDate::year = 1959;
}

myDate::myDate(int M, int D, int Y)
{
    if(M < 1 || M > 12)
    {
        myDate::month = 5;
        myDate::day = 11;
        myDate::year = 1959;
    }
    else
    {
        myDate::month = M;
        myDate::day = D;
        myDate::year = Y;
        
    }
    
    switch(month)
    {
        case 1: if(day < 1 || day > 31){ myDate::month = 5; myDate::day = 11; myDate::year = 1959; } break;
        case 2: if(day < 1 || day > 29){ myDate::month = 5; myDate::day = 11; myDate::year = 1959; } break;
        case 3: if(day < 1 || day > 31){ myDate::month = 5; myDate::day = 11; myDate::year = 1959; } break;
        case 4: if(day < 1 || day > 30){ myDate::month = 5; myDate::day = 11; myDate::year = 1959; } break;
        case 5: if(day < 1 || day > 31){ myDate::month = 5; myDate::day = 11; myDate::year = 1959; } break;
        case 6: if(day < 1 || day > 30){ myDate::month = 5; myDate::day = 11; myDate::year = 1959; } break;
        case 7: if(day < 1 || day > 31){ myDate::month = 5; myDate::day = 11; myDate::year = 1959; } break;
        case 8: if(day < 1 || day > 31){ myDate::month = 5; myDate::day = 11; myDate::year = 1959; } break;
        case 9: if(day < 1 || day > 30){ myDate::month = 5; myDate::day = 11; myDate::year = 1959; } break;
        case 10: if(day < 1 || day > 31){ myDate::month = 5; myDate::day = 11; myDate::year = 1959; } break;
        case 11: if(day < 1 || day > 30){ myDate::month = 5; myDate::day = 11; myDate::year = 1959; } break;
        case 12: if(day < 1 || day > 31){ myDate::month = 5; myDate::day = 11; myDate::year = 1959; } break;
        default: break;
    }
    
}

void myDate::display()
{
    switch(month)
    {
        case 1: cout << "January " << day << ", " << year; break;
        case 2: cout << "February " << day << ", " << year; break;
        case 3: cout << "March " << day << ", " << year; break;
        case 4: cout << "April " << day << ", " << year; break;
        case 5: cout << "May " << day << ", " << year; break;
        case 6: cout << "June " << day << ", " << year; break;
        case 7: cout << "July " << day << ", " << year; break;
        case 8: cout << "August " << day << ", " << year; break;
        case 9: cout << "September " << day << ", " << year; break;
        case 10: cout << "October " << day << ", " << year; break;
        case 11: cout << "November " << day << ", " << year; break;
        case 12: cout << "December " << day << ", " << year; break;
        default: break;
    }
}

string myDate:: toString()
{
    string date;
    switch(month)
    {
        case 1: date = "January "; break;
        case 2: date = "February "; break;
        case 3: date = "March "; break;
        case 4: date = "April "; break;
        case 5: date = "May "; break;
        case 6: date = "June "; break;
        case 7: date = "July "; break;
        case 8: date = "August "; break;
        case 9: date = "September "; break;
        case 10: date = "October "; break;
        case 11: date = "November "; break;
        case 12: date = "December "; break;
        default: break;
    }
    date.append("");
    date.append(to_string(day));
    date.append(", ");
    date.append(to_string(year));
    
    return date;
}
void myDate::incrDate(int N)
{
    int JD = Greg2Julian(month, day, year);
    JD = JD + N;
    Julian2Greg(JD, month, day, year);
}

void myDate::decrDate(int N)
{
    int JD = Greg2Julian(month, day, year);
    JD = JD - N;
    Julian2Greg(JD, month, day, year);
}

int myDate::daysBetween(myDate D)
{
    int passIn = Greg2Julian(D.getMonth(), D.getDay(), D.getYear());
    int current = Greg2Julian(month, day, year);
    return  passIn - current;
}

int myDate::getMonth()
{
    return month;
}

int myDate::getDay()
{
    return day;
}

int myDate::getYear()
{
    return year;
}

int myDate::dayOfYear()
{
    int currentJD = Greg2Julian(month, day, year);
    int firstDayJD = Greg2Julian(1, 1, year);
    return currentJD - firstDayJD + 1;
}

string myDate::dayOfWeek()
{
    int dow = Greg2Julian(month, day, year) % 7;
    switch(dow){
        case 0: return "Monday"; break;
        case 1: return "Tuesday"; break;
        case 2: return "Wednesday"; break;
        case 3: return "Thursday"; break;
        case 4: return "Friday"; break;
        case 5: return "Saturday"; break;
        case 6: return "Sunday"; break;
        default: return " "; break;
            
    }
}

