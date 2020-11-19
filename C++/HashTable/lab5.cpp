//Shrestha, Shiva
//5/27/20
//lab5.cpp
//
//Description: This program creates a hash table that stores the movie titles based on thier IMD id
#include<iostream>

using namespace std;

const int ARR_SIZE = 17;

class Movie{
private:
	string title;
	long id;
public:
	Movie(){
		title = "";
		id =0;
	}
	Movie(string str, long ID){
		title = str;
		id = ID;
	}
	string getTitle(){return title;}
	void setTitle(string str){title = str;}
	long getId(){return id;}
	void setId(long ID){id = ID;}
};

int hashFunc(long key);
bool insert(Movie playlist[], int hashKey, long key, string value );
/*
int hashFunc(long key){
	return(int)key%ARR_SIZE;
}
bool insert(Movie playlist[], int hashKey, long key, string value){
	if(playlist[hashKey].getTitle() == ""){
		playlist[hashKey] = Movie(value, key);
		return true;
	}
	return false;
}*/
int main(){
	string titleArr [] = {"Interstellar","Whiplash","Gone Girl",
	"The Wolf of Wall Street","Rush","Django Unchained","The Avengers",
	"Warrior","The Thing","Inception","Toy Story 3","How to Train Your Dragon",
	"3 Idiots","Inglourious Basterds","Up","Mary and Max","The Dark Knight",
	"Gran Torino","My Sassy Girl","Into the Wild","The Departed","The Prestige",
	"V for Vendetta","Eternal Sunshine of the Spotless Mind","Hotel Rwanda"};

	long idArr [] = {816692,2582802,2267998,993846,1979320,1853728,848228,
	1291584,905372,1375666,435761,892769,1187043,361748,1049413,978762,
	468569,1205489,404254,758758,407887,482571,434409,338013,395169};
	
	static Movie playlist[ARR_SIZE];
	int collision =0;
	
	for(int i = 0; i< 25; i++){
		int hashKey = hashFunc(idArr[i]);
		bool find = insert(playlist, hashKey, idArr[i], titleArr[i]);
		if(!find){
			cout << "collision at index:  " << hashKey << endl;
			++collision;
		}
	}
 	cout << "There was" << collision << "collisions.\n\n";
	for(int i =0; i <ARR_SIZE; i++){
		cout << "Playlist["<<i<<"]----------"<<endl;
		if(playlist[i].getTitle() != ""){
			cout << "Title: " << playlist[i].getTitle()<<endl;
			cout << "ID: " << playlist[i].getId() <<endl;
		}
		cout<< endl;
	}
	 return 0;
}	

int hashFunc(long key){
	return(int)key%ARR_SIZE;
}

bool insert(Movie playlist[], int hashKey, long key, string value){
	if(playlist[hashKey].getTitle() == ""){
		playlist[hashKey] = Movie(value, key);
		return true;
	}
	return false;
}
