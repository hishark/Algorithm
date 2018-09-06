#include<algorithm>
#include<cstdio>
#include<iostream>
#include<sstream>
#include<math.h>
/**
|c++ string-int转换|用stringstream很快|
**/
using namespace std;
struct Node {
	int num;
	int digit[5];
} node[20];
bool cmp(Node a,Node b) {
	if(a.digit[0]!=b.digit[0]) {
		return a.digit[0] > b.digit[0];
	} else if(a.digit[1]!=b.digit[1]) {
		return a.digit[1] > b.digit[1];
	} else if(a.digit[2]!=b.digit[2]) {
		return a.digit[2] > b.digit[2];
	} else if(a.digit[3]!=b.digit[3]) {
		return a.digit[3] > b.digit[3];
	} else if(a.digit[4]!=b.digit[4]) {
		return a.digit[4] > b.digit[4];
	} else {
		return a.digit[4] >= b.digit[4];
	}
}

int main() {
	int n;
	cin>>n;
	for(int i=0; i<n; i++) {
		cin>>node[i].num;
		//求num的长度length
		stringstream ss;
		string s;
		ss<<node[i].num;
		ss>>s;
		int length = s.length();
		
		int num = node[i].num;
		int j = 0;
		while(length!=0) {
			node[i].digit[j] = num/pow(10,length-1);
			num=num%(int)pow(10,length-1);
			length--;
			j++;
		}
	}
	sort(node,node+n,cmp);
	for(int i=0;i<n;i++){
		cout<<node[i].num;
	}

	return 0;
}
