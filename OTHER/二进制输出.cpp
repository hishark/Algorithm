#include<iostream>
#include<vector>
using namespace std;
int main(){
	int n;
	cin>>n;
	vector<int> ans;
	int count = 8;
	while(count--){
		ans.push_back(n%2);
		n/=2;
	}
	for(int i=7;i>=0;i--){
		cout<<ans[i];
	}
	cout<<endl;
	return 0;
}
