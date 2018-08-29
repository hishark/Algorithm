#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
typedef long long LL;
//求a^b%m，非递归写法
LL Pow(LL a,LL b,LL m){
    LL ans = 1;
    for(int i=0;i<b;i++){
        ans = ans*a%m;
    }
    return ans;
}
//求a^b%m，递归写法
LL binaryPow(LL a,LL b,LL m){
    if(b==0)//如果b为0，那么a^0=1
        return 1;
    //b为奇数，转换为b-1
    if(b%2==1)
        return a*binaryPow(a,b-1,m)%m;
    else{
        //b为偶数，转换为b/2
        LL mul = binaryPow(a,b/2,m);
        return mul*mul%m;
    }
}
int main(){

    return 0;
}
