/**
1011 A+B��C (15)��15 �֣�
��������[-2^31^, 2^31^]�ڵ�3������A��B��C�����ж�A+B�Ƿ����C��

�����ʽ��

�����1�и���������T(<=10)���ǲ��������ĸ�����������T�����������ÿ��ռһ�У�˳�����A��B��C���������Կո�ָ���

�����ʽ��

��ÿ�������������һ���������Case #X: true�����A+B>C�����������Case #X: false��������X�ǲ��������ı�ţ���1��ʼ����

����������

4
1 2 3
2 3 4
2147483647 0 2147483646
0 -2147483648 -2147483647
���������

Case #1: false
Case #2: true
Case #3: true
Case #4: false
**/
#include<stdio.h>
#include<iostream>
using namespace std;
int main(){
    int T;
    cin>>T;
    int count = 1;
    while(T--){
        /**
            ע��㣬��Ŀ˵�˷�Χ��-2^31~2^31��Ȼ��int�����ݷ�Χ��-2^31~2^31-1������һ���ᳬ����Χ������Ҫ��long long
            �������õ�cincout��������ν��ʽ
            ����õ�printf��scanfҪע��long long��Ӧ����lld
        **/
        long long a,b,c;
        cin>>a;
        cin>>b;
        cin>>c;
        long long sum = a + b;
        if(sum>c){
            cout<<"Case #"<<count<<":"<<" true"<<endl;
        }else{
            cout<<"Case #"<<count<<":"<<" false"<<endl;
        }
        count++;
    }
    return 0;
}
