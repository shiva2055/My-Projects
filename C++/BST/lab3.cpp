//Shrestha, Shiva
//lab3.cpp
//5/5/20
//
//Description: This maile contains the main function. This program creates a binary search tree based on your input
//		It inserts unique key to BST, prints value between the range k and k^2 uisng inorder treversal, 
//		prints sum of all keys, deletes the tree and also prints the parent-child nodes where there 			    difference is less than input value using preorder treversal.
//
//
//Asssumption: none
#include<iostream>
//#include <string>
#include <cmath>

using namespace std;

typedef float treeElement;

struct TreeNode{
	treeElement key;
	TreeNode* left;
	TreeNode* right;
};

//prtotype of the functions
bool insert(TreeNode *&root, treeElement value);

treeElement sumAll(TreeNode *node);

void inOrder(TreeNode *node, treeElement val);

void deleteTree(TreeNode* &node );

void  printParentChild(TreeNode *node, treeElement value);



int main(){

	string input_string;
	TreeNode *rootNode = nullptr;
	int length = 0;
	treeElement input_value;
	
	cout<< "How many keys do you want to add to the BST?"<<endl;
	cin >> length;
	
	for(int i =0 ; i <length ; i ++){
		cout <<"Enter the key you want to insert: ";
		cin >> input_value;

		if(!insert(rootNode, input_value)){
			cout << "This value is already stored in the tree:  " << input_value <<
			"        try another value\n";
			i--;
		}
	}

	cout << "\n\nEnter the key for the range: ";
	cin >> input_value;
	cout<<"\nValues in the range are: \n";
	inOrder(rootNode, input_value);
	
	cout << "\nThe sum of all the Nodes: " << sumAll(rootNode) << "\n\n";
	
	cout<< "Extra Credit:\n";
	int number;
	cout<< "Enter a number to pair less than: ";
	cin >>number;
	cout << "\nPrint pairs less than: " << number<<endl;
	printParentChild(rootNode,number);


	deleteTree(rootNode);
		
	if(rootNode == nullptr){
		cout << "The tree is empty now after deleteTree() funtion.\n\n GOODBYE!!!!!!!!!!!!\n\n";
	}


}
//inserts as many unique key as user wants 
bool insert(TreeNode *&root, treeElement value){
	
	TreeNode* node = new TreeNode();
	node->key = value;
	
	if(root == nullptr){
		root = node;
		return true;
	}
	TreeNode* temp = root;
	while(1>0){
		if(temp->key > node->key){
			if(temp->left == nullptr){
				temp->left = node;
				return true;
			}
			else
				temp = temp->left;
		}
		else if(temp->key < node->key){
			if(temp->right == nullptr){
				temp->right = node;
				return true;
			}
			else
				temp = temp->right;

		}
		else{
			delete node;
			return false;
		}
	}
}
//treverses the tree using post order
//gets the sum of left sub tree and right sub tree and returns total sum
treeElement sumAll(TreeNode *node){
	treeElement totalSum;	

	if(node == nullptr)
		return 0;

	treeElement leftSum = sumAll(node->left);
	treeElement rightSum = sumAll(node->right);
	
	totalSum = leftSum+ rightSum + node->key;
	return (totalSum);
}
//trverses using inorder and prints values if they fall within range of value and value *value
void inOrder(TreeNode *node, treeElement value){
	
	if(node != nullptr){
		if(node->key > value)
			inOrder(node->left, value);
		if((node->key > value) & (node ->key < (value *value)))
			cout<<node->key << "\n";

		if(node->key < value*value)
			inOrder(node->right, value);

	}
}
//treverses in post order treverse ; deletes all child nodes and then delete the parent node and then parent
//node is assigned to nullptr
void deleteTree(TreeNode * &node){
	
	if(node == nullptr){
		return;
	}

	deleteTree(node->left);
	node->left = nullptr;
	deleteTree(node->right);
	node->right = nullptr;
	cout << "Deleting: " << node->key <<"\n";
	delete(node);
	node = nullptr;
}
//trverses in preorder and prints all pairs of parent-child nodes where their difference is less than value
void printParentChild(TreeNode *node, treeElement value){

	if(node == nullptr)
		return;
	
	if(node->left != nullptr){
		if(abs(node->key - node->left->key) < value){
			cout << node->key <<"-"<< node->left->key<<endl;
		}
		printParentChild(node->left, value);
	}
	if(node->right != nullptr){
		if(abs(node->key - node->right->key) < value){
			cout << node->key <<"-"<< node->right->key<<endl;
		}
		printParentChild(node->right, value);
	}
}





