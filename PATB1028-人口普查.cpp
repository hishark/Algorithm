/**
1028 �˿��ղ�(20)��20 �֣�����
ĳ��������˿��ղ飬�õ���ȫ���������ա�������д�������ҳ��������곤����������ˡ�

����ȷ��ÿ����������ڶ��ǺϷ��ģ�����һ���Ǻ���ġ���������֪����û�г���200������ˣ���������2014��9��6�գ����Գ���200������պ�δ���������ն��ǲ�����ģ�Ӧ�ñ����˵���

�����ʽ��

�����ڵ�һ�и���������N��ȡֵ��(0, 10^5^]�����N�У�ÿ�и���1���˵��������ɲ�����5��Ӣ����ĸ��ɵ��ַ��������Լ�����yyyy/mm/dd��������/��/�գ���ʽ���������ա���Ŀ��֤���곤�����������û�в��С�

�����ʽ��

��һ����˳�������Ч���յĸ��������곤�˺��������˵�����������Կո�ָ���

����������

5
John 2001/05/12
Tom 1814/09/06
Ann 2121/01/30
James 1814/09/05
Steve 1967/11/20
���������

3 Tom John
**/
#include<stdio.h>
#include<iostream>
using namespace std;
struct person{
    int year,month,day;//����
    string name;
}oldest,youngest,input,rright,lleft;

//���ڵ��ڷ���true
bool ISaBiggerThanb(person a,person b){
    if(a.year!=b.year){
        return a.year>=b.year;
    }else if(a.month!=b.month){
        return a.month>=b.month;
    }else{
        return a.day>=b.day;
    }
}

//С�ڵ��ڷ���true
bool ISaLessThanb(person a,person b){
    if(a.year!=b.year){
        return a.year<=b.year;
    }else if(a.month!=b.month){
        return a.month<=b.month;
    }else{
        return a.day<=b.day;
    }
}

//���ݳ�ʼ��
void init(){
    rright.year = oldest.year = 2014;
    rright.month = oldest.month = 9;
    rright.day = oldest.day = 6;
    lleft.year = youngest.year = 1814;
    lleft.month = youngest.month = 9;
    lleft.day = youngest.day = 6;
}

//�ж������Ƿ�Ϸ�
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
        //�������ڶ����Ϸ�ʱҪ�������0
        cout<<"0"<<endl;
    }else{
        cout<<count<<" "<<oldest.name<<" "<<youngest.name<<endl;
    }

    return 0;
}
