/**
题目描述
有两个日期，求两个日期之间的天数，如果两个日期是连续的我们规定他们之间的天数为两天。

输入
有多组数据，每组数据有两行，分别表示两个日期，形式为YYYYMMDD

输出
每组数据输出一行，即日期差值

样例输入
20130101
20130105
样例输出
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

    //月份天数打表
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
    一个小坑，这个语句代表的意思是每个都不相等，题目要求的是其中一个不等就一直加下去，所以要改成
    (year1!=year2)||(month1!=month2)||(day1!=day2)
    **/
    while((year1!=year2)||(month1!=month2)||(day1!=day2)){
        //当前月份的天数
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

