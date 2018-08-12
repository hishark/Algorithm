/**
1029 旧键盘(20)（20 分）
旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及实际被输入的文字，请你列出肯定坏掉的那些键。

输入格式：

输入在2行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过80个字符的串，由字母A-Z（包括大、小写）、数字0-9、以及下划线“_”（代表空格）组成。题目保证2个字符串均非空。

输出格式：

按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有1个坏键。

输入样例：

7_This_is_a_test
_hs_s_a_es
输出样例：

7TI
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){
    string str1,str2;
    cin>>str1>>str2;
    int len1 = str1.length();
    int len2 = str2.length();

    bool hashTable[128] = {false};//该数组用来记录某个字符是否已经被输出，初始状态都未输出

    //遍历字符串str1
    for(int i=0;i<len1;i++){
        char c1 = str1[i];
        int j;
        for(j=0;j<len2;j++){
            char c2 = str2[j];
            //如果是小写字母就转换为大写字母，统一方便计算
            if(c1>='a'&&c1<='z')
                c1-=32;
            if(c2>='a'&&c2<='z')
                c2-=32;
            if(c1==c2){
                //如果c1和c2相等，表示存在字符，不需要输出，跳出循环
                break;
            }
        }

        //如果遍历str2都没有找到字符而且这个字符还没有被输出过，那么就要输出字符啦
        if(j==len2&&hashTable[c1]==false){
            cout<<c1;
            hashTable[c1] = true;
        }

    }

    return 0;
}
