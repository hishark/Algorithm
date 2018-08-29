/**
1012 The Best Rank (25)（25 分）
To evaluate the performance of our first year CS majored students, we consider their grades of three courses only: C - C Programming Language, M - Mathematics (Calculus or Linear Algebra), and E - English. At the mean time, we encourage students by emphasizing on their best ranks -- that is, among the four ranks with respect to the three courses and the average grade, we print the best rank for each student.

For example, The grades of C, M, E and A - Average of 4 students are given as the following:

StudentID  C  M  E  A
310101     98 85 88 90
310102     70 95 88 84
310103     82 87 94 88
310104     91 91 91 91
Then the best ranks for all the students are No.1 since the 1st one has done the best in C Programming Language, while the 2nd one in Mathematics, the 3rd one in English, and the last one in average.

Input

Each input file contains one test case. Each case starts with a line containing 2 numbers N and M (<=2000), which are the total number of students, and the number of students who would check their ranks, respectively. Then N lines follow, each contains a student ID which is a string of 6 digits, followed by the three integer grades (in the range of [0, 100]) of that student in the order of C, M and E. Then there are M lines, each containing a student ID.

Output

For each of the M students, print in one line the best rank for him/her, and the symbol of the corresponding rank, separated by a space.

The priorities of the ranking methods are ordered as A > C > M > E. Hence if there are two or more ways for a student to obtain the same best rank, output the one with the highest priority.

If a student is not on the grading list, simply output "N/A".

Sample Input

5 6
310101 98 85 88
310102 70 95 88
310103 82 87 94
310104 91 91 91
310105 85 90 90
310101
310102
310103
310104
310105
999999
Sample Output

1 C
1 M
1 E
1 A
3 A
N/A
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

//学生结构体
struct student{
    int id;
    int grade[4];//A,C,M,E
}stu[2010];

//按优先级排好序
char course[4]={'A','C','M','E'};

//当前正在比较的课程号
int now;

int Rank[1000000][4]={0};//Rank[id][now]表示学生号为id的学生now号课程的排名

//从高到低排序
bool cmp(student a,student b){
    return a.grade[now]>b.grade[now];
}


int main(){
    int n,m;
    cin>>n>>m;
    for(int i=0;i<n;i++){
        //输入id为i的学生的C,M,E三门课程的成绩，注意下标
        cin>>stu[i].id>>stu[i].grade[1]>>stu[i].grade[2]>>stu[i].grade[3];
        //计算A 省的管四舍五入 直接算总分哈哈哈哈哈哈
        stu[i].grade[0] = stu[i].grade[1] + stu[i].grade[2] + stu[i].grade[3];
    }

    //开始排序啦
    for(now=0;now<4;now++){
        sort(stu,stu+n,cmp);
        //排序完成后将第一名学生的now号课程的排名设置为1
        Rank[stu[0].id][now] = 1;
        //然后再给接下来的学生设置排名
        for(int i=1;i<n;i++){
            //判断一下分数是否相同
            if(stu[i].grade[now]==stu[i-1].grade[now]){
                //相同的话排名也相同
                Rank[stu[i].id][now] = Rank[stu[i-1].id][now];
            }else{
                //不同的话排名就是前面的人数+1
                Rank[stu[i].id][now] = i+1;
            }
        }
    }

    //排名设置好了之后就可以开始查询了
    for(int i=0;i<m;i++){
        int queryId;
        cin>>queryId;
        //先判断不存在的情况
        if(Rank[queryId][0]==0){
            cout<<"N/A"<<endl;
        }else{
            //存在的话，就来找出Rank[queryId][course]里最小的那个（数字最小表示排名最高）
            int position = 0;
            int min = 5;
            for(int j=0;j<4;j++){
                if(Rank[queryId][j]<min){
                    position = j;
                    min = Rank[queryId][j];
                }
            }
            cout<<min<<" "<<course[position]<<endl;
        }

    }
    return 0;
}
