/**
1027 打印沙漏(20)（20 分）提问
本题要求你写个程序把给定的符号打印成沙漏的形状。例如给定17个“*”，要求按下列格式打印

*****
 ***
  *
 ***
*****
所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递增；首尾符号数相等。

给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。

输入格式：

输入在一行给出1个正整数N（<=1000）和一个符号，中间以空格分隔。

输出格式：

首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。

输入样例：

19 *
输出样例：

*****
 ***
  *
 ***
*****
2
**/
#include<stdio.h>
#include<iostream>
#include<math.h>
using namespace std;
int main(){
    int N;
    char c;
    cin>>N>>c;
    int x = floor(1.0*sqrt(2.0*(N+1)))-1;

    //这一步处理很重要，因为x算出来不一定是奇数
    if(x%2==0){
        x--;
    }
    //上半部分
    for(int i=x;i>=1;i-=2){//i是每一行的符号数量
        int blank;
        blank = (x-i)/2;
        //输出空格
        for(int j=0;j<blank;j++){
            cout<<" ";
        }
        //输出字符
        for(int j=0;j<i;j++){
            cout<<c;
        }
        //换行
        cout<<endl;
    }

    //下半部分
    for(int i=3;i<=x;i+=2){
        int blank;
        blank = (x-i)/2;
        //输出空格
        for(int j=0;j<blank;j++){
            cout<<" ";
        }
        //输出字符
        for(int j=0;j<i;j++){
            cout<<c;
        }
        //换行
        cout<<endl;
    }
    //输出的总字符
    int sum = (1+x)*(1+x)/2-1;

    //剩余字符
    cout<<N-sum<<endl;
    return 0;
}
