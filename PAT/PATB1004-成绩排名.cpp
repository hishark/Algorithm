/**
1004 �ɼ����� (20)��20 �֣�����
����n��ѧ����������ѧ�š��ɼ����ֱ�����ɼ���ߺͳɼ����ѧ����������ѧ�š�

�����ʽ��ÿ�������������1��������������ʽΪ\

  ��1�У�������n
  ��2�У���1��ѧ�������� ѧ�� �ɼ�
  ��3�У���2��ѧ�������� ѧ�� �ɼ�
  ... ... ...
  ��n+1�У���n��ѧ�������� ѧ�� �ɼ�
����������ѧ�ž�Ϊ������10���ַ����ַ������ɼ�Ϊ0��100֮���һ�����������ﱣ֤��һ�����������û������ѧ���ĳɼ�����ͬ�ġ�

�����ʽ����ÿ�������������2�У���1���ǳɼ����ѧ����������ѧ�ţ���2���ǳɼ����ѧ����������ѧ�ţ��ַ�������1�ո�

����������

3
Joe Math990112 89
Mike CS991301 100
Mary EE990830 95
���������

Mike CS991301
Joe Math990112
**/
#include<stdio.h>
#include<iostream>
using namespace std;
struct Student{
    string name;
    string sno;
    int grade;
};
int main(){
    Student input,max,min;
    max.grade = -1;//��߷ֳ�ʼֵΪ-1
    min.grade = 101;//��ͷֳ�ʼֵΪ101
    int N;
    cin>>N;
    while(N--){
        cin>>input.name;
        cin>>input.sno;
        cin>>input.grade;

        /**
            ������if
            ��д��if-else if
            ��Ȼ������
        **/
        if(input.grade<min.grade){
            min = input;
        }

        if(input.grade>max.grade){
            max = input;
        }
    }
    cout<<max.name<<" "<<max.sno<<endl;
    cout<<min.name<<" "<<min.sno<<endl;
    return 0;
}

