
Book.h

#include <string>

#ifndef BOOK_H
#define BOOK_H
using namespace std;

class Book
{
public:
Book(string name = "unknown", string author = "unknown",
       string iSBN = "unknown", int year = 0);
Book(const Book &rhs);
Book& operator=(const Book &rhs);
void updateName(string _name);
//Pre: must be a string
//Post: none
void updateAuthor(string _author);
//Pre: must be a string
//Post: none
void updateISBN (string _iSBN);
//Pre: must be a string
//Post: none
void updateYear (int _year);
//Pre: must be a string
//Post: none
string getName()const;
//Pre: none
//Post: reture a string of author and book's name
string getBookName()const;
//Pre: none
//Post: none
string getAuthorName()const;
private:
string name,
   iSBN,
   author;
int year;
};
#endif
