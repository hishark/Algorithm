/**
1020 �±� (25)��25 �֣�
�±����й���������ѽ�ʱ�Ե�һ�ִ�ͳʳƷ����ͬ��������಻ͬ��ζ���±����ָ������������±��Ŀ���������ۼۡ��Լ��г�����������������������Ի�õ���������Ƕ��١�

ע�⣺����ʱ����ȡ��һ���ֿ�档���������������������ģ�����������3���±����������ֱ�Ϊ18��15��10��֣����ۼ۷ֱ�Ϊ75��72��45��Ԫ������г������������ֻ��20��֣���ô��������������Ӧ��������ȫ��15��ֵ�2���±����Լ�5��ֵ�3���±������ 72 + 45/2 = 94.5����Ԫ����

�����ʽ��

ÿ���������1������������ÿ�����������ȸ���һ��������1000��������N��ʾ�±������������Լ�������500�������Ϊ��λ����������D��ʾ�г���������������һ�и���N��������ʾÿ���±��Ŀ�����������Ϊ��λ�������һ�и���N��������ʾÿ���±������ۼۣ�����ԪΪ��λ�������ּ��Կո�ָ���

�����ʽ��

��ÿ�������������һ�������������棬����ԪΪ��λ����ȷ��С�����2λ��

����������

3 20
18 15 10
75 72 45
���������

94.50
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
struct mooncake{
    double stock;//�����
    double price;//���ۼ�
    double unitPrice;//����
}cake[1010];
/**
Try commenting in English! :)
**/
//sort from big to small
bool cmp(mooncake a,mooncake b){
    return a.unitPrice>b.unitPrice;
}
int main(){
    int n,D;
    cin>>n>>D;
    //input the stock of mooncake
    for(int i=0;i<n;i++){
        cin>>cake[i].stock;
    }

    //input the price of mooncake and calculate the unit price of mooncake.
    for(int i=0;i<n;i++){
        cin>>cake[i].price;
        cake[i].unitPrice = cake[i].price/cake[i].stock;
    }

    //sort by unitPrice
    sort(cake,cake+n,cmp);

    double ans = 0;
    for(int i =0;i<n;i++){
        if(cake[i].stock>=D){
            //if the stock of mooncake is more than the demand
            ans = ans+cake[i].unitPrice*D;
            D=0;
            break;
        }else if(cake[i].stock<D){
            D = D - cake[i].stock;
            ans = ans + cake[i].price;
        }
    }
    printf("%.2f\n",ans);
    return 0;
}

