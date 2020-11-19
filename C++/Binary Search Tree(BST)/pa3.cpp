//Shrestha, Shiva
//pa3.cpp
//5/15/20
//Description: This class implements a bst uisng a linked list representation wiht string as a key.

#include"citybst.h"
#include<iostream>
#include<fstream>
#include<sstream>

using namespace std;

int main(){
	CityBST city;
	city.print();
	
	ifstream inFile;
	
	string a, x,cityName,country,pop, line;
	int population;
	
	inFile.open("cities.csv");
	if(!inFile){
		cout << "unable to open file" <<endl;
		exit(1);
	}
	getline(inFile,x );//skipping first line
	while(getline(inFile, line)){
	
		stringstream ss(line);
		getline(ss, cityName, ',');
		getline(ss, country, ',');
		getline(ss, pop,',' );
		stringstream geek(pop);
		geek >> population;
		city.insert(cityName, country, population);
		
	}
	cout<< "Hello!! Processing the cities.csv file.\n\n";
	cout<<"Tree Height:  " << city.getHeight()<<endl;	
	cout<< "Printing the tree:\n\n";
	city.print();
	
	cout<< "\nWhich city do you want to remove?";
	getline(cin,a);
	
	city.remove(a);
	cout<< "\n\nPrinting the tree:\n\n";
	city.print();
	
	cout<<"\n\nBiggest City is: "<< city.biggestCity()<<endl;	
	
	cout<< "\n\nWhich city do you want to print?";
	getline(cin, a);
	city.printCity(a); 
	
}
