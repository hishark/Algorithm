/**
1039 到底买不买（20）（20 分）
小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。于是小红要你帮忙判断一下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。

为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如在图1中，第3串是小红想做的珠串；那么第1串可以买，因为包含了全部她想要的珠子，还多了8颗不需要的珠子；第2串不能买，因为没有黑色珠子，并且少了一颗红色的珠子。

\ 图 1

输入格式：

每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过1000个珠子。

输出格式：

如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少珠子。其间以1个空格分隔。

输入样例1：

ppRYYGrrYBR2258
YrR8RrY
输出样例1：

Yes 8
输入样例2：

ppRYYGrrYB225
YrR8RrY
输出样例2：

No 2
**/

#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

//把字符串里的每个字符转换为hashTable的下标
int change(char c) {
    if(c >= '0' && c <= '9') {
        return c - '0';
    } else if(c >= 'A' && c <= 'Z') {
        return c - 'A' + 10;
    } else if(c >= 'a' && c <= 'z') {
        return c - 'a' + 10 + 26;
    }
}

int main() {
    string whole, target;
    cin >> whole >> target;
    int len1 = whole.length();
    int len2 = target.length();
    int miss = 0;
    int hashTable[100] = {0};
    //遍历whole字符串，初始化hashTable
    for(int i = 0; i < len1; i++) {
        int id = change(whole[i]);
        hashTable[id] ++;
    }

    //遍历目标字符串
    for(int i=0;i<len2;i++){
        int id = change(target[i]);
        hashTable[id]--;
        //如果hashTable[id]<0，那么意味着珠子不够啦 miss就要自增了
        if(hashTable[id]<0){
            miss++;
        }
    }

    if(miss!=0){
        cout<<"No "<<miss<<endl;
    }else{
        cout<<"Yes "<<len1-len2<<endl;
    }

    return 0;
}
