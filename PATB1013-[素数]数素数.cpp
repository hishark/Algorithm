/**
1013 ��������20 �֣�
����������
5 27
���������
11 13 17 19 23 29 31 37 41 43
47 53 59 61 67 71 73 79 83 89
97 101 103
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
#include<math.h>
using namespace std;
const int maxn = 1000001;
int prime[maxn]={0};/*������������*/
bool isP[maxn]={0};/*isP[i]=true˵��i������*/
int num=0;//����������

/*�б�һ�������Ƿ�������������Ǿͷ���true�����Ǿͷ���false*/
bool isPrime(int n){
    if(n<=1)
        return false;/*����*/

    int sqr = sqrt(1.0*n);
    for(int i=2;i<=sqr;i++){
        if(n%i==0)
            return false;
    }
    return true;
}

/*�ҳ�1-n֮�����е�����*/
void findPrime(int n){
    for(int i=2;i<=maxn;i++){
        if(isPrime(i)){
            prime[num] = i;
            isP[i] = true;
            num++;
            //ֻ��Ҫ�ҵ���N������������ֱ��break��������
            if(num==n)
                break;
        }
    }
}
int main(){
    int M,N;
    cin>>M>>N;
    findPrime(N);
    int count = 1;
    for(int i=M-1;i<N;i++){
        if(count%10==1){
            cout<<prime[i];
        }else if(count%10<=9&&count%10>=2){
            cout<<" "<<prime[i];
        }else if(count%10==0){
            cout<<" "<<prime[i]<<endl;
        }
        count++;
    }
    return 0;
}

