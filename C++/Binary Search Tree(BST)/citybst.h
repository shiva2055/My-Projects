//Shrestha, Shiva
//citybst.h
//5/15/20
//description: This is a header filer for citybst class. All the datamemebers, class declaration, and function prototypes are in this file. This class implements a BST using linked representation with a string as a key
//
//
#ifndef CITYBST_H
#define CITYBST_H

#include<iostream>

using namespace std;
struct TreeNode{
		string key;
		string country;	
		int population;	
		TreeNode* left;
		TreeNode* right;
	};

class CityBST{
public:
	CityBST();
	~CityBST();
	CityBST(const CityBST& city);
	const CityBST& operator=(const CityBST& city);
	bool contains(string cityName);
	void insert(string cityName, string country, int population);
	bool remove(string cityName);
	int getHeight();
	void print();
	void printCity(string cityName);
	string biggestCity();
private:
/*	struct TreeNode{
		string key;
		string country;	
		int population;	
		TreeNode* left;
		TreeNode* right;
	};*/
	TreeNode *root;
	void DestoryBST(TreeNode* root);
	void copy(TreeNode *root);
	void chop(TreeNode *node);
	void insertHelper(TreeNode* &root, string cityName,string c, int pop );
	TreeNode* findMax(TreeNode* node);
	TreeNode* findMin(TreeNode*node);
	bool removeHelper(TreeNode*& n , string cityName);
	bool containsHelper(TreeNode* node, string cityName);
	void inorder(TreeNode* node);
	int height(TreeNode* node);
	void printCity_helper(TreeNode* node, string cityName);
};










#endif 
