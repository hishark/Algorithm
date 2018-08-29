/**
1048 数字加密(20)（20 分）
本题要求实现一种数字加密方法。首先固定一个加密用正整数A，对任一正整数B，将其每1位数字与A的对应位置上的数字进行以下运算：对奇数位，对应位的数字相加后对13取余——这里用J代表10、Q代表11、K代表12；对偶数位，用B的数字减去A的数字，若结果为负数，则再加10。这里令个位为第1位。

输入格式：

输入在一行中依次给出A和B，均为不超过100位的正整数，其间以空格分隔。

输出格式：

在一行中输出加密后的结果。

输入样例：

1234567 368782971
输出样例：

3695Q8118
**/
#include<stdio.h>
#include<iostream>
#include<cstring>
using namespace std;
//翻转字符串，学了stl之后会有现成的可以直接用
void reverse(char s[]) {
    int len = strlen(s);
    for(int i = 0; i < len / 2; i++) {
        int temp = s[i];
        s[i] = s[len - 1 - i];
        s[len - 1 - i] = temp;
    }
}
int main() {
    char A[101] = {0}, B[101] = {0};
    //memset(A, '0', sizeof(A));
    //memset(B, '0', sizeof(B));
    char ans[101]={0};
    scanf("%s%s", A, B);
    reverse(A);
    reverse(B);

    int lenA = strlen(A);
    int lenB = strlen(B);

    int len;
    if(lenA > lenB) {
        len = lenA;
    } else {
        len = lenB;
    }

    char change[13] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'J', 'Q', 'K'};

    for(int i = 0; i < len; i++) {
        if(i >= lenA)
            A[i] = '0';
        if(i >= lenB)
            B[i] = '0';

        if(i % 2 == 0) {
            //cout<<A[i]<<" "<<B[i]<<endl;
            ans[i] = change[((A[i] - '0') + (B[i] - '0')) % 13];
        } else {
            //cout<<A[i]<<" "<<B[i]<<endl;
            int result = (B[i] - '0') - (A[i] - '0');
            if(result < 0) {
                ans[i] = (result + 10) + '0';
            } else {
                ans[i] = result + '0';
            }
        }
    }

    //1234567 1234567
    //cout<<len<<endl;
    reverse(ans);
    for(int i=0;i<len;i++){
        cout<<ans[i];
    }


    return 0;
}

