/**
1043 ���PATest��20 �֣�
����һ�����Ȳ����� 10^4�ġ�����Ӣ����ĸ���ɵ��ַ������뽫�ַ����µ���˳�򣬰� PATestPATest.... ������˳������������������ַ�����Ȼ�������ַ��ĸ�����һ����һ����ģ���ĳ���ַ��Ѿ�����꣬�����µ��ַ��԰� PATest ��˳���ӡ��ֱ�������ַ����������

�����ʽ��
������һ���и���һ�����Ȳ����� 10^4�ġ�����Ӣ����ĸ���ɵķǿ��ַ�����

�����ʽ��
��һ���а���ĿҪ������������ַ�������Ŀ��֤����ǿա�

����������
redlesPayBestPATTopTeePHPereatitAPPT
���������
PATestPATestPTetPTePePee
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){
    string str;
    cin>>str;
    int length = str.length();
    int hashTable[6]={0};
    char dict[6]={'P','A','T','e','s','t'};
    int sum = 0;

    //��ʼ��hashTable
    for(int i=0;i<length;i++){
        //���ַ������ÿһ���ַ�������dict����ַ����б����ȶ�,��ͳ���ַ���
        for(int j=0;j<6;j++){
            if(str[i]==dict[j]){
                hashTable[j]++;
                sum++;
                break;
            }
        }
    }

    //ֻҪsum��Ϊ0��һֱѭ�����
    while(sum!=0){
        for(int i=0;i<6;i++){
            if(hashTable[i]!=0){
                cout<<dict[i];
                hashTable[i]--;
                sum--;
            }
        }
    }
    return 0;
}
