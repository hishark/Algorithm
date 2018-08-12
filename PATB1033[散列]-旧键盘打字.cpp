/**
1033 旧键盘打字（20 分）
旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及坏掉的那些键，打出的结果文字会是怎样？

输入格式：
输入在 2 行中分别给出坏掉的那些键、以及应该输入的文字。
注意：如果上档键坏掉了，那么大写的英文字母无法被打出。

输出格式：
在一行中输出能够被打出的结果文字。如果没有一个字符能被打出，则输出空行。

输入样例：
7+IE.
7_This_is_a_test.
输出样例：
_hs_s_a_tst
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){
    string str1,str2;
    //cin>>str1>>str2;
    //为了防止第一行是空的，不能用cin >> ,用getline(cin, ...)
    getline(cin,str1);
    getline(cin,str2);
    int len1 = str1.length();
    int len2 = str2.length();
    bool hashTable[128];//hashTable用来判断键是否有用 初始情况下全部有用
    memset(hashTable,true,sizeof(hashTable));

    for(int i=0;i<len1;i++){
        if(str1[i]>='A'&&str1[i]<='Z'){
            //如果是大写的全部改成小写以统一
            str1[i]+=32;
        }
        //str1中出现过的字符都置为false
        hashTable[str1[i]] = false;
    }


    for(int i=0;i<len2;i++){
        //如果当前字符是大写，先转化成小写，判断键是否有用以及上档键是否有用，都有用就输出
        if(str2[i]>='A'&&str2[i]<='Z'){
            //记得新建一个变量存小写 不要直接对str2[i]操作
            char low = str2[i]+32;
            if(hashTable[low]==true&&hashTable['+']==true){
                cout<<str2[i];
            }

        }else if(hashTable[str2[i]]==true){
            cout<<str2[i];
        }
    }
    cout<<endl;
    return 0;
}

