/**
1033 �ɼ��̴��֣�20 �֣�
�ɼ����ϻ��˼���������������һ�����ֵ�ʱ�򣬶�Ӧ���ַ��Ͳ�����֡����ڸ���Ӧ�������һ�����֡��Լ���������Щ��������Ľ�����ֻ���������

�����ʽ��
������ 2 ���зֱ������������Щ�����Լ�Ӧ����������֡�
ע�⣺����ϵ��������ˣ���ô��д��Ӣ����ĸ�޷��������

�����ʽ��
��һ��������ܹ�������Ľ�����֡����û��һ���ַ��ܱ��������������С�

����������
7+IE.
7_This_is_a_test.
���������
_hs_s_a_tst
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){
    string str1,str2;
    //cin>>str1>>str2;
    //Ϊ�˷�ֹ��һ���ǿյģ�������cin >> ,��getline(cin, ...)
    getline(cin,str1);
    getline(cin,str2);
    int len1 = str1.length();
    int len2 = str2.length();
    bool hashTable[128];//hashTable�����жϼ��Ƿ����� ��ʼ�����ȫ������
    memset(hashTable,true,sizeof(hashTable));

    for(int i=0;i<len1;i++){
        if(str1[i]>='A'&&str1[i]<='Z'){
            //����Ǵ�д��ȫ���ĳ�Сд��ͳһ
            str1[i]+=32;
        }
        //str1�г��ֹ����ַ�����Ϊfalse
        hashTable[str1[i]] = false;
    }


    for(int i=0;i<len2;i++){
        //�����ǰ�ַ��Ǵ�д����ת����Сд���жϼ��Ƿ������Լ��ϵ����Ƿ����ã������þ����
        if(str2[i]>='A'&&str2[i]<='Z'){
            //�ǵ��½�һ��������Сд ��Ҫֱ�Ӷ�str2[i]����
            char low = str2[i]+32;
            if(hashTable[low]==true&&hashTable['+']==true){
                cout<<str2[i];
            }

        }else if(hashTable[str2[i]]==true){
            cout<<str2[i];
        }
    }
    cout<<endl;
    return 0;
}

