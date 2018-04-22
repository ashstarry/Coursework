//
//  Breeland Abrams
//  Program 03 Student Structure
//  CECS 282
//  10/17/17.
//  Copyright © 2017 Breeland Abrams. All rights reserved.
//

#include <iostream>
#include <iomanip>
#include "myDate.hpp"
#include <string>
using namespace std;

struct Student
{
    char name[25];
    int ID;
    char grade;
    myDate bday;
    string hometown;
};
void populateStudents(Student s[]);
void studentDisplay(Student s);
void displayOriginal(Student s[]);
void sortName(Student s[]);
void sortID(Student s[]);
void sortGrade(Student s[]);
void sortBirthday(Student s[]);
void sortHometown(Student s[]);
void menu(Student s[]);
int main() {
    srand((int) time(0));
    Student s[10];
    populateStudents(s);
    menu(s);
    return 0;
}
void menu(Student s[])
{
    cout << "Menu:\n0) Display Original List\n1) Display List Sorted by Name\n2) Display List Sorted by ID";
    cout << "\n3) Display List Sorted by Grade\n4) Display List Sorted by Birthday\n5) Display List Sorted by Hometown";
    cout << "\n6) Exit" << endl;
    
    int choice;
    cin >> choice;
    switch(choice)
    {
        case 0:  {
            cout << "\n\nOriginal List\n" << endl;
            cout << left << setw(20) << "Name" << setw(20) << left << setw(10) << "ID"
                 << setw(20) << left << setw(10) << "Grade" << setw(10) << left << setw(20)
                 << "Birth Date" << setw(20) << left << setw(20) << "Hometown"<< setw(20) << endl;
            for(int i = 0; i < 10; i++)
            {
                Student temp = s[i];
                studentDisplay(temp);
            }
            cout << "\n\n";
            menu(s);
        }
        case 1: {
            cout << "\n\nBy Name\n" << endl;
            cout << left << setw(20) << "Name" << setw(20) << left << setw(10) << "ID"
            << setw(20) << left << setw(10) << "Grade" << setw(10) << left << setw(20)
            << "Birth Date" << setw(20) << left << setw(20) << "Hometown"<< setw(20) << endl;
            sortName(s);
            cout << "\n\n";
            menu(s);
        }
            
        case 2: {
            cout << "\n\nBy ID\n" << endl;
            cout << left << setw(20) << "Name" << setw(20) << left << setw(10) << "ID"
            << setw(20) << left << setw(10) << "Grade" << setw(10) << left << setw(20)
            << "Birth Date" << setw(20) << left << setw(20) << "Hometown"<< setw(20) << endl;
            sortID(s);
            cout << "\n\n";
            menu(s);
        }
        case 3: {
            cout << "\n\nBy Grade\n" << endl;
            cout << left << setw(20) << "Name" << setw(20) << left << setw(10) << "ID"
            << setw(20) << left << setw(10) << "Grade" << setw(10) << left << setw(20)
            << "Birth Date" << setw(20) << left << setw(20) << "Hometown"<< setw(20) << endl;
            sortGrade(s);
            cout << "\n\n";
            menu(s);
        }
            
        case 4: {
            cout << "\n\nBy Birthday\n" << endl;
            cout << left << setw(20) << "Name" << setw(20) << left << setw(10) << "ID"
            << setw(20) << left << setw(10) << "Grade" << setw(10) << left << setw(20)
            << "Birth Date" << setw(20) << left << setw(20) << "Hometown"<< setw(20) << endl;
            sortBirthday(s);
            cout << "\n\n";
            menu(s);
        }
        case 5: {
            cout << "\n\nBy Hometown\n" << endl;
            cout << left << setw(20) << "Name" << setw(20) << left << setw(10) << "ID"
            << setw(20) << left << setw(10) << "Grade" << setw(10) << left << setw(20)
            << "Birth Date" << setw(20) << left << setw(20) << "Hometown"<< setw(20) << endl;
            sortHometown(s);
            cout << "\n\n";
            menu(s);
        }
        case 6: {
            exit(0);
        }

        default:{
            menu(s);
        }
            
    }
}
void populateStudents(Student s[])
{
    
   const char *names[10] = {"Anthony Stark", "Steve Rogers", "Peter Parker", "Bruce Banner", "Thor Odinson", "Clint Barton", "Natasha Romanova", "Scott Lang", "James Rhodes", "Sam Wilson"};
    string hometown[10] = {"Long Island, NY", "Brooklyn, NY", "Queens, NY", "Dayton, OH", "Asgard", "Wayverly, IA", "Volgograd, Russia", "Coral Gables, FL", "Philadelphia, PA", "New York, NY"};
    char grade[5] = {'A', 'B', 'C', 'D', 'F'};
    
    for(int i = 0; i < 10; i++)
    {
        Student temp;
        strcpy(temp.name, names[i]);
        temp.ID = rand() % ((9999-1000) + 1) + 1000;
        temp.grade = grade[(rand() % 5)];
        int JD = rand() % ((Greg2Julian(1, 1, 1995) - Greg2Julian(12, 31, 2000)) + 1) + Greg2Julian(1, 1, 1995);
        int month, day, year;
        Julian2Greg(JD, month, day, year);
        temp.bday = myDate(month, day, year);
        temp.hometown = hometown[i];
        s[i] = temp;
    }
}

void studentDisplay(Student s)
{
    cout << left << setw(20) << s.name << setw(10)
         << left << setw(10) << left << s.ID << setw(10) << left << s.grade
         << setw(20) << s.bday.toString() << left
         << setw(10) << left << setw(10) << s.hometown << setw(10) <<endl;
}
/*
         SORT BY NAME
 */
void sortName(Student s[])
{
    Student *namePointers[10];
    for(int i = 0; i < 10; i++)
    {
        namePointers[i] = &s[i];
    }
    
    for(int j = 0; j < 10; j++)
    {
        for(int k = 0; k < 10; k++)
        {
            if(strcmp(namePointers[j]->name, namePointers[k]->name) < 0)
            {
                Student *temp = namePointers[j];
                namePointers[j] = namePointers[k];
                namePointers[k] = temp;
            }
            
        }
    }
    
    for(int l = 0; l < 10; l++)
    {
        studentDisplay(*namePointers[l]);
    }
}
/*
             SORT BY ID NUMBER
 */
void sortID(Student s[])
{
    Student *idPointers[10];
    for(int i = 0; i < 10; i++)
    {
        idPointers[i] = &s[i];
    }
    
    for(int j = 0; j < 10; j++)
    {
        for(int k = 0; k < 10; k++)
        {
            if(idPointers[j]->ID < idPointers[k]->ID)
            {
                Student *temp = idPointers[j];
                idPointers[j] = idPointers[k];
                idPointers[k] = temp;
                
            }
        }
        
    }
    
    for(int l = 0; l < 10; l++)
    {
        studentDisplay(*idPointers[l]);
    }

}
/*
         SORT BY GRADE
 */

void sortGrade(Student s[])
{
    Student *gradePointers[10];
    for(int i = 0; i < 10; i++)
    {
        gradePointers[i] = &s[i];
    }
    
    for(int j = 0; j < 10; j++)
    {
        for(int k = 0; k < 10; k++)
        {
            if(gradePointers[j]->grade < gradePointers[k]->grade)
            {
                Student *temp = gradePointers[j];
                gradePointers[j] = gradePointers[k];
                gradePointers[k] = temp;
            }
            if(gradePointers[j]->grade == gradePointers[k]->grade)
            {
                if(strcmp(gradePointers[j]->name, gradePointers[k]->name) < 0)
                {
                    Student *temp = gradePointers[j];
                    gradePointers[j] = gradePointers[k];
                    gradePointers[k] = temp;
                }
            }
        }
    }
    
    for(int l = 0; l < 10; l++)
    {
        studentDisplay(*gradePointers[l]);
    }
}


/*
             SORT BY BIRTHDAY
*/
void sortBirthday(Student s[])
{
    Student *birthdayPointers[10];
    for(int i = 0; i < 10; i++)
    {
        birthdayPointers[i] = &s[i];
    }
    
    for(int j = 0; j < 10; j++)
    {
        for(int k = 0; k < 10; k++)
        {
            myDate temp1 = birthdayPointers[j]->bday;
            myDate temp2 = birthdayPointers[k]->bday;
            int JD1 = Greg2Julian(temp1.getMonth(), temp1.getDay(), temp1.getYear());
            int JD2 = Greg2Julian(temp2.getMonth(), temp2.getDay(), temp2.getYear());
            if(JD1 < JD2)
            {
                Student *temp = birthdayPointers[j];
                birthdayPointers[j] = birthdayPointers[k];
                birthdayPointers[k] = temp;
            }
            
        }
    }
    
    for(int l = 0; l < 10; l++)
    {
        studentDisplay(*birthdayPointers[l]);
    }
}
/*
         SORT BY HOMETOWN
 */
void sortHometown(Student s[])
{
    Student *homeTownPointers[10];
    for(int i = 0; i < 10; i++)
    {
        homeTownPointers[i] = &s[i];
    }
    
    for(int j = 0; j < 10; j++)
    {
        for(int k = 0; k < 10; k++)
        {
            if(homeTownPointers[j]->hometown.compare(homeTownPointers[k]->hometown) < 0)
            {
                Student *temp = homeTownPointers[j];
                homeTownPointers[j] = homeTownPointers[k];
                homeTownPointers[k] = temp;
            }
            
        }
    }
    
    for(int l = 0; l < 10; l++)
    {
        studentDisplay(*homeTownPointers[l]);
    }
}


