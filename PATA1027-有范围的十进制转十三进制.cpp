/**
1027 Colors in Mars (20)��20 �֣�����
People in Mars represent the colors in their computers in a similar way as the Earth people. That is, a color is represented by a 6-digit number, where the first 2 digits are for Red, the middle 2 digits for Green, and the last 2 digits for Blue. The only difference is that they use radix 13 (0-9 and A-C) instead of 16. Now given a color in three decimal numbers (each between 0 and 168), you are supposed to output their Mars RGB values.

Input

Each input file contains one test case which occupies a line containing the three decimal color values.

Output

For each test case you should output the Mars RGB value in the following format: first output "#", then followed by a 6-digit number where all the English characters must be upper-cased. If a single color is only 1-digit long, you must print a "0" to the left.

Sample Input

15 43 71
Sample Output

#123456
**/
#include<stdio.h>
#include<iostream>
using namespace std;
int main(){
    //ʮ�����з�Χ�Ļ��Ϳ��Լ�תʮ�����Ƶķ�ʽ���������෨��
    //x=a*13^1+b*13^0 ���a��b����
    //��ʽ���Ҷ�/13 �õ�x/13=a ��ʽ���Ҷ�%13 �õ�x%13=b
    //��������ʽ�Ӽ���ֱ�����
    char radix[13]={'0','1','2','3','4','5','6','7','8','9','A','B','C'};
    int r,g,b;
    cin>>r>>g>>b;
    cout<<"#";
    cout<<radix[r/13]<<radix[r%13];
    cout<<radix[g/13]<<radix[g%13];
    cout<<radix[b/13]<<radix[b%13];
    return 0;
}
