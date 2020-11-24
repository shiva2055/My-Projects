Rating.h
#include <iostream>
#include <string>
#ifndef RATING_H
#define RATING_H
using namespace std;

class Rating
{
public:
typedef int ElementType;
Rating(int initialCap = INITIALCAP);
Rating(const Rating &rhs);
Rating& operator=(const Rating &rhs);
ElementType& operator[](int index);
void insert(ElementType el);
void change(ElementType rate, int index);
~Rating();
          
private:
void resize();
bool isFull();

static const int INITIALCAP = 100;
int size,
   count;
ElementType *arr;
};

#endif
