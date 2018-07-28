/**
1019 General Palindromic Number (20)£¨20 ·Ö£©ÌáÎÊ
A number that will be the same when it is written forwards or backwards is known as a Palindromic Number. For example, 1234321 is a palindromic number. All single digit numbers are palindromic numbers.

Although palindromic numbers are most often considered in the decimal system, the concept of palindromicity can be applied to the natural numbers in any numeral system. Consider a number N > 0 in base b >= 2, where it is written in standard notation with k+1 digits a~i~ as the sum of (a~i~b^i^) for i from 0 to k. Here, as usual, 0 <= a~i~ < b for all i and a~k~ is non-zero. Then N is palindromic if and only if a~i~ = a~k-i~ for all i. Zero is written 0 in any base and is also palindromic by definition.

Given any non-negative decimal integer N and a base b, you are supposed to tell if N is a palindromic number in base b.

Input Specification:

Each input file contains one test case. Each case consists of two non-negative numbers N and b, where 0 <= N <= 10^9^ is the decimal number and 2 <= b <= 10^9^ is the base. The numbers are separated by a space.

Output Specification:

For each test case, first print in one line "Yes" if N is a palindromic number in base b, or "No" if not. Then in the next line, print N as the number in base b in the form "a~k~ a~k-1~ ... a~0~". Notice that there must be no extra space at the end of output.

Sample Input 1:

27 2
Sample Output 1:

Yes
1 1 0 1 1
Sample Input 2:

121 5
Sample Output 2:

No
4 4 1
**/
#include<stdio.h>
#include<iostream>
using namespace std;
int main(){
    int N,D;
    cin>>N>>D;
    int z[40],num=0;

    //十进制转D进制模板do while
    do{
        z[num] = N%D;
        N = N/D;
        num++;
    }while(N!=0);

    bool flag = true;

    //判断是否回文
    for(int i=0;i<num/2;i++){
        if(z[i]==z[num-1-i]){
            continue;
        }else{
            flag = false;
            break;
        }
    }

    if(flag){
        cout<<"Yes"<<endl;
        for(int i=0;i<num;i++){
            if(i==0){
                cout<<z[i];
            }else{
                cout<<" "<<z[i];
            }
        }
    }else{
        cout<<"No"<<endl;
        for(int i=num-1;i>=0;i--){
            if(i==num-1){
                cout<<z[i];
            }else{
                cout<<" "<<z[i];
            }
        }
    }

    return 0;
}

