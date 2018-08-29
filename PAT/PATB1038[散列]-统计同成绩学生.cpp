/**
1038 统计同成绩学生(20)（20 分）
本题要求读入N名学生的成绩，将获得某一给定分数的学生人数输出。

输入格式：

输入在第1行给出不超过10^5^的正整数N，即学生总人数。随后1行给出N名学生的百分制整数成绩，中间以空格分隔。最后1行给出要查询的分数个数K（不超过N的正整数），随后是K个分数，中间以空格分隔。

输出格式：

在一行中按查询顺序给出得分等于指定分数的学生人数，中间以空格分隔，但行末不得有多余空格。

输入样例：

10
60 75 90 55 75 99 82 90 75 50
3 75 90 88
输出样例：

3 2 0
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){
    int N;
    //用cincout会超时
    scanf("%d",&N);
    int hashTable[110]={0};
    while(N--){
        int score;
        scanf("%d",&score);
        hashTable[score]++;
    }
    int S;
    scanf("%d",&S);
    bool isFirst = true;
    while(S--){
        int search;
        scanf("%d",&search);
        if(isFirst){
            printf("%d",hashTable[search]);
            isFirst = false;
        }else{
            printf(" %d",hashTable[search]);
        }
    }
    return 0;
}
