/**
1050 String Subtraction (20)（20 分）
Given two strings S~1~ and S~2~, S = S~1~ - S~2~ is defined to be the remaining string after taking all the characters in S~2~ from S~1~. Your task is simply to calculate S~1~ - S~2~ for any given strings. However, it might not be that simple to do it fast.

Input Specification:

Each input file contains one test case. Each case consists of two lines which gives S~1~ and S~2~, respectively. The string lengths of both strings are no more than 10^4^. It is guaranteed that all the characters are visible ASCII codes and white space, and a new line character signals the end of a string.

Output Specification:

For each test case, print S~1~ - S~2~ in one line.

Sample Input:

They are students.
aeiou
Sample Output:

Thy r stdnts.
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){
    /**
        这一题很迷的就是用string会有两个测试点过不了 不懂为什么
    **/
    //char s1[100000], s2[100000];
    //cin.getline(s1, 100000);
    //cin.getline(s2, 100000);
    string str1,str2;
    getline(cin,str1);
    getline(cin,str2);
    bool hashTable[128];//默认值全false，表示str2的每个字符是否出现过，初始情况都没出现过
    int len1 = str1.length();
    int len2 = str2.length();
    //int len1 = strlen(str1);
    //int len2 = strlen(str2);
    for(int i=0;i<len2;i++){
        hashTable[str2[i]] = true;//出现过的改为true
    }

    for(int i=0;i<len1;i++){
        if(hashTable[str1[i]]==false){
            cout<<str1[i];
        }
    }
    return 0;
}
