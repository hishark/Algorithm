#include<iostream>
#include<algorithm>
using namespace std;
/**
1. ������ 
2. ����������������Ĳ�ֵ����Сֵ 
**/ 
int main(){
	int n;
	cin>>n;
	int a[n];
	for(int i=0;i<n;i++){
		cin>>a[i];
	}
	sort(a,a+n);
	int min = 10000000010;
	for(int i=0;i<n-1;i++){
		if(abs(a[i]-a[i+1])<min){
			min = abs(a[i]-a[i+1]);
		}
	} 
	cout<<min<<endl;
	return 0;
} 
