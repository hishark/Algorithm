/**
1001 A+B Format (20)£¨20 ·Ö£©
Calculate a + b and output the sum in standard format -- that is, the digits must be separated into groups of three by commas (unless there are less than four digits).

Input

Each input file contains one test case. Each case contains a pair of integers a and b where -1000000 <= a, b <= 1000000. The numbers are separated by a space.

Output

For each test case, you should output the sum of a and b in one line. The sum must be written in the standard format.

Sample Input

-1000000 9
Sample Output

-999,991
**/
#include<stdio.h>
#include<iostream>
using namespace std;
int main(){
    int a,b,sum;
    cin>>a>>b;
    sum = a + b;
    int ans[10];
    if(sum<0){
        cout<<"-";
        sum = -sum;
    }

    int len = 0;
    do{
        ans[len] = sum%10;
        sum/=10;
        len++;
    }while(sum!=0);

    for(int i=len-1;i>=0;i--){
        cout<<ans[i];
        if(i!=0&&i%3==0){
            cout<<",";
        }
    }
    return 0;
}

