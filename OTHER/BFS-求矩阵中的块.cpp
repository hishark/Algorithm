/**
����һ��m*n�ľ��󣬾����е�Ԫ��Ϊ0��1����λ��(x,y)�������������ĸ�λ�������ڵġ�
��������������ɸ�1�����ڵģ������������ڣ�����ô����Щ1������һ�����顱��
������ľ����С��顱�ĸ���
0 1 1 1 0 0 1
0 0 1 0 0 0 0 
0 0 0 0 1 0 0
0 0 0 1 1 1 0
1 1 1 0 1 0 0
1 1 1 1 0 0 0
(n=7 m=6 �����ans=4)
**/
#include<iostream>
#include<queue>
using namespace std;
const int maxn = 100;

struct node{
	int x,y;//λ��(x,y) 
}Node;//ֱ�Ӷ�����һ��NodeΪ��ǰ��� 

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
	if(matrix[x][y]==0||inq[x][y]==true){
		return false;
	} 
	//���϶������㣬����true
	return true; 
}

//bfs����
//����λ��(x,y)���ڵĿ飬���ÿ������С�1����inq������Ϊtrue
void bfs(int x,int y){
	queue<node> Q;//�������
	Node.x = x,Node.y = y; //��ǰ��������
	Q.push(Node);//�����Node���
	inq[x][y] = true;//����(x,y)����� 
	while(!Q.empty()) {
		node top = Q.front();//ȡ������Ԫ��
		Q.pop();//����Ԫ�س���
		for(int i=0;i<4;i++){//ѭ���ĴΣ��õ��ĸ�����λ�� 
			int newX = top.x + X[i];
			int newY = top.y + Y[i];
			if(judge(newX,newY)){//�����λ��(newX,newY)��Ҫ���� 
				//����Node������Ϊ(newX,newY)
				Node.x = newX;
				Node.y = newY;
				Q.push(Node);//�����Node������� 
				inq[newX][newY] = true;//����λ��(newX,newY)������� 
			}
		} 
	}
}

int main(){
	cin>>n>>m;
	for(int x=0;x<n;x++){
		for(int y=0;y<m;y++){
			cin>>matrix[x][y];//����01���� 
		}
	}
	
	int ans = 0;//��ſ��� 
	//ö��ÿһ��λ�� 
	for(int x=0;x<n;x++){
		for(int y=0;y<m;y++){
			//���Ԫ��Ϊ1����δ�����
			if(matrix[x][y]==1 && inq[x][y]==false){
				ans++;//������һ
				bfs(x,y);//���������飬���ÿ����С�1����inq�����Ϊtrue 
			} 
		}
	} 
	cout<<ans<<endl;
	return 0; 
} 





