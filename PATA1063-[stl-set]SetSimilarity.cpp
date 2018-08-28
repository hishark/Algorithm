/**1063 Set Similarity（25 分）

Sample Input:
3
3 99 87 101
4 87 101 5 87
7 99 101 18 5 135 18 99
2
1 2
1 3
Sample Output:
50.0%
33.3%
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
#include<math.h>
#include<set>
using namespace std;
const int maxn = 51;
set<int> st[maxn];
//比较编号为a的集合和编号为b的集合，求解
void compare(int a,int b) {
	int totalNum = st[b].size();
	int sameNum = 0;
	for(set<int>::iterator it = st[a].begin(); it!=st[a].end(); it++) {
		//如果在st[b]中找到了当前的值，那么same+1
		//st.find(value)!=st.end()为true就表示在st中找到了value
		if(st[b].find(*it)!=st[b].end()) {
			sameNum++;
		} else {
			totalNum++;
		}
	}
	printf("%.1f%%\n",sameNum*100.0/totalNum);
}
int main() {
	int n;
	cin>>n;
	for(int i=1; i<=n; i++) {
		int num;
		cin>>num;
		for(int j=0; j<num; j++) {
			int input;
			cin>>input;
			st[i].insert(input);
		}
	}

	int searchNum;
	cin>>searchNum;
	for(int i=0; i<searchNum; i++) {
		int a,b;
		cin>>a>>b;
		compare(a,b);
	}
	return 0;
}



