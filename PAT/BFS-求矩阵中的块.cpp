/**
����һ��m*n�ľ��󣬾����е�Ԫ��Ϊ0��1����λ��(x,y)�������������ĸ�λ�������ڵġ�
��������������ɸ�1�����ڵģ������������ڣ�����ô����Щ1������һ�����顱��
������ľ����С��顱�ĸ���
0 1 1 1 0 0 1
0 0 1 0 0 0 0 
0 0 0 0 1 0 1
**/
#include<iostream>
#include<queue>
using namespace std;
const int maxn = 100;

struct node{
	int x,y;//λ��(x,y) 
}Node; 

int n,m;//�����СΪn*m
int matrix[maxn][maxn];//01����
bool inq[maxn][maxn] = {false};//��¼λ��(x,y)�Ƿ��������
int X[4] = {0,0,1,-1};//�������� 
int Y[4] = {1,-1,0,0};

bool judge(int x,int y){//�ж�����(x,y)�Ƿ���Ҫ���� 
	//Խ�緵��false
	if(x>=n||x<0||y>=m||y<0){
		return false;
	} 
	//��ǰλ��Ϊ0����(x,y)������ӣ�����false 
}

int main(){ 
	
} 
