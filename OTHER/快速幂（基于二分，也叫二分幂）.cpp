#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
typedef long long LL;
//��a^b%m���ǵݹ�д��
LL Pow(LL a,LL b,LL m){
    LL ans = 1;
    for(int i=0;i<b;i++){
        ans = ans*a%m;
    }
    return ans;
}
//��a^b%m���ݹ�д��
LL binaryPow(LL a,LL b,LL m){
    if(b==0)//���bΪ0����ôa^0=1
        return 1;
    //bΪ������ת��Ϊb-1
    if(b%2==1)
        return a*binaryPow(a,b-1,m)%m;
    else{
        //bΪż����ת��Ϊb/2
        LL mul = binaryPow(a,b/2,m);
        return mul*mul%m;
    }
}
int main(){

    return 0;
}
