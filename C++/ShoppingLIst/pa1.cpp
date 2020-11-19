//SHrestha, SHiva
//pa1.cpp
//4/24/20
//
//desecription: This program implements a queue ADT for storing a list of shopping items. It uses dynamic ciruclar 
//	array. 
//
#include "shopping.h"
#include <iostream>
#include<fstream>//to read file
#include<sstream>//to use stringstream
using namespace std;

int main(){
	ShoppingList s;
	ifstream inFile;
	//cout<<s.i.itemName;
	string a,b,c, line;
	
	inFile.open("items.txt");
	if(!inFile){
		cout << "unable to open file."<<endl;
		exit(1);
	}
	while (getline(inFile,line)){
	stringstream ss(line);
	getline(ss, a, ',');
	getline(ss, b, ',');
	stringstream geek(b);
	float x;
	geek >> x;
	getline(ss, c, ',');
	s.enqueue(a, x, c);
	
	}
	inFile.close();

	cout<< "Printing list: \n";

	s.printList();	
	
	s.dequeue();
	cout<< "Printing list: \n";
	s.printList();

	cout<<"Price of banana is :  " <<s.getPrice("banana")<<endl;
	
	ShoppingList s2 = ShoppingList();
	s.createList(s2, "home");

	s2.printList();
	s.~ShoppingList();	
}
