/**
1047 �����������20 �֣�
����������Ĺ���Ϊ��ÿ�������������ɶ�Ա��ɣ����ж�Ա���������������ӵĳɼ�Ϊ���ж�Ա�ĳɼ��ͣ��ɼ���ߵĶӻ�ʤ��

�ָ������ж�Ա�ı����ɼ��������д�����ҳ��ھ��ӡ�

�����ʽ��
�����һ�и���һ�������� N����10^4���������в�����Ա��������� N �У�ÿ�и���һλ��Ա�ĳɼ�����ʽΪ��������-��Ա��� �ɼ������ж�����Ϊ 1 �� 1000 ������������Ա���Ϊ 1 �� 10 �����������ɼ�Ϊ 0 �� 100 ��������

�����ʽ��
��һ��������ھ��ӵı�ź��ܳɼ��������һ���ո�ָ���ע�⣺��Ŀ��֤�ھ�����Ψһ�ġ�

����������
6
3-10 99
11-5 87
102-1 0
102-3 100
11-9 89
3-2 61
���������
11 176
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){
    int N;
    cin>>N;
    int hashTable[1010] = {0};
    while(N--){
        int team,person,score;
        scanf("%d-%d %d",&team,&person,&score);
        hashTable[team]+=score;
    }

    int position = 0;
    for(int i=0;i<1010;i++){
        if(hashTable[i]>hashTable[position]){
            position = i;
        }
    }

    cout<<position<<" "<<hashTable[position]<<endl;
    return 0;
}
