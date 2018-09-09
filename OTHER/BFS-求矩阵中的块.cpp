/**
给出一个m*n的矩阵，矩阵中的元素为0或1。称位置(x,y)与其上下左右四个位置是相邻的。
如果矩阵中有若干个1是相邻的（不必两两相邻），那么称这些1构成了一个“块”。
求给定的矩阵中“块”的个数
0 1 1 1 0 0 1
0 0 1 0 0 0 0 
0 0 0 0 1 0 0
0 0 0 1 1 1 0
1 1 1 0 1 0 0
1 1 1 1 0 0 0
(n=7 m=6 最后结果ans=4)
**/
#include<iostream>
#include<queue>
using namespace std;
const int maxn = 100;

struct node{
	int x,y;//位置(x,y) 
}Node;//直接定义了一个Node为当前结点 

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
	if(matrix[x][y]==0||inq[x][y]==true){
		return false;
	} 
	//以上都不满足，返回true
	return true; 
}

//bfs函数
//访问位置(x,y)所在的块，将该块中所有“1”的inq都设置为true
void bfs(int x,int y){
	queue<node> Q;//定义队列
	Node.x = x,Node.y = y; //当前结点的坐标
	Q.push(Node);//将结点Node入队
	inq[x][y] = true;//设置(x,y)已入队 
	while(!Q.empty()) {
		node top = Q.front();//取出队首元素
		Q.pop();//队首元素出队
		for(int i=0;i<4;i++){//循环四次，得到四个相邻位置 
			int newX = top.x + X[i];
			int newY = top.y + Y[i];
			if(judge(newX,newY)){//如果新位置(newX,newY)需要访问 
				//设置Node的坐标为(newX,newY)
				Node.x = newX;
				Node.y = newY;
				Q.push(Node);//将结点Node加入队列 
				inq[newX][newY] = true;//设置位置(newX,newY)已入过队 
			}
		} 
	}
}

int main(){
	cin>>n>>m;
	for(int x=0;x<n;x++){
		for(int y=0;y<m;y++){
			cin>>matrix[x][y];//读入01矩阵 
		}
	}
	
	int ans = 0;//存放块数 
	//枚举每一个位置 
	for(int x=0;x<n;x++){
		for(int y=0;y<m;y++){
			//如果元素为1，且未入过队
			if(matrix[x][y]==1 && inq[x][y]==false){
				ans++;//块数加一
				bfs(x,y);//访问整个块，将该块所有“1”的inq都标记为true 
			} 
		}
	} 
	cout<<ans<<endl;
	return 0; 
} 





