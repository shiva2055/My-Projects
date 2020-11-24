#ifndef BOOKLIST_H
#define BOOKLIST_H
using namespace std;

class BookList
{
public:
typedef Book ElementType;
BookList(int initialCap = INITIALCAP);
BookList(const BookList &rhs);
BookList& operator=(const BookList &rhs);
ElementType& operator[](int index);
int insert(ElementType el);
int getCount()const;
~BookList();
private:
void resize();
bool isFull();

static const int INITIALCAP = 50;
int size,
   count;
ElementType *arr;
};

#endif
