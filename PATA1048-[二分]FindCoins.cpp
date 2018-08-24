/**
1048 Find Coins (25)（25 分）
Eva loves to collect coins from all over the universe, including some other planets like Mars. One day she visited a universal shopping mall which could accept all kinds of coins as payments. However, there was a special requirement of the payment: for each bill, she could only use exactly two coins to pay the exact amount. Since she has as many as 10^5^ coins with her, she definitely needs your help. You are supposed to tell her, for any given amount of money, whether or not she can find two coins to pay for it.

Input Specification:

Each input file contains one test case. For each case, the first line contains 2 positive numbers: N (<=10^5^, the total number of coins) and M(<=10^3^, the amount of money Eva has to pay). The second line contains N face values of the coins, which are all positive numbers no more than 500. All the numbers in a line are separated by a space.

Output Specification:

For each test case, print in one line the two face values V~1~ and V~2~ (separated by a space) such that V~1~ + V~2~ = M and V~1~ <= V~2~. If such a solution is not unique, output the one with the smallest V~1~. If there is no solution, output "No Solution" instead.

Sample Input 1:

8 15
1 2 8 7 2 4 11 15
Sample Output 1:

4 11
Sample Input 2:

7 14
1 8 7 2 4 11 15
Sample Output 2:

No Solution
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int a[100010];
int binarySearch(int left,int right,int key){
    int mid;
    while(left<=right){
        mid = (left+right)/2;
        if(a[mid]==key){
            return mid;
        }else if(a[mid]>key){
            right = mid -1;
        }else{
            left = mid + 1;
        }
    }
    return -1;//如果没有找到key，则返回-1，别忘记这个了
}
int main(){
    int n,sum;
    bool isFirst = true;
    cin>>n>>sum;
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    //对a数组进行从小到大的排序
    sort(a,a+n);
    //遍历a数组，对每一个a[i]，用二分查找的方法确定数组中是否存在sum-a[i]
    int i;
    for(i=0;i<n;i++){
        int position;
        position = binarySearch(0,n-1,sum-a[i]);
        if(position!=-1&&i!=position){
            //找到了，因为已经从小到大排序过了，所以找到的肯定是最小的，所以直接输出然后break
            cout<<a[i]<<" "<<a[position];
            break;
        }
    }

    //遍历了整个数组都没有找到
    if(i==n){
        cout<<"No Solution"<<endl;
    }
    return 0;
}
