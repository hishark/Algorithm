#include<cstdio>
#include<iostream>
using namespace std;
const int maxn = 11;

/**
本题中的下标皆为1~n 没用0哦。
**/

//P为当前排列，hashTable记录整数x是否已经在P中
int n, P[maxn], hashTable[maxn]={false};

//当前处理排列的第index号位
void generateP(int index){
    if(index==n+1){
        //递归边界，已经处理完排列的1~n位
        for(int i=1;i<=n;i++){
            cout<<P[i];//输出当前排列
        }
        cout<<endl;
        return;
    }

    //枚举1~n 试图将x填入P[index]
    for(int x=1;x<=n;x++){
        if(hashTable[x]==false){//如果x不在P[1]~P[index]中
            //令P的第index位为x，即把x加入当前排列
            P[index] = x;

            //记x已经在P中
            hashTable[x] = true;

            //处理排列的第index+1位
            generateP(index+1);

            //已处理完P[index]为x的子问题，还原状态
            hashTable[x] = false;
        }
    }
}

int main(){
    n = 3;//欲输出1~3的全排列
    generateP(1);//从P[1]开始填
    return 0;
}
