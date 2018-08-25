/**
1013 数素数（20 分）
输入样例：
5 27
输出样例：
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
int prime[maxn]={0};/*存下所有素数*/
bool isP[maxn]={0};/*isP[i]=true说明i是素数*/
int num=0;//素数的数量

/*判别一个整数是否是素数，如果是就返回true，不是就返回false*/
bool isPrime(int n){
    if(n<=1)
        return false;/*特判*/

    int sqr = sqrt(1.0*n);
    for(int i=2;i<=sqr;i++){
        if(n%i==0)
            return false;
    }
    return true;
}

/*找出1-n之间所有的素数*/
void findPrime(int n){
    for(int i=2;i<=maxn;i++){
        if(isPrime(i)){
            prime[num] = i;
            isP[i] = true;
            num++;
            //只需要找到第N个素数，所以直接break结束查找
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

