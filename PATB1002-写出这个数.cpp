/**
1002 д������� (20)��20 �֣�
����һ����Ȼ��n���������λ����֮�ͣ��ú���ƴ��д���͵�ÿһλ���֡�

�����ʽ��ÿ�������������1��������������������Ȼ��n��ֵ�����ﱣ֤nС��10^100^��

�����ʽ����һ�������n�ĸ�λ����֮�͵�ÿһλ��ƴ�����ּ���1 �ո񣬵�һ�������һ��ƴ�����ֺ�û�пո�

����������

1234567890987654321123456789
���������

yi san wu
**/
#include<stdio.h>
#include<iostream>
#include<cstring>
using namespace std;
int main(){
    char num[101];
    scanf("%s",num);
    int length = strlen(num);
    string change[10]={"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
    int sum = 0;
    for(int i=0;i<length;i++){
        sum+= (num[i]-'0');
    }

    //sum���Ҳ��900 ��������λ��,num��λ��
    int ans[3],nnum=0;
    while(sum!=0){
        ans[nnum] = sum%10;
        nnum++;
        sum /= 10;
    }

    for(int i=nnum-1;i>=0;i--){
        if(i==nnum-1){
            cout<<change[ans[i]];
        }else{
            cout<<" "<<change[ans[i]];
        }
    }
    return 0;
}
