/**
1039 ��������20����20 �֣�
С������Щ������һ���Լ�ϲ�����鴮�������ӵ�̯���кܶമ������ɫ���鴮�����ǲ��ϰ��κ�һ����ɢ����������С��Ҫ���æ�ж�һ�£�ĳ���������Ƿ������ȫ���Լ���Ҫ�����ӣ�����ǣ���ô�������ж��ٶ�������ӣ�������ǣ���ô������ȱ�˶������ӡ�

Ϊ���������������[0-9]��[a-z]��[A-Z]��Χ�ڵ��ַ�����ʾ��ɫ��������ͼ1�У���3����С���������鴮����ô��1����������Ϊ������ȫ������Ҫ�����ӣ�������8�Ų���Ҫ�����ӣ���2����������Ϊû�к�ɫ���ӣ���������һ�ź�ɫ�����ӡ�

\ ͼ 1

�����ʽ��

ÿ���������1������������ÿ�����������ֱ���2�����Ⱥ����̯�����鴮��С���������鴮��������������1000�����ӡ�

�����ʽ��

�������������һ���������Yes���Լ��ж��ٶ�������ӣ����������������һ���������No���Լ�ȱ�˶������ӡ������1���ո�ָ���

��������1��

ppRYYGrrYBR2258
YrR8RrY
�������1��

Yes 8
��������2��

ppRYYGrrYB225
YrR8RrY
�������2��

No 2
**/

#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

//���ַ������ÿ���ַ�ת��ΪhashTable���±�
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
    //����whole�ַ�������ʼ��hashTable
    for(int i = 0; i < len1; i++) {
        int id = change(whole[i]);
        hashTable[id] ++;
    }

    //����Ŀ���ַ���
    for(int i=0;i<len2;i++){
        int id = change(target[i]);
        hashTable[id]--;
        //���hashTable[id]<0����ô��ζ�����Ӳ����� miss��Ҫ������
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
