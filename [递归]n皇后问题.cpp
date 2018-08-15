#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<cstring>
using namespace std;
const int maxn = 10000;
//P为当前下标对应的行号，hashTable记录皇后x是否已放入棋盘
int n, P[maxn], hashTable[maxn] = {false};
int num = 0;

//暴力枚举
void generateP1(int index) {
    if(index == n + 1) { //递归边界，生成一个排列，接下来来判断是否合法
        bool flag = true;//flag为true时表示当前排列为一个合法方案
        for(int i = 1; i <= n; i++) {
            //遍历任意两个皇后
            for(int j = i + 1; j <= n; j++) {
                //i和j是列数，P[i]P[j]是行数，行数和列数的差相同表示在一条对角线上
                if(abs(i - j) == abs(P[i] - P[j])) {
                    flag = false;//不合法
                }
            }
        }
        if(flag == true)
            num++;//若当前方案合法，num加一
        return;
    }

    for(int x = 1; x <= n; x++) {
        if(hashTable[x] == false) {
            P[index] = x;
            hashTable[x] = true;
            generateP1(index + 1);
            hashTable[x] = false;
        }
    }
}

//回溯
void generateP2(int index) {
    if(index == n + 1) {
        //递归边界，生成一个合法方案
        num++;//能到达这里的一定是合法的
        return;
    }

    // 第x行 line x
    for(int x = 1; x <= n; x++) {
        //第x行还没有皇后
        if(hashTable[x] == false) {
            //flag为true表示当前皇后不会和之前的皇后冲突
            bool flag = true;

            //遍历之前的皇后
            for(int pre = 1; pre < index; pre++) {
                //第index列皇后的行号为x，第pre列皇后的行号为P[pre]
                if(abs(index - pre) == abs(x - P[pre])) {
                    flag = false;//与之前的皇后在一条对角线上，冲突
                    break;

                }
            }

            //如果可以把皇后放在第x行
            if(flag == true) {
                //令第index列皇后的行号为x
                P[index] = x;

                //第x行已经被占用
                hashTable[x] = true;

                //递归处理第index+1列皇后
                generateP2(index + 1);

                //递归完毕，还原第x行未被占用
                hashTable[x] = false;

            }

        }
    }
}

//来自己写一下回溯
void generateP(int index) {
    if(index == n + 1) {
        num++;
        return;
    }
    for(int x = 1; x <= n; x++) { //第x行
        //如果第x行还没有放皇后
        if(hashTable[x] == false) {
            //index是列，x是行。
            bool flag = true;//flag为true表示合法，没有形成对角线哦
            //现在来确定是否会和之前的皇后形成对角线
            for(int pre = 1; pre < index; pre++) {
                //index和pre是列号，x和P[pre]是行号
                if(abs(index - pre) == abs(x - P[pre])) {
                    //如果形成了对角线则不合法
                    flag = false;
                    break;
                }
            }

            //如果合法就放进棋盘
            if(flag == true) {
                P[index] = x;
                hashTable[x] = true;
                generateP(index + 1);
                hashTable[x] = false;
            }
        }
    }
}

int main() {
    n = 8;
    generateP(1);//从1开始枚举
    cout << num;
    return 0;
}
