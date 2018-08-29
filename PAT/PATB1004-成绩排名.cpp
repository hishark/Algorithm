/**
1004 成绩排名 (20)（20 分）提问
读入n名学生的姓名、学号、成绩，分别输出成绩最高和成绩最低学生的姓名和学号。

输入格式：每个测试输入包含1个测试用例，格式为\

  第1行：正整数n
  第2行：第1个学生的姓名 学号 成绩
  第3行：第2个学生的姓名 学号 成绩
  ... ... ...
  第n+1行：第n个学生的姓名 学号 成绩
其中姓名和学号均为不超过10个字符的字符串，成绩为0到100之间的一个整数，这里保证在一组测试用例中没有两个学生的成绩是相同的。

输出格式：对每个测试用例输出2行，第1行是成绩最高学生的姓名和学号，第2行是成绩最低学生的姓名和学号，字符串间有1空格。

输入样例：

3
Joe Math990112 89
Mike CS991301 100
Mary EE990830 95
输出样例：

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
    max.grade = -1;//最高分初始值为-1
    min.grade = 101;//最低分初始值为101
    int N;
    cin>>N;
    while(N--){
        cin>>input.name;
        cin>>input.sno;
        cin>>input.grade;

        /**
            是两个if
            别写成if-else if
            不然会出错的
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

