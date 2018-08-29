#include<stdio.h>
#include<iostream>
using namespace std;
/**
1032 挖掘机技术哪家强(20)（20 分）
为了用事实说明挖掘机技术到底哪家强，PAT组织了一场挖掘机技能大赛。现请你根据比赛结果统计出技术最强的那个学校。

输入格式：

输入在第1行给出不超过10^5^的正整数N，即参赛人数。随后N行，每行给出一位参赛者的信息和成绩，包括其所代表的学校的编号（从1开始连续编号）、及其比赛成绩（百分制），中间以空格分隔。

输出格式：

在一行中给出总得分最高的学校的编号、及其总分，中间以空格分隔。题目保证答案唯一，没有并列。

输入样例：

6
3 65
2 80
1 100
2 70
3 40
3 0
输出样例：

2 150
**/
int main(){
    int n;
    cin>>n;
    int score[n+1]={0};
    for(int i=0;i<n;i++){
        int id;
        cin>>id;
        int perScore;
        cin>>perScore;
        score[id]+=perScore;
    }

    int maxScore = score[1];
    int flag = -1;
    /**
        i一定要从1开始，不要因为上面max初始值为score[1]就忽视1
        如果最大值是score[1]的话flag就为-1啊智障
        （要么就将flag初始值设置为1，那下面的i从2开始也没关系，嘛反正是小问题，注意一下就好了）
    **/
    for(int i=1;i<=n;i++){
        if(score[i]>=maxScore){
            maxScore = score[i];
            flag = i;
        }
    }

    cout<<flag<<" "<<score[flag];

    return 0;
}
