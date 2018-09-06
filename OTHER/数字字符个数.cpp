#include<iostream>
#include<string>
using namespace std;
int main(){
	string s;
	//不可以用cin，输入有空格 
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
