/**
1022 D进制的A+B (20)（20 分）提问
输入两个非负10进制整数A和B(<=2^30^-1)，输出A+B的D (1 < D <= 10)进制数。

输入格式：

输入在一行中依次给出3个整数A、B和D。

输出格式：

输出A+B的D进制数。

输入样例：

123 456 8
输出样例：

1103
**/
#include<stdio.h>
#include<iostream>
using namespace std;
int main(){
    int A,B,D;
    cin>>A>>B>>D;
    int sum = A+B;
    int result[40];
    int num = 0;

    //十进制转D进制模板 用do-while
    do{
        result[num] = sum%D;
        sum = sum/D;
        num++;
    }while(sum!=0);

    for(int i=num-1;i>=0;i--){
        cout<<result[i];
    }
    return 0;
}

