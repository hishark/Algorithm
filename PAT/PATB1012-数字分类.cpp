/**
1012 数字分类 (20)（20 分）
给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：

A1 = 能被5整除的数字中所有偶数的和；

A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；

A3 = 被5除后余2的数字的个数；

A4 = 被5除后余3的数字的平均数，精确到小数点后1位；

A5 = 被5除后余4的数字中最大数字。

输入格式：

每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。

输出格式：

对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。

若其中某一类数字不存在，则在相应位置输出“N”。

输入样例1：

13 1 2 3 4 5 6 7 8 9 10 20 16 18
输出样例1：

30 11 2 9.7 9
输入样例2：

8 1 2 4 5 6 7 9 16
输出样例2：

N 11 2 N 9
**/
#include<stdio.h>
#include<iostream>
using namespace std;
/**
A1 = 能被5整除的数字中所有偶数的和；A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
A3 = 被5除后余2的数字的个数；A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
A5 = 被5除后余4的数字中最大数字。
**/
int main(){
    int N;
    int A1=0,A2=0,A3=0,A4=0,A5=0;
    int symbol = 1;
    int count = 0;
    int A2COUNT = 0;
    cin>>N;
    while(N--){
        int num;
        cin>>num;
        if(num%5==0&&num%2==0){
            A1+=num;
        }else if(num%5==1){
            /**
                A2要注意，经历过一系列运算之后有可能变成0！所以要借助一个A2COUNT来判断！
            **/
            A2+=(symbol*num);
            symbol = -symbol;
            A2COUNT++;
        }else if(num%5==2){
            A3++;
        }else if(num%5==3){
            count++;
            A4+=num;
        }else if(num%5==4){
            if(num>A5){
                A5 = num;
            }
        }
    }

    if(A1==0){
        cout<<'N';
    }else{
        cout<<A1;
    }

    if(A2COUNT==0){
        cout<<" "<<'N';
    }else{
        cout<<" "<<A2;
    }

    if(A3==0){
        cout<<" "<<'N';
    }else{
        cout<<" "<<A3;
    }

    if(A4==0||count==0){
        cout<<" "<<'N';
    }else{
        double result = (double)A4/count;
        printf(" %.1f",result);
    }

    if(A5==0){
        cout<<" "<<'N';
    }else{
        cout<<" "<<A5;
    }

    return 0;
}
