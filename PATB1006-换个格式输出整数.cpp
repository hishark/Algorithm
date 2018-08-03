/**
1006 换个格式输出整数 (15)（15 分）
让我们用字母B来表示“百”、字母S表示“十”，用“12...n”来表示个位数字n（&lt10），换个格式来输出任一个不超过3位的正整数。例如234应该被输出为BBSSS1234，因为它有2个“百”、3个“十”、以及个位的4。

输入格式：每个测试输入包含1个测试用例，给出正整数n（&lt1000）。

输出格式：每个测试用例的输出占一行，用规定的格式输出n。

输入样例1：

234
输出样例1：

BBSSS1234
输入样例2：

23
输出样例2：

SS123
**/
#include<stdio.h>
#include<iostream>
using namespace std;
int main(){
    int n;
    cin>>n;
    int num=0;//num是正整数n的位数
    int ans[3];//存该正整数每一位的数字
    while(n!=0){
        ans[num] = n%10;
        num++;
        n = n/10;
    }
    for(int i=num-1;i>=0;i--){
        //百位
        if(i==2){
            for(int j=0;j<ans[i];j++){
                cout<<"B";
            }
        }
        //十位
        if(i==1){
            for(int j=0;j<ans[i];j++){
                cout<<"S";
            }
        }
        //个位
        if(i==0){
            for(int j=1;j<=ans[i];j++){
                cout<<j;
            }
        }
    }
    return 0;
}
