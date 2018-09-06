/**
1052 Linked List Sorting（25 分）
A linked list consists of a series of structures, which are not necessarily adjacent in memory. We assume that each structure contains an integer key and a Next pointer to the next structure. Now given a linked list, you are supposed to sort the structures according to their key values in increasing order.

Input Specification:
Each input file contains one test case. For each case, the first line contains a positive N (<10
?5
?? ) and an address of the head node, where N is the total number of nodes in memory and the address of a node is a 5-digit positive integer. NULL is represented by ?1.

Then N lines follow, each describes a node in the format:

Address Key Next
where Address is the address of the node in memory, Key is an integer in [?10
?5
?? ,10
?5
?? ], and Next is the address of the next node. It is guaranteed that all the keys are distinct and there is no cycle in the linked list starting from the head node.

Output Specification:
For each test case, the output format is the same as that of the input, where N is the total number of nodes in the list and all the nodes must be sorted order.

Sample Input:
5 00001
11111 100 -1
00001 0 22222
33333 100000 11111
12345 -1 33333
22222 1000 12345
Sample Output:
5 12345
12345 -1 00001
00001 0 11111
11111 100 22222
22222 1000 33333
33333 100000 -1
**/
#include<cstdio>
#include<iostream>
#include<algorithm>
using namespace std;
const int maxn = 100010;
struct Node{
	int address,key,next;
	bool flag;
}node[maxn];

bool cmp(Node a,Node b){
	if(a.flag==false||b.flag==false){
		return a.flag > b.flag;//无效结点都往后排 
	}else{
		//两个结点都有效就从小到大排 
		return a.key < b.key;
	}
}
int main(){
	int n,begin;
	for(int i=0;i<maxn;i++){
		node[i].flag = false;
	}
	cin>>n>>begin;
	int add,key,next;
	for(int i=0;i<n;i++){
		cin>>add>>key>>next;
		node[add].address = add;
		node[add].key = key;
		node[add].next = next;
	}
	int count = 0;//统计有效结点的个数，方便之后输出 
	for(int i=begin;i!=-1;i = node[i].next){
		node[i].flag = true;
		count++; 
	}
	//按照排序规则进行排序 
	sort(node,node+maxn,cmp);
	
	if(count==0){
		cout<<"0 -1"<<endl;
		return 0;
	} 
	
	//输出
	printf("%d %05d\n",count,node[0].address);
	
	for(int i=0;i<count;i++){
		if(i!=count-1){
			//第三个参数注意别写成next了，已经排好序了所以直接输出下一个结点的address即可 
			printf("%05d %d %05d\n",node[i].address,node[i].key,node[i+1].address);
		}else{
			printf("%05d %d -1\n",node[i].address,node[i].key);
		}
	}
    return 0;
}

