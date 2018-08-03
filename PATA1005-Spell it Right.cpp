/**
1005 Spell It Right (20)£¨20 ·Ö£©
Given a non-negative integer N, your task is to compute the sum of all the digits of N, and output every digit of the sum in English.

Input Specification:

Each input file contains one test case. Each case occupies one line which contains an N (<= 10^100^).

Output Specification:

For each test case, output in one line the digits of the sum in English words. There must be one space between two consecutive words, but no extra space at the end of a line.

Sample Input:

12345
Sample Output:

one five
**/
#include<stdio.h>
#include<iostream>
#include<cstring>
using namespace std;
string change[10]={"zero","one","two","three","four","five","six","seven","eight","nine"};
void dfs(int n){
    if(n/10==0){
        cout<<change[n%10];
        return;
    }
    dfs(n/10);
    cout<<" "<<change[n%10];
}
int main(){
    string str;

    cin>>str;
    int sum = 0;
    int length = str.size();
    for(int i=0;i<length;i++){
        int temp = str[i] - '0';
        sum+=temp;
    }
    dfs(sum);

    return 0;
}
