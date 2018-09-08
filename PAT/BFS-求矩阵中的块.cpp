/**
给出一个m*n的矩阵，矩阵中的元素为0或1。称位置(x,y)与其上下左右四个位置是相邻的。
如果矩阵中有若干个1是相邻的（不必两两相邻），那么称这些1构成了一个“块”。
求给定的矩阵中“块”的个数
0 1 1 1 0 0 1
0 0 1 0 0 0 0 
0 0 0 0 1 0 1
**/
#include<iostream>
#include<queue>
using namespace std;
const int maxn = 100;

struct node{
	int x,y;//位置(x,y) 
}Node; 

int n,m;//矩阵大小为n*m
int matrix[maxn][maxn];//01矩阵
bool inq[maxn][maxn] = {false};//记录位置(x,y)是否已入过队
int X[4] = {0,0,1,-1};//增量数组 
int Y[4] = {1,-1,0,0};

bool judge(int x,int y){//判断坐标(x,y)是否需要访问 
	//越界返回false
	if(x>=n||x<0||y>=m||y<0){
		return false;
	} 
	//当前位置为0，或(x,y)已入过队，返回false 
}

int main(){ 
	
} 
