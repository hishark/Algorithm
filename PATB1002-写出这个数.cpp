/**
1002 写出这个数 (20)（20 分）
读入一个自然数n，计算其各位数字之和，用汉语拼音写出和的每一位数字。

输入格式：每个测试输入包含1个测试用例，即给出自然数n的值。这里保证n小于10^100^。

输出格式：在一行内输出n的各位数字之和的每一位，拼音数字间有1 空格，但一行中最后一个拼音数字后没有空格。

输入样例：

1234567890987654321123456789
输出样例：

yi san wu
**/
#include<stdio.h>
#include<iostream>
#include<cstring>
using namespace std;
int main(){
    char num[101];
    scanf("%s",num);
    int length = strlen(num);
    string change[10]={"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
    int sum = 0;
    for(int i=0;i<length;i++){
        sum+= (num[i]-'0');
    }

    //sum最大也才900 不超过三位数,num是位数
    int ans[3],nnum=0;
    while(sum!=0){
        ans[nnum] = sum%10;
        nnum++;
        sum /= 10;
    }

    for(int i=nnum-1;i>=0;i--){
        if(i==nnum-1){
            cout<<change[ans[i]];
        }else{
            cout<<" "<<change[ans[i]];
        }
    }
    return 0;
}
