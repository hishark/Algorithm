/**
1067 Sort with Swap(0,*) (25)（25 分）
Given any permutation of the numbers {0, 1, 2,..., N-1}, it is easy to sort them in increasing order. But what if Swap(0, *) is the ONLY operation that is allowed to use? For example, to sort {4, 0, 2, 1, 3} we may apply the swap operations in the following way:

Swap(0, 1) => {4, 1, 2, 0, 3}\ Swap(0, 3) => {4, 1, 2, 3, 0}\ Swap(0, 4) => {0, 1, 2, 3, 4}

Now you are asked to find the minimum number of swaps need to sort the given permutation of the first N nonnegative integers.

Input Specification:

Each input file contains one test case, which gives a positive N (<=10^5^) followed by a permutation sequence of {0, 1, ..., N-1}. All the numbers in a line are separated by a space.

Output Specification:

For each case, simply print in a line the minimum number of swaps need to sort the given permutation.

Sample Input:

10 3 5 7 2 6 4 9 0 8 1
Sample Output:

9
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){
    int n;
    cin>>n;
    int position[n];//position[x]表示x所处的位置（0~9）
    int left = n-1;//left表示除0以外错位的数字
    for(int i=0;i<n;i++){
        int num;
        cin>>num;
        position[num] = i;//记下初始状况下每个数字所处的位置

        //输入数据时统计left的情况
        if(position[num]==num){
            left--;
        }
    }

    int k=1;//k用来记录除0以外不在本位的最小的一个数字，初始为1
    int ans = 0;
    //存在错位的数字时就继续
    while(left>0){
        //如果0在0位时
        if(position[0]==0){
                //找到一个不在本位上的数，令其与0交换
                while(k<n){
                    if(position[k]!=k){
                        swap(position[0],position[k]);//将k与0交换位置
                        ans++;
                        break;
                    }
                    k++;
                }
        }
        //如果0不在0位 就直接交换
        while(position[0]!=0){
            swap(position[0],position[position[0]]);
            ans++;
            left--;
        }
    }
    cout<<ans<<endl;
    return 0;
}
