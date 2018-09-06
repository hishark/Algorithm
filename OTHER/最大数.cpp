#include<iostream>
#include<algorithm>
using namespace std;
int main(){
	int n;
	cin>>n;
	int max = -1000000010;
	for(int i=0;i<n;i++){
		int input;
		cin>>input;
		if(input>max)
			max = input;
	}
	cout<<max<<endl;
	return 0;
}
 
