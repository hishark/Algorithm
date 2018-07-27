/**
1028 人口普查(20)（20 分）提问
某城镇进行人口普查，得到了全体居民的生日。现请你写个程序，找出镇上最年长和最年轻的人。

这里确保每个输入的日期都是合法的，但不一定是合理的——假设已知镇上没有超过200岁的老人，而今天是2014年9月6日，所以超过200岁的生日和未出生的生日都是不合理的，应该被过滤掉。

输入格式：

输入在第一行给出正整数N，取值在(0, 10^5^]；随后N行，每行给出1个人的姓名（由不超过5个英文字母组成的字符串）、以及按“yyyy/mm/dd”（即年/月/日）格式给出的生日。题目保证最年长和最年轻的人没有并列。

输出格式：

在一行中顺序输出有效生日的个数、最年长人和最年轻人的姓名，其间以空格分隔。

输入样例：

5
John 2001/05/12
Tom 1814/09/06
Ann 2121/01/30
James 1814/09/05
Steve 1967/11/20
输出样例：

3 Tom John
**/
#include<stdio.h>
#include<iostream>
using namespace std;
struct person{
    int year,month,day;//日期
    string name;
}oldest,youngest,input,rright,lleft;

//大于等于返回true
bool ISaBiggerThanb(person a,person b){
    if(a.year!=b.year){
        return a.year>=b.year;
    }else if(a.month!=b.month){
        return a.month>=b.month;
    }else{
        return a.day>=b.day;
    }
}

//小于等于返回true
bool ISaLessThanb(person a,person b){
    if(a.year!=b.year){
        return a.year<=b.year;
    }else if(a.month!=b.month){
        return a.month<=b.month;
    }else{
        return a.day<=b.day;
    }
}

//数据初始化
void init(){
    rright.year = oldest.year = 2014;
    rright.month = oldest.month = 9;
    rright.day = oldest.day = 6;
    lleft.year = youngest.year = 1814;
    lleft.month = youngest.month = 9;
    lleft.day = youngest.day = 6;
}

//判断日期是否合法
bool isLegal(person p){
    if(ISaBiggerThanb(p,lleft)&&ISaLessThanb(p,rright)){
        return true;
    }else{
        return false;
    }
}
int main(){
    int N;
    cin>>N;
    int count = 0;
    init();
    while(N--){
        cin>>input.name;
        scanf("%d/%d/%d",&input.year,&input.month,&input.day);
        if(isLegal(input)){
            count++;
            if(ISaBiggerThanb(input,youngest)){
                youngest = input;
            }

            if(ISaLessThanb(input,oldest)){
                oldest = input;
            }
        }
    }
    if(count==0){
        //所有日期都不合法时要特判输出0
        cout<<"0"<<endl;
    }else{
        cout<<count<<" "<<oldest.name<<" "<<youngest.name<<endl;
    }

    return 0;
}
