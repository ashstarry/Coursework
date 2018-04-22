
#include <iostream>
#include <vector>
#include <map>
#include <stdio.h>
#include <string>
using namespace std;

class BigInt
{
private:
    vector<int> storage;
    // I needed these next 2 functions but you may or may not need them depending on how you implement your class
    void borrow(BigInt &, int); // I used this in the substraction function
    void stripLeadingZero(BigInt &); // You need to make sure you don't have numbers like this: '0123'
public:
    BigInt();
    BigInt(int);
    BigInt(string);
    BigInt operator++(int);
    bool operator<=(int);
    bool operator<=(BigInt);
    bool operator==(int);
    bool operator==(BigInt);
    BigInt operator-(BigInt);
    BigInt operator-(int);
    BigInt operator+(BigInt);
    BigInt operator+(int);
    bool operator<(int);
    bool operator<(const BigInt &) const; // This is required for the map
    friend ostream & operator<<(ostream &, const BigInt &);
};

// You must modify this function so that it runs in a reasonable time for input of 1000
// You must use a map<BigInt, BigInt>
BigInt GoldRabbits(BigInt N)
{
    static map<BigInt, BigInt> gMap;
    gMap[N] = (N == 0 || N == 1) ? BigInt(1) : gMap[N - 1] + gMap[N - 2];
    return gMap[N];
}

// You must modify this function so it throws an exception if the result overflows
int fact(int n)
{
    if (n > 12)
        throw "Exception";
    return (n == 0) ? 1 : n * fact(n - 1);
}

int main()
{
    BigInt A(28675), B("46368"), Sum;
    Sum = A + B;
    cout << A << "+" << B << "=" << Sum;
    
    getchar(); // pause
    
    for (BigInt n = 0; n <= 1000; n++)
    {
        cout << (n < 950 ? "\n" : "\n\n") << "The GoldRabbit of (" << n << ") is " << GoldRabbits(n);
        if (n == 30) // pause at 30
            getchar();
    }
    
    getchar(); // pause after the GoldRabbits
    
    for(int i = 0; i < 20; i++)
    {
        try {
            cout << "Fact(" << i << "):" << fact(i) << endl;
        }
        catch (...) {
            cout << "Fact(" << i << "): Overflow" << endl;
        }
    }
    
    getchar();
    return 0;
}

BigInt::BigInt()
{
    storage.push_back(0);
}

BigInt::BigInt(int n)
{
    do{
        storage.push_back(n % 10);
        n /= 10;
    } while (n != 0);
}

BigInt::BigInt(string S)
{
    int val;
    for (int i = S.length() - 1; i >= 0; i--)
    {
        val = S.at(i) - '0';
        storage.push_back(val);
    }
}

void BigInt::borrow(BigInt & N, int n)
{
    N.storage[n] += 10;
    N.storage[n+1] -= 1;
}

void BigInt::stripLeadingZero(BigInt & N)
{
    N.storage.erase(N.storage.end() - 1);
}

BigInt BigInt::operator+(int n)
{
    return *this + BigInt(n);
}

BigInt BigInt::operator+(BigInt N)
{
    BigInt temp(*this);
    while (temp.storage.size() != N.storage.size())
        (temp.storage.size() < N.storage.size()) ? temp.storage.push_back(0): N.storage.push_back(0);
    
    int carry = 0;
    for (int i = 0; i < N.storage.size(); i++)
    {
        if (temp.storage[i] == 0 && N.storage[i] == 0 && carry != 0)
        {
            temp.storage[i] += carry;
            carry = 0;
        }
        temp.storage[i] += (N.storage[i] + carry);
        carry = 0;
        if (temp.storage[i] > 9)
        {
            carry++;
            temp.storage[i] %= 10;
            if (i == N.storage.size() - 1)
                temp.storage.push_back(carry);
        }
    }
    return temp;
}

BigInt BigInt::operator++(int dummy)
{
    *this = *this + BigInt(1);
    return *this;
}

BigInt BigInt::operator-(int n)
{
    return *this - BigInt(n);
}

BigInt BigInt::operator-(BigInt N)
{
    BigInt temp(*this);
    while (temp.storage.size() != N.storage.size())
        (temp.storage.size() < N.storage.size()) ? temp.storage.push_back(0): N.storage.push_back(0);
    
    for(int i = 0; i < temp.storage.size(); i++)
    {
        if(temp.storage[i] < N.storage[i])
        {
            borrow(temp, i);
            temp.storage[i] -= N.storage[i];
        }
        else
            temp.storage[i] -= N.storage[i];
        if(temp.storage[i] == 0 && N.storage[i] == 0 && i == temp.storage.size() - 1)
            stripLeadingZero(temp);
    }
    return temp;
}

bool BigInt::operator<(int n)
{
    return *this < BigInt(n);
}

bool BigInt::operator<(const BigInt & N) const
{
    BigInt temp(*this);
    if (temp.storage.size() != N.storage.size())
        return (temp.storage.size() < N.storage.size()) ? true : false;
    else
        for (int i = temp.storage.size() - 1; i >= 0; i--)
            if (temp.storage[i] != N.storage[i])
                return (temp.storage[i] < N.storage[i]) ? true : false;
    return false;
}

bool BigInt::operator==(int n)
{
    return *this == BigInt(n);
}

bool BigInt::operator==(BigInt N)
{
    BigInt temp(*this);
    bool isEquals = false;
    if (temp.storage.size() == N.storage.size())
    {
        isEquals = true;
        for (int i = 0; i < temp.storage.size(); i++)
            if (temp.storage[i] != N.storage[i])
                isEquals = false;
    }
    return isEquals;
}

bool BigInt::operator<=(int n)
{
    return *this <= BigInt(n);
}

bool BigInt::operator<=(BigInt N)
{
    return (*this < N || *this == N) ? true : false;
}

ostream & operator<<(ostream & out, const BigInt & N)
{
    vector<int> print = N.storage;
    vector<int>::reverse_iterator rit;
    
    for (rit = print.rbegin(); rit != print.rend(); rit ++)
        out << *rit;
    return out;
}




