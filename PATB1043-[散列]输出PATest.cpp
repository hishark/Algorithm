/**
1043 输出PATest（20 分）
给定一个长度不超过 10^4的、仅由英文字母构成的字符串。请将字符重新调整顺序，按 PATestPATest.... 这样的顺序输出，并忽略其它字符。当然，六种字符的个数不一定是一样多的，若某种字符已经输出完，则余下的字符仍按 PATest 的顺序打印，直到所有字符都被输出。

输入格式：
输入在一行中给出一个长度不超过 10^4的、仅由英文字母构成的非空字符串。

输出格式：
在一行中按题目要求输出排序后的字符串。题目保证输出非空。

输入样例：
redlesPayBestPATTopTeePHPereatitAPPT
输出样例：
PATestPATestPTetPTePePee
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){
    string str;
    cin>>str;
    int length = str.length();
    int hashTable[6]={0};
    char dict[6]={'P','A','T','e','s','t'};
    int sum = 0;

    //初始化hashTable
    for(int i=0;i<length;i++){
        //将字符串里的每一个字符，都对dict里的字符进行遍历比对,以统计字符数
        for(int j=0;j<6;j++){
            if(str[i]==dict[j]){
                hashTable[j]++;
                sum++;
                break;
            }
        }
    }

    //只要sum不为0就一直循环输出
    while(sum!=0){
        for(int i=0;i<6;i++){
            if(hashTable[i]!=0){
                cout<<dict[i];
                hashTable[i]--;
                sum--;
            }
        }
    }
    return 0;
}
