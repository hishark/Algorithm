/**
1030 完美数列(25)（25 分）
给定一个正整数数列，和正整数p，设这个数列中的最大值是M，最小值是m，如果M <= m * p，则称这个数列是完美数列。

现在给定参数p和一些正整数，请你从中选择尽可能多的数构成一个完美数列。

输入格式：

输入第一行给出两个正整数N和p，其中N（<= 10^5^）是输入的正整数的个数，p（<= 10^9^）是给定的参数。第二行给出N个正整数，每个数不超过10^9^。

输出格式：

在一行中输出最多可以选择多少个数可以用它们组成一个完美数列。

输入样例：

10 8
2 3 20 4 5 1 6 7 8 9
输出样例：

8
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){
    int n,p;
    cin>>n>>p;
    int a[n];
    for(int i=0;i<n;i++){
        cin>>a[i];
    }

    //从小到大排序
    sort(a,a+n);

    int ans = 1;//表示数列最多可以选择的个数
    for(int i=0;i<n;i++){
        //对每一个a[i]，找到a[i+1]~a[n-1]之间的某个数，使其大于a[i]*p，得到其下标j
        //upperbound返回该范围内第一个值大于a[i]*p的指针，减去数组首地址就是下标啦
        int j = upper_bound(a+i+1,a+n,(long long)a[i]*p) - a;
        ans = max(ans,j-i);
    }
    cout<<ans;
    return 0;
}

