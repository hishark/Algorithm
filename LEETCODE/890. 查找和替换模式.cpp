#include<map>
#include<vector>
#include<iostream>
using namespace std;

class Solution {
	public:
		bool isPattern(string word,string pattern) {
			int wordLen = word.length();
			int patternLen = pattern.length();

			//如果长度都不相等，一定模式不匹配，直接返回false
			if(wordLen!=patternLen) {
				return false;
			}

			map<char,char> map1,map2;

			

			//先遍历word
			for(int i=0; i<wordLen; i++) {
				//如果在map1中找到了word第i个字符
				if(map1.find(word[i])!=map1.end()) {
					//判断找到的这个字符是否模式匹配
					if(map1[word[i]]!=pattern[i]) {
						return false;
					}
				} else { //没找到第i个字符 ，就加入map1
					map1[word[i]] = pattern[i];
				}
			}

			//再遍历pattern
			for(int i=0; i<patternLen; i++) {
				//如果在map2中找到了pattern第i个字符
				if(map2.find(pattern[i])!=map2.end()) {
					//判断找到的这个字符是否模式匹配
					if(map2[pattern[i]]!=word[i]) {
						return false;
					}
				} else {
					map2[pattern[i]] = word[i];
				}
			}

			//最后别忘了一句
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
