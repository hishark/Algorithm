#include<algorithm>
#include<cstdio>
#include<iostream>
using namespace std;
int main(){
	int n,m;
	cin>>n>>m;
	int ans = 0;
	for(int i=0;i<n;i++){
		int max = -1;
		for(int j=0;j<m;j++){
			int input;
			cin>>input;
			if(input>max){
				max = input;
			}
		}
		ans+=max;
	} 
	cout<<ans<<endl;
	return 0;
} 
