/**
1071 Speech Patterns��25 �֣�
People often have a preference among synonyms of the same word. For example, some may prefer "the police", while others may prefer "the cops". Analyzing such patterns can help to narrow down a speaker's identity, which is useful when validating, for example, whether it's still the same person behind an online avatar.

Now given a paragraph of text sampled from someone's speech, can you find the person's most commonly used word?

Input Specification:
Each input file contains one test case. For each case, there is one line of text no more than 1048576 characters in length, terminated by a carriage return \n. The input contains at least one alphanumerical character, i.e., one character from the set [0-9 A-Z a-z].

Output Specification:
For each test case, print in one line the most commonly occurring word in the input text, followed by a space and the number of times it has occurred in the input. If there are more than one such words, print the lexicographically smallest one. The word should be printed in all lower case. Here a "word" is defined as a continuous sequence of alphanumerical characters separated by non-alphanumerical characters or the line beginning/end.

Note that words are case insensitive.

Sample Input:
Can1: "Can a can can a can?  It can!"
Sample Output:
can 5
**/
#include<iostream>
#include<string>
#include<map>
using namespace std;
map<string,int> mp;
bool check(char ch) {
	if(ch>='0'&&ch<='9') {
		return true;
	}
	if(ch>='a'&&ch<='z') {
		return true;
	}
	if(ch>='A'&&ch<='Z') {
		return true;
	}
	return false;
}
int main() {
	string str;
	getline(cin,str);
	int length = str.size();
	int i=0;
	while(i<length) {
		//һ������һ�����ʵ��������
		string ans="";
		while(i<length&&check(str[i])==true) {
			//��ǰ�ַ�����Ч�ַ�
			//����Ǵ�д��ĸ����ת��ΪСд��ĸ
			if(str[i]>='A'&&str[i]<='Z') {
				str[i]+=32;
			}

			//�ѵ�ǰ�ַ����뵽ans�� 
			ans += str[i];
			//���������� 
			i++; 
		}
		
		//���ans���ǿ��ַ�������ô�ͱ�ʾ�ɹ������һ�����ʣ���������ʵĴ�����һ
		if(ans!=""){
			//���map���Ѵ��ڣ���ֱ�Ӽ�һ
			if(mp.find(ans)!=mp.end()){
				mp[ans]++;
			}else{
				mp[ans] = 1;
			}
		} 
		
		//������Ч�ַ�
		if(i<length && check(str[i])==false) {
			i++;
		}

	}
	//��ʼ���������ֵ
	string key;
	int maxNum = 0;
	for(map<string,int>::iterator it = mp.begin();it!=mp.end();it++){
		if(it->second > maxNum){
			key = it->first;
			maxNum = it->second;
		}
	} 
	cout<<key<<" "<<maxNum<<endl;
	return 0;
}
