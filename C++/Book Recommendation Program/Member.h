Member.h

#include "Rating.h"
#include <string>
#include <iostream>

#ifndef MEMBER_H
#define MEMBER_H
using namespace std;

class Member
{
public:
Member(string _name = "unknown", string _accName = "unknown");
Member(const Member &rhs);
Member& operator=(const Member &rhs);
void updateName(string _name);
void updateAccName(string _accName);
void insertRating(int _rate);
void changeRating(int _rate, int _index);
int getRating(int index);
string getName()const;
string getAccName()const;
private:
string name,
   accName;
Rating userRating;
};
#endif
