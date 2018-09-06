#include<iostream>
using namespace std;
int main(){
	int n,m,num;
	cin>>n>>m>>num;
	int male[n],female[m];
	for(int i=0;i<n;i++){
		male[i] = i+1;
	}
	for(int i=0;i<m;i++){
		female[i] = i+1;
	}
	int toM=0,toF=0;
	while(num--){
		cout<<male[toM]<<" "<<female[toF]<<endl;
		toM = (toM+1)%n;
		toF = (toF+1)%m;
	}
	return 0;
} 
