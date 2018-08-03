/**
1058 A+B in Hogwarts (20)（20 分）
If you are a fan of Harry Potter, you would know the world of magic has its own currency system -- as Hagrid explained it to Harry, "Seventeen silver Sickles to a Galleon and twenty-nine Knuts to a Sickle, it's easy enough." Your job is to write a program to compute A+B where A and B are given in the standard form of "Galleon.Sickle.Knut" (Galleon is an integer in [0, 10^7^], Sickle is an integer in [0, 17), and Knut is an integer in [0, 29)).

Input Specification:

Each input file contains one test case which occupies a line with A and B in the standard form, separated by one space.

Output Specification:

For each test case you should output the sum of A and B in one line, with the same format as the input.

Sample Input:

3.2.1 10.16.27
Sample Output:

14.1.28
**/
#include<stdio.h>
#include<iostream>
using namespace std;
int main() {
    int a[3] = {0}, b[3] = {0}, c[3] = {0};

    scanf("%d.%d.%d", &a[0], &a[1], &a[2]);
    scanf("%d.%d.%d", &b[0], &b[1], &b[2]);

    int carry = 0;

    //2号位的计算
    c[2] = (a[2] + b[2] + carry) % 29;
    carry = (a[2] + b[2] + carry) / 29;

    //1号位的计算
    c[1] = (a[1]+b[1]+carry)%17;
    carry = (a[1]+b[1]+carry)/17;

    //0号位的计算
    c[0] = a[0]+b[0]+carry;

    cout<<c[0]<<"."<<c[1]<<"."<<c[2]<<endl;


    return 0;
}
