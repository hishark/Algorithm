/**
1039 Course List for Student（25 分）
Zhejiang University has 40000 students and provides 2500 courses. Now given the student name lists of all the courses, you are supposed to output the registered course list for each student who comes for a query.

Input Specification:
Each input file contains one test case. For each case, the first line contains 2 positive integers: N (≤40,000), the number of students who look for their course lists, and K (≤2,500), the total number of courses. Then the student name lists are given for the courses (numbered from 1 to K) in the following format: for each course i, first the course index i and the number of registered students N
​i
​​  (≤200) are given in a line. Then in the next line, N
​i
​​  student names are given. A student name consists of 3 capital English letters plus a one-digit number. Finally the last line contains the N names of students who come for a query. All the names and numbers in a line are separated by a space.

Output Specification:
For each test case, print your results in N lines. Each line corresponds to one student, in the following format: first print the student's name, then the total number of registered courses of that student, and finally the indices of the courses in increasing order. The query results must be printed in the same order as input. All the data in a line must be separated by a space, with no extra space at the end of the line.

Sample Input:
11 5
4 7
BOB5 DON2 FRA8 JAY9 KAT3 LOR6 ZOE1
1 4
ANN0 BOB5 JAY9 LOR6
2 7
ANN0 BOB5 FRA8 JAY9 JOE4 KAT3 LOR6
3 1
BOB5
5 9
AMY7 ANN0 BOB5 DON2 FRA8 JAY9 KAT3 LOR6 ZOE1
ZOE1 ANN0 BOB5 JOE4 JAY9 FRA8 DON2 AMY7 KAT3 LOR6 NON9
Sample Output:
ZOE1 2 4 5
ANN0 3 1 2 5
BOB5 5 1 2 3 4 5
JOE4 1 2
JAY9 4 1 2 4 5
FRA8 3 2 4 5
DON2 2 4 5
AMY7 1 5
KAT3 3 2 4 5
LOR6 4 1 2 4 5
NON9 0
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
#include<math.h>
#include<vector>
using namespace std;
const int maxn = 26*26*26*10+1;
vector<int> selectedCourse[maxn];
int getID(char  name[]){
    int ans = 0;
    for(int i=0;i<3;i++){
        ans = ans*26 + (name[i]-'A');
    }
    ans  = ans*10 + name[3];
    return ans;
}
int main(){
    int stuNum,courseNum;
    cin>>stuNum>>courseNum;
    for(int i=0;i<courseNum;i++){
        int cno,student;
        cin>>cno>>student;
        for(int i=0;i<student;i++){
            int stuid;
            char name[5];//名字的格式都是ABC1
            scanf("%s",name);
            stuid = getID(name);
            selectedCourse[stuid].push_back(cno);
        }
    }
    //search
    for(int i=0;i<stuNum;i++){
        char searchStu[5];
        scanf("%s",searchStu);
        int stuid = getID(searchStu);
        //课程号从小到大递增排序
        sort(selectedCourse[stuid].begin(),selectedCourse[stuid].end());
        cout<<searchStu<<" "<<selectedCourse[stuid].size();
        for(int j=0;j<selectedCourse[stuid].size();j++){
            cout<<" "<<selectedCourse[stuid][j];
        }
        cout<<endl;
    }
    return 0;
}

