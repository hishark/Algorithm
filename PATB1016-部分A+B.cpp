/**
1016 部分A+B (15)（15 分）
正整数A的“DA（为1位整数）部分”定义为由A中所有DA组成的新整数PA。例如：给定A = 3862767，DA = 6，则A的“6部分”PA是66，因为A中有2个6。

现给定A、DA、B、DB，请编写程序计算PA + PB。

输入格式：

输入在一行中依次给出A、DA、B、DB，中间以空格分隔，其中0 < A, B < 10^10。

输出格式：

在一行中输出PA + PB的值。

输入样例1：

3862767 6 13530293 3
输出样例1：

399
输入样例2：

3862767 1 13530293 8
输出样例2：

0
**/
#include<stdio.h>
#include<iostream>
using namespace std;
int main(){
    /**
        10^9范围内的整数可以定义为int
        依照题意，10^10明显超过int范围，要定义为long long!
    **/
    long long A,DA,B,DB;
    long long PA = 0, PB = 0;
    cin>>A>>DA>>B>>DB;
    while(A!=0){
        if(A%10==DA){
            PA = PA*10 + DA;
        }
        A = A/10;
    }
    while(B!=0){
        if(B%10==DB){
            PB = PB*10 + DB;
        }
        B = B/10;
    }
    cout<<PA+PB<<endl;
    return 0;
}
