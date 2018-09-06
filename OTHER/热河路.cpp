#include<string>
#include<sstream>
#include<cstdio>
using namespace std;
string intToString(int x){
	stringstream ss;
	string s;
	ss<<x;
	ss>>s;
	return s;
}

int main(){
	int n;
	scanf("%d",&n);
	while(n--){
		int input;
		scanf("%d",&input);
		int ans = 0;
		int i;
		for(i=1;;i++){
			ans+=i;
			if(ans>=input){
				break;
			}
		}
		string result="1";
		int base = 1;
		int count = i;
		int temp;
		int times = 10;
		for(int j=1;j<count;j++){
			temp = base * times;
			string s = intToString(temp);
			result +=s;
			times*=10;
		}
		printf("%c\n",result[input-1]);
	}
	return 0;
}

