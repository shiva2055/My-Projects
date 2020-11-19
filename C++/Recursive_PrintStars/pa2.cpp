//shrestha, shiva
//pa2.cpp
//5/4/20
//
//description: THis is the testing file of the class. THis class implements a stach ADT using a singly linked list. It also has some fucntions to do  the recursive insert in stack and recursive printing of the stars.
//
 
//
#include "recursiveStack.h"
#include <iostream>

using namespace std;

int main(){
	RecursiveStack r;

	int number;
	cout<< "Please, Enter a postive whole number..."<<endl;
	cin >> number;
	
	r.recInsert(number);
	cout<< "Printing the stack:\n";
	r.print();
	
	cout<<"Printing the Star:\n";
	r.printStars();
	
	cout<<"Top: "<< r.getTop()<<endl;
		
	r.push(0);
	cout<< "Printing the stack after pushing 0:\n";
	r.print();

	r.pop();
	cout<<"Printing the stack after pop:\n";
	r.print();
	
	cout<< "IS Empty: "<< r.isEmpty()<<endl;

	r.~RecursiveStack();
	
	cout<<"Printing the Stack after destructor function is called:\n";
	r.print();
	
	
}
