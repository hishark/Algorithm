/**
��Ŀ����
���������ڣ�����������֮�������������������������������ǹ涨����֮�������Ϊ���졣

����
�ж������ݣ�ÿ�����������У��ֱ��ʾ�������ڣ���ʽΪYYYYMMDD

���
ÿ���������һ�У������ڲ�ֵ

��������
20130101
20130105
�������
5
**/
#include<stdio.h>
#include<iostream>
using namespace std;
bool isLeap(int year){
    if((year%4==0&&year%100!=0)||(year%400==0)){
        return true;
    }else{
        return false;
    }
}
int main(){
    int date1,date2;
    cin>>date1>>date2;

    //�·��������
    int month[13][2]={
        {0,0},{31,31},{28,29},{31,31},{30,30},
        {31,31},{30,30},{31,31},{31,31},
        {30,30},{31,31},{30,30},{31,31}
    };

    if(date1>date2){
        int temp = date1;
        date1 = date2;
        date2 = temp;
    }

    int year1,year2,month1,month2,day1,day2;

    year1 = date1/10000;
    year2 = date2/10000;

    month1 = date1%10000/100;
    month2 = date2%10000/100;

    day1 = date1%100;
    day2 = date2%100;

    int result = 0;



    /**
    (year1!=year2)&&(month1!=month2)&&(day1!=day2)
    һ��С�ӣ�������������˼��ÿ��������ȣ���ĿҪ���������һ�����Ⱦ�һֱ����ȥ������Ҫ�ĳ�
    (year1!=year2)||(month1!=month2)||(day1!=day2)
    **/
    while((year1!=year2)||(month1!=month2)||(day1!=day2)){
        //��ǰ�·ݵ�����
        int thisMonthDay;

        if(isLeap(year1)){
            thisMonthDay=month[month1][1];
        }else{
            thisMonthDay=month[month1][0];
        }

        day1++;
        if(day1==thisMonthDay+1){
            month1++;
            day1 = 1;
        }

        if(month1==13){
            year1++;
            month1=1;
        }

        result++;
    }
    cout<<result+1;
    return 0;
}

