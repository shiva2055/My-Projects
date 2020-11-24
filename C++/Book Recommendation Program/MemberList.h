#ifndef MEMBERLIST_H
#define MEMBERLIST_H
using namespace std;

class MemberList
{
public:
typedef Member ElementType;
MemberList(int initialCap = INITIALCAP);
MemberList(const MemberList &rhs);
MemberList& operator=(const MemberList &rhs);
ElementType& operator[](int index);
int insert(ElementType el);
int getCount()const;
~MemberList();
private:
void resize();
bool isFull();

static const int INITIALCAP = 50;
int size,
   count;
ElementType *arr;
};

#endif
