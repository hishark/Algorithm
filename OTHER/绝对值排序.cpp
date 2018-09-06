#include<algorithm>
#include<iostream>
using namespace std;
bool cmp(int a,int b){
	if(abs(a)!=abs(b)){
		return abs(a) > abs(b);
	}else{
		return a < b;
	}
}
int main(){
	int n;
	cin>>n;
	int a[n];
	for(int i=0;i<n;i++){
		cin>>a[i];
	}
	sort(a,a+n,cmp);
	for(int i=0;i<n;i++){
		if(i==0){
			cout<<a[i];
		}else{
			cout<<","<<a[i];
		}
	}
	cout<<endl;
	return 0;
} 
