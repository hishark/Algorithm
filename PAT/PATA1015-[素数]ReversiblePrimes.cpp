/**
1015 Reversible Primes（20 分）
A reversible prime in any number system is a prime whose "reverse" in that number system is also a prime. For example in the decimal system 73 is a reversible prime because its reverse 37 is also a prime.

Now given any two positive integers N (<10
​5
​​ ) and D (1<D≤10), you are supposed to tell if N is a reversible prime with radix D.

Input Specification:
The input file consists of several test cases. Each case occupies a line which contains two integers N and D. The input is finished by a negative N.

Output Specification:
For each test case, print in one line Yes if N is a reversible prime with radix D, or No if not.

Sample Input:
73 10
23 2
23 10
-2
Sample Output:
Yes
Yes
No
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
#include<math.h>
using namespace std;
bool isPrime(int n) {
    if(n <= 1)
        return false;
    int sqr = (int)sqrt(1.0 * n);
    for(int i = 2; i <= sqr; i++) {
        if(n % i == 0) {
            return false;
        }
    }
    return true;
}
int main() {
    int n, radix;
    while(scanf("%d", &n) != EOF) {
        if(n < 0)
            break;
        scanf("%d", &radix);
        //判断n是不是素数，不是素数的话直接输出no，是的话才进行下一步
        if(isPrime(n) == false) {
            cout << "No" << endl;
        } else {
            int d[123];//此数组用来存转进制后的每一位（逆序，正好符合要求）
            //转换进制
            int num = 0;
            do {
                d[num] = n % radix;
                n /= radix;
                num++;
            } while(n != 0);

            //判断十进制数是否是素数，是的话就输出yes
            int ans=0;
            for(int i=0;i<num;i++){
                ans = ans*radix + d[i];
            }
            if(isPrime(ans)){
                cout<<"Yes"<<endl;
            }else{
                cout<<"No"<<endl;
            }
        }
    }
    return 0;
}

