/**
1038 ͳ��ͬ�ɼ�ѧ��(20)��20 �֣�
����Ҫ�����N��ѧ���ĳɼ��������ĳһ����������ѧ�����������

�����ʽ��

�����ڵ�1�и���������10^5^��������N����ѧ�������������1�и���N��ѧ���İٷ��������ɼ����м��Կո�ָ������1�и���Ҫ��ѯ�ķ�������K��������N�����������������K���������м��Կո�ָ���

�����ʽ��

��һ���а���ѯ˳������÷ֵ���ָ��������ѧ���������м��Կո�ָ�������ĩ�����ж���ո�

����������

10
60 75 90 55 75 99 82 90 75 50
3 75 90 88
���������

3 2 0
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){
    int N;
    //��cincout�ᳬʱ
    scanf("%d",&N);
    int hashTable[110]={0};
    while(N--){
        int score;
        scanf("%d",&score);
        hashTable[score]++;
    }
    int S;
    scanf("%d",&S);
    bool isFirst = true;
    while(S--){
        int search;
        scanf("%d",&search);
        if(isFirst){
            printf("%d",hashTable[search]);
            isFirst = false;
        }else{
            printf(" %d",hashTable[search]);
        }
    }
    return 0;
}
