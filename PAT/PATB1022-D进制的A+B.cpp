/**
1022 D���Ƶ�A+B (20)��20 �֣�����
���������Ǹ�10��������A��B(<=2^30^-1)�����A+B��D (1 < D <= 10)��������

�����ʽ��

������һ�������θ���3������A��B��D��

�����ʽ��

���A+B��D��������

����������

123 456 8
���������

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

    //ʮ����תD����ģ�� ��do-while
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

