//Shrestha, Shiva
//lab4.cpp
//Date: 5/13/20
//
//Description: THis program creates a priority queue as a heap.
#include <iostream>
#include<stdlib.h>
#include<ctime>

using namespace std;

int heapSize = 0;

void insertElement(int heap[],int newValue);

void heapify(int heap[], int index);

int deleteElement(int heap[]);

void printHeap(int heap[]);

int main(){

	static int heap[20];
	srand(time(0));
	
	for(int i = 0 ; i <12 ; i++){
		int newVal = rand()%1000 +1;
		insertElement(heap, newVal);
	}
	int input =0;
	int deleted;
	
	while(input < heapSize){
		cout << "\nEnter a positive Number: ";
		cin >> input;
		while(input > heapSize){
			cout <<"\nThe input is bigger than the heapSize ("<<heapSize<<")";
			cout<< "\nPlease re-enter a number: ";
			cin >> input;
		}
		for(int i =0; i < input ; i++){
			deleted = deleteElement(heap);
		}
		cout<< "\n#" << input << "biggest value in the heap is: " << deleted;
		if(heapSize ==0){
			cout << "\nThe heap is empty now. Goodbye!\n"<<endl;
			break;
		}
		else{
			printHeap(heap);
		}
		input = 0;
	}
	return 0;
}

void insertElement(int heap[],int newValue){

	heapSize = heapSize + 1;
 	int i = heapSize-1;

	if(heapSize >20){
		cout<< "\nArray Overflow, cannot insert into heap\n";
	}

	heap[i] = newValue;

	while (i != 0 && heap[(i-1)/2] < heap[i]){
		int t = heap[i];
		heap[i]= heap[(i-1)/2];
		heap[(i-1)/2] = t;
		i = (i-1)/2;
	}
}
void heapify(int heap[], int index){

	int i = index;
	int left = 2*i+1;
	int right = 2*i+2;
	int largest = i;
	
	if(left < heapSize && heap[left] > heap[i] ){
		largest = left;
	}		
	if(right < heapSize && heap[right] > heap[largest] ){
		largest = right;
	}	
	if(largest != i){
		int t = heap[i];
		heap[i] = heap[largest];
		heap[largest] = t;
		heapify(heap, largest);
	}
}
int deleteElement(int heap[]){
	
	if(heapSize < 1){
		cout << "\nHeap empty\n";
		return -1;			
	}
	else if (heapSize ==1){
		heapSize = heapSize -1;
		return heap[0];
	}
	else {
		int max_value = heap[0];
		heap[0] = heap[heapSize-1];
		heapSize = heapSize-1;
		heapify(heap,0);
		return max_value;
	}
}

void printHeap(int heap[]){
	
	cout<<"\nThe remaining heap is: \n";
	
	for(int i = 0; i< heapSize; i++){
	
		cout << i+1 << ": " << heap[i]<<endl;
	}	

}


