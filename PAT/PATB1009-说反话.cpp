/**
1009 ˵���� (20)��20 �֣�
����һ��Ӣ�Ҫ�����д���򣬽��������е��ʵ�˳��ߵ������

�����ʽ�������������һ��������������һ���ڸ����ܳ��Ȳ�����80���ַ������ַ��������ɵ��ʺ����ɿո���ɣ����е�������Ӣ����ĸ����Сд�����֣���ɵ��ַ���������֮����1���ո�ֿ������뱣֤����ĩβû�ж���Ŀո�

�����ʽ��ÿ���������������ռһ�У���������ľ��ӡ�

����������

Hello World Here I Come
���������

Come I Here World Hello
**/
#include<stdio.h>
#include<iostream>
using namespace std;
int main() {
    char result[81][81];
    int num = 0;
    while(scanf("%s", result[num])!=EOF){
        num++;
    }
    for(int i=num-1;i>=0;i--){
        if(i==num-1){
            cout<<result[i];
        }else{
            cout<<" "<<result[i];
        }
    }

    return 0;
}
