/**
1037 �ڻ����ִ�����Ǯ��20����20 �֣�����
������ǹ����������ԣ����֪��ħ�����������Լ��Ļ���ϵͳ ���� ���纣����߹����ģ���ʮ�߸�������(Sickle)��һ����¡(Galleon)����ʮ�Ÿ�����(Knut)��һ�����ɣ������ס������ڣ���������Ӧ���ļ�ǮP����ʵ����ǮA�����������дһ��������������Ӧ�ñ��ҵ���Ǯ��

�����ʽ��

������1���зֱ����P��A����ʽΪ��Galleon.Sickle.Knut���������1���ո�ָ�������Galleon��[0, 10^7]�����ڵ�������Sickle��[0, 17)�����ڵ�������Knut��[0, 29)�����ڵ�������

�����ʽ��

��һ������������ͬ���ĸ�ʽ�������Ӧ�ñ��ҵ���Ǯ�������û����Ǯ����ô�����Ӧ���Ǹ�����

��������1��

10.16.27 14.1.28
�������1��

3.2.1
��������2��

14.1.28 10.16.27
�������2��

-3.2.1
**/
#include<stdio.h>
#include<iostream>
using namespace std;
//Galleon.Sickle.Knut
const int Galleon = 17*29;
const int Sickle = 29;
int main(){
    int PG,PS,PK,AG,AS,AK;

    scanf("%d.%d.%d",&PG,&PS,&PK);
    scanf("%d.%d.%d",&AG,&AS,&AK);

    int Pmoney,Amoney;

    //ȫ������Ϊ��С��λ֮���ټ����ֵ
    Pmoney = PG*Galleon+PS*Sickle+PK;
    Amoney = AG*Galleon+AS*Sickle+AK;


    int change = Amoney - Pmoney;
    if(change<0){
        cout<<"-";
        change = -change;
    }

    int changeG,changeS,changeK;
    changeG = change/Galleon;
    changeS = change%Galleon/Sickle;
    changeK = change%Sickle;

    cout<<changeG<<"."<<changeS<<"."<<changeK<<endl;

    return 0;
}

