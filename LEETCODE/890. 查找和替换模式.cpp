#include<map>
#include<vector>
#include<iostream>
using namespace std;

class Solution {
	public:
		bool isPattern(string word,string pattern) {
			int wordLen = word.length();
			int patternLen = pattern.length();

			//������ȶ�����ȣ�һ��ģʽ��ƥ�䣬ֱ�ӷ���false
			if(wordLen!=patternLen) {
				return false;
			}

			map<char,char> map1,map2;

			

			//�ȱ���word
			for(int i=0; i<wordLen; i++) {
				//�����map1���ҵ���word��i���ַ�
				if(map1.find(word[i])!=map1.end()) {
					//�ж��ҵ�������ַ��Ƿ�ģʽƥ��
					if(map1[word[i]]!=pattern[i]) {
						return false;
					}
				} else { //û�ҵ���i���ַ� ���ͼ���map1
					map1[word[i]] = pattern[i];
				}
			}

			//�ٱ���pattern
			for(int i=0; i<patternLen; i++) {
				//�����map2���ҵ���pattern��i���ַ�
				if(map2.find(pattern[i])!=map2.end()) {
					//�ж��ҵ�������ַ��Ƿ�ģʽƥ��
					if(map2[pattern[i]]!=word[i]) {
						return false;
					}
				} else {
					map2[pattern[i]] = word[i];
				}
			}

			//��������һ��
			return true;
		}

		vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
			vector<string> ans;
			int length = words.size();
			for(int i=0; i<length; i++) {
				if(isPattern(words[i],pattern)) {
					ans.push_back(words[i]);
				}
			}
			return ans;
		}
};
int main() {
	vector<string> words,ans;
	words.push_back("abc");
	words.push_back("deq");
	words.push_back("mee");
	words.push_back("aqq");
	words.push_back("dkd");
	words.push_back("ccc");

	string pattern = "abb";

	Solution solution;
	ans = solution.findAndReplacePattern(words,pattern);
	int length = ans.size();
	for(int i=0; i<length; i++) {
		cout<<ans[i]<<" ";
	}
	cout<<endl;
	return 0;
}
