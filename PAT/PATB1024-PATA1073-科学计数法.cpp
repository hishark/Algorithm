/**
1024 科学计数法 (20)（20 分）
科学计数法是科学家用来表示很大或很小的数字的一种方便的方法，其满足正则表达式[+-][1-9]"."[0-9]+E[+-][0-9]+，即数字的整数部分只有1位，小数部分至少有1位，该数字及其指数部分的正负号即使对正数也必定明确给出。

现以科学计数法的格式给出实数A，请编写程序按普通数字表示法输出A，并保证所有有效位都被保留。

输入格式：

每个输入包含1个测试用例，即一个以科学计数法表示的实数A。该数字的存储长度不超过9999字节，且其指数的绝对值不超过9999。

输出格式：

对每个测试用例，在一行中按普通数字表示法输出A，并保证所有有效位都被保留，包括末尾的0。

输入样例1：

+1.23400E-03
输出样例1：

0.00123400
输入样例2：

-1.2E+10
输出样例2：

-12000000000
**/
#include<stdio.h>
#include<iostream>
#include<cstring>
using namespace std;
int main(){
    char str[10010];
    scanf("%s",str);
    int len = strlen(str);

    //如果是负数先输出负号
    if(str[0]=='-'){
        printf("-");
    }
    //position记下E所在位置（下标从0开始）
    int position=0;
    for(int i=0;i<len;i++){
        if(str[i]=='E'){
            position = i;
            break;
        }
    }
    //-1.2E+5
    //-1.2E-5
    //exp存指数
    int exp = 0;
    for(int i=position+2;i<len;i++){
        exp = exp*10 + (str[i]-'0');
    }

    //别忘了特判指数为0的情况
    if(exp==0){
        for(int i =1;i<position;i++){
            cout<<str[i];

        }
        return 0;
    }

    //如果指数为负-1.2E-5
    if(str[position+1]=='-'){
        //开头的形式一定是0.
        cout<<"0.";
        for(int i=0;i<exp-1;i++){
            cout<<"0";
        }
        cout<<str[1];
        for(int i=3;i<position;i++){
            cout<<str[i];
        }
    }else{
        //如果指数为正-1.2E+5
        //输出E之前的所有数字
        for(int i=1;i<position;i++){

            //忽略原来的小数点
            if(str[i]=='.')
                continue;

            //输出E之前的每一位数字，切记这句不可以写在下面的ifelse的else里
            cout<<str[i];

            //小数点位置加在exp+2上 pos-3是E和原来小数点之间的数字位数 一旦等于exp就说明不需要输出小数点
            if(i==exp+2&&position-3!=exp){
                cout<<".";
            }
        }

        //如果exp贼大，那需要补0
        for(int i=0;i<exp-(position-3);i++){
            cout<<"0";
        }
    }

    return 0;
}
