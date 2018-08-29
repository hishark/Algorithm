/**
字符串 APPAPT 中包含了两个单词 PAT，其中第一个 PAT 是第 2 位(P)，第 4 位(A)，第 6 位(T)；第二个 PAT 是第 3 位(P)，第 4 位(A)，第 6 位(T)。

现给定字符串，问一共可以形成多少个 PAT？

输入格式：
输入只有一行，包含一个字符串，长度不超过10^5
​​ ，只包含 P、A、T 三种字母。

输出格式：
在一行中输出给定字符串中包含多少个 PAT。由于结果可能比较大，只输出对 1000000007 取余数的结果。

输入样例：
APPAPT
输出样例：
2
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){
    string str;
    cin>>str;
    int length;
    length = str.length();

    //该数组用于记下每一位左边P的个数（包括本位）
    int leftNum[100010]={0};

    //从左往右遍历字符串，给leftNum赋值
    for(int i=0;i<length;i++){
        //i大于0的都先继承一下上一位的数目
        if(i>0){
            leftNum[i] = leftNum[i-1];
        }

        if(str[i]=='P'){
            leftNum[i] ++;
        }

    }

    int ans=0;//最终结果
    int rightNum=0;//当前位右边的T的数目
    //从右往左遍历字符串，给rightNum赋值并且同时计算ans
    for(int i=length-1;i>=0;i--){
        if(str[i]=='T'){
            rightNum++;
        }else if(str[i]=='A'){
            //ans += (leftNum[i]*rightNum) % 1000000007 别图快写成这个了，是错误哒，看清楚了
            ans = (ans+ leftNum[i]*rightNum) % 1000000007;
        }
    }
    cout<<ans<<endl;
    return 0;
}
