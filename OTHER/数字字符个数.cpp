#include<iostream>
#include<string>
using namespace std;
int main(){
	string s;
	//��������cin�������пո� 
	getline(cin,s);
	int cnt = 0;
	int length = s.length();
	for(int i=0;i<length;i++){
		if(s[i]>='0'&&s[i]<='9'){
			cnt++;
		}
	}
	cout<<cnt<<endl;
	return 0;
} 
