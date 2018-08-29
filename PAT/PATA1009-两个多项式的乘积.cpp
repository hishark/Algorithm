/**
1009 Product of Polynomials (25)（25 分）
This time, you are supposed to find A*B where A and B are two polynomials.

Input Specification:

Each input file contains one test case. Each case occupies 2 lines, and each line contains the information of a polynomial: K N1 a~N1~ N2 a~N2~ ... NK a~NK~, where K is the number of nonzero terms in the polynomial, Ni and a~Ni~ (i=1, 2, ..., K) are the exponents and coefficients, respectively. It is given that 1 <= K <= 10, 0 <= NK < ... < N2 < N1 <=1000.

Output Specification:

For each test case you should output the product of A and B in one line, with the same format as the input. Notice that there must be NO extra space at the end of each line. Please be accurate up to 1 decimal place.

Sample Input

2 1 2.4 0 3.2
2 2 1.5 1 0.5
Sample Output

3 3 3.6 2 6.0 1 1.6
**/
#include<stdio.h>
#include<iostream>
using namespace std;
int main(){
    double a[1001]={0},result[2001]={0};
    int N1;
    cin>>N1;
    while(N1--){
        int e;
        double k;
        cin>>e>>k;
        a[e] = k;
    }

    int N2;
    cin>>N2;

    while(N2--){
        int e;
        double k;
        //e是幂 k是系数
        cin>>e>>k;
        for(int i=0;i<=1000;i++){
            result[e+i] += k*a[i];
        }
    }
    int count = 0;
    for(int i=2000;i>=0;i--){
        if(result[i]!=0){
            count++;
        }
    }

    cout<<count;
    for(int i=2000;i>=0;i--){
        if(result[i]!=0){
            cout<<" "<<i<<" ";
            printf("%.1f",result[i]);
        }
    }
    return 0;
}
