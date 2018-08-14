/**
1042 字符统计（20 分）
请编写程序，找出一段给定文字中出现最频繁的那个英文字母。

输入格式：
输入在一行中给出一个长度不超过 1000 的字符串。字符串由 ASCII 码表中任意可见字符及空格组成，至少包含 1 个英文字母，以回车结束（回车不算在内）。

输出格式：
在一行中输出出现频率最高的那个英文字母及其出现次数，其间以空格分隔。如果有并列，则输出按字母序最小的那个字母。统计时不区分大小写，输出小写字母。

输入样例：
This is a simple TEST.  There ARE numbers and other symbols 1&2&3...........
输出样例：
e 7
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){

    string str;
    //输入包含空格所以不可以用cin！！要用getline
    getline(cin,str);
    //只要统计英文字母所以hashTable长度>26+1即可
    int hashTable[30] = {0};
    int length = str.length();
    for(int i=0;i<length;i++){
        if(str[i]>='a'&&str[i]<='z'){
            hashTable[str[i]-'a'] ++;
        }else if(str[i]>='A'&&str[i]<='Z'){
            hashTable[str[i]-'A'] ++;
        }
    }

    int position=0;
    for(int i=0;i<30;i++){
        if(hashTable[i]>hashTable[position]){
            position = i;
        }
    }

    //printf("%c",position+'a');
    cout<<(char)(position+'a')<<" "<<hashTable[position]<<endl;

    return 0;
}

