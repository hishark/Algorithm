/**
1048 ���ּ���(20)��20 �֣�
����Ҫ��ʵ��һ�����ּ��ܷ��������ȹ̶�һ��������������A������һ������B������ÿ1λ������A�Ķ�Ӧλ���ϵ����ֽ����������㣺������λ����Ӧλ��������Ӻ��13ȡ�ࡪ��������J����10��Q����11��K����12����ż��λ����B�����ּ�ȥA�����֣������Ϊ���������ټ�10���������λΪ��1λ��

�����ʽ��

������һ�������θ���A��B����Ϊ������100λ��������������Կո�ָ���

�����ʽ��

��һ����������ܺ�Ľ����

����������

1234567 368782971
���������

3695Q8118
**/
#include<stdio.h>
#include<iostream>
#include<cstring>
using namespace std;
//��ת�ַ�����ѧ��stl֮������ֳɵĿ���ֱ����
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

