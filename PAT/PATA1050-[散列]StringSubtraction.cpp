/**
1050 String Subtraction (20)��20 �֣�
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
        ��һ����Եľ�����string�����������Ե������ ����Ϊʲô
    **/
    //char s1[100000], s2[100000];
    //cin.getline(s1, 100000);
    //cin.getline(s2, 100000);
    string str1,str2;
    getline(cin,str1);
    getline(cin,str2);
    bool hashTable[128];//Ĭ��ֵȫfalse����ʾstr2��ÿ���ַ��Ƿ���ֹ�����ʼ�����û���ֹ�
    int len1 = str1.length();
    int len2 = str2.length();
    //int len1 = strlen(str1);
    //int len2 = strlen(str2);
    for(int i=0;i<len2;i++){
        hashTable[str2[i]] = true;//���ֹ��ĸ�Ϊtrue
    }

    for(int i=0;i<len1;i++){
        if(hashTable[str1[i]]==false){
            cout<<str1[i];
        }
    }
    return 0;
}
