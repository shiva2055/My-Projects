//Shrestha, Shiva
//citybst.cpp
//5/15/20
//Discription: This class implements a BST using a linked list representation with string as key.
//
#include "citybst.h"
#include<iostream>

using namespace std;

CityBST::CityBST(){
	root = nullptr;
//	root->key ="";
//	root->country="";
//	root->population = 0;
}
void CityBST::DestoryBST(TreeNode*  root){

	if(root != nullptr){
		if((root->left ==nullptr)&& (root->right == nullptr) ){
			delete root;
			root = nullptr;
		}
		DestoryBST(root->left);
		DestoryBST(root->right);
	//	delete root;
	}
}
CityBST::~CityBST(){
	
//	DestoryBST(root);
	chop(root);
}/*
void CityBST::copy(const TreeNOde *root){

	if(root != nullptr)
		insert(root->key, root->country, root->population);
	if(root->left != nullptr)
		copy(root->left);
	if(root->right != nullptr
		copy((root->right);		
}*/
void CityBST::copy(TreeNode *root){
	
	if(root){
		insert(root->key, root->country, root->population);
		copy(root->left);
		copy(root->right);	
	}

}
CityBST::CityBST(const CityBST& city){
	
	root = nullptr;
	copy(city.root);	
}
void CityBST::chop(TreeNode *node){
	
	if(node){
		chop(node->left);
		chop(node->right);
		delete node;
	}
}

const CityBST& CityBST::operator= (const CityBST& city){
	
	if(this != &city){
		chop(root);
		root = nullptr;
		copy(city.root);
	}	
	return *this;
}
bool CityBST::containsHelper(TreeNode* node, string cityName){

	if(node == nullptr)
		return false;
	else if(node->key == cityName)	
		return true;
	else if(node->key > cityName)
		return containsHelper(node->left, cityName);
	else
		return containsHelper(node->right, cityName);
}
bool CityBST::contains(string cityName){

	return containsHelper(root, cityName);	
}
void CityBST::insertHelper(TreeNode* & root, string cityName, string c, int pop){

	if(root == nullptr){
		root = new TreeNode;
		root->key = cityName;
		root->country = c;
		root->population = pop;
		root ->left = nullptr;
		root->right = nullptr;
	}
	else if(root->key > cityName)
		insertHelper(root->left, cityName,c, pop);
	else
		insertHelper(root->right,cityName,c, pop);
}
void CityBST::insert(string cityName, string country, int population){

	insertHelper(root, cityName, country, population);	
}
TreeNode* CityBST::findMax(TreeNode* node){

	if(node != nullptr)
		while(node->right != nullptr)
			node = node->right;
	return node;
}
TreeNode* CityBST::findMin(TreeNode* node){
	
	if(node == nullptr)
		return nullptr;
	if(node->left == nullptr)
		return node;
	return findMin(node->left);
}
bool CityBST::removeHelper(TreeNode*& n, string cityName){

	if(n == nullptr)
		return false;
	if(cityName < n->key)
		removeHelper(n->left, cityName);
	else if(cityName > n->key)
		removeHelper(n->right, cityName);
	else if(n ->left != nullptr && n->right != nullptr){
		n->key =findMin(n->right)->key;
		removeHelper(n->right, n->key);
	}
	else{
		TreeNode* oldNode = n;
		n = (n->left != nullptr) ? n->left: n->right;
		delete oldNode;
	}
	return true;	
}
 
bool CityBST::remove(string cityName){

	return removeHelper(root, cityName);	
}
int CityBST::height(TreeNode* node){

	if(node == nullptr)
		return 0;
	else{
		int height_left = height(node->left), height_right = height(node->right);
		if(height_left > height_right)
			return (height_left+1);
		else
			return (height_right +1);
	}
}
int CityBST:: getHeight(){

	return height(root);
}
void CityBST::inorder(TreeNode* node){
	
	if(node != nullptr){
		inorder(node->left);
		cout<< node->key << endl;
		inorder(node ->right);
	}
}
void CityBST:: print(){
	
	inorder(root);
}
void CityBST::printCity_helper(TreeNode* node, string cityName){
	
	if(node == nullptr){
		cout<< "Tree is empty\n";
		return;
	}
	else  if(node->key == cityName)	{	
		cout<<"City: " << node->key << endl;
		cout<< "Country: "<< node->country << endl;
		cout<< "Population: "<< node->population << endl;
	}
	else if(node->key > cityName)
		return printCity_helper(node->left, cityName);
	else
		return printCity_helper(node->right, cityName);

}
void CityBST::printCity(string cityName){

	printCity_helper(root, cityName);	
}
string CityBST:: biggestCity(){
	TreeNode* temp = findMax(root);
	return temp->key;
}






