/**
1042 �ַ�ͳ�ƣ�20 �֣�
���д�����ҳ�һ�θ��������г�����Ƶ�����Ǹ�Ӣ����ĸ��

�����ʽ��
������һ���и���һ�����Ȳ����� 1000 ���ַ������ַ����� ASCII ���������ɼ��ַ����ո���ɣ����ٰ��� 1 ��Ӣ����ĸ���Իس��������س��������ڣ���

�����ʽ��
��һ�����������Ƶ����ߵ��Ǹ�Ӣ����ĸ������ִ���������Կո�ָ�������в��У����������ĸ����С���Ǹ���ĸ��ͳ��ʱ�����ִ�Сд�����Сд��ĸ��

����������
This is a simple TEST.  There ARE numbers and other symbols 1&2&3...........
���������
e 7
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){

    string str;
    //��������ո����Բ�������cin����Ҫ��getline
    getline(cin,str);
    //ֻҪͳ��Ӣ����ĸ����hashTable����>26+1����
    int hashTable[30] = {0};
    int length = str.length();
    for(int i=0;i<length;i++){
        if(str[i]>='a'&&str[i]<='z'){
            hashTable[str[i]-'a'] ++;
        }else if(str[i]>='A'&&str[i]<='Z'){
            hashTable[str[i]-'A'] ++;
        }
    }

    int position=0;
    for(int i=0;i<30;i++){
        if(hashTable[i]>hashTable[position]){
            position = i;
        }
    }

    //printf("%c",position+'a');
    cout<<(char)(position+'a')<<" "<<hashTable[position]<<endl;

    return 0;
}

