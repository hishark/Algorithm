/**
1031 Hello World for U (20)（20 分）提问
Given any string of N (>=5) characters, you are asked to form the characters into the shape of U. For example, "helloworld" can be printed as:

h  d
e  l
l  r
lowo
That is, the characters must be printed in the original order, starting top-down from the left vertical line with n~1~ characters, then left to right along the bottom line with n~2~ characters, and finally bottom-up along the vertical line with n~3~ characters. And more, we would like U to be as squared as possible -- that is, it must be satisfied that n~1~ = n~3~ = max { k| k <= n~2~ for all 3 <= n~2~ <= N } with n~1~

n~2~ + n~3~ - 2 = N.
Input Specification:

Each input file contains one test case. Each case contains one string with no less than 5 and no more than 80 characters in a line. The string contains no white space.

Output Specification:

For each test case, print the input string in the shape of U as specified in the description.

Sample Input:

helloworld!
Sample Output:

h   !
e   d
l   l
lowor
**/
#include<stdio.h>
#include<iostream>
#include<string>
using namespace std;
int main() {
    int leftSide, bottomSide, rightSide, N;
    string input;
    cin >> input;
    N = input.length();

    for(bottomSide = 0; bottomSide <=N; bottomSide++) {
        if((N + 2 - bottomSide) % 2 == 0) {
            //枚举找到了满足条件的底边长
            leftSide = rightSide = (N + 2 - bottomSide) / 2;
            if(bottomSide >= leftSide)
                break;
        }
    }

    char result[80][80];
    for(int i = 0; i < 80; i++) {
        for(int j = 0; j < 80; j++) {
            result[i][j] = ' ';
        }
    }
    int position = 0;

    //左边
    for(int i = 0; i < leftSide; i++) {
        result[i][0] = input[position];
        position++;
    }

    //底边
    for(int i = 1; i < bottomSide; i++) {
        result[leftSide - 1][i] = input[position];
        position++;
    }

    //右边
    for(int i = leftSide-2;i>=0;i--){
        result[i][bottomSide-1] = input[position];
        position++;
    }

    //输出二维数组
    for(int i = 0; i < leftSide; i++) {
        for(int j = 0; j < bottomSide; j++) {
            cout<<result[i][j];
        }
        cout<<endl;
    }

    return 0;
}

