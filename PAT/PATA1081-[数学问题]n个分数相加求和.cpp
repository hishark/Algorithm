/**
Sample Input 1:
5
2/5 4/15 1/30 -2/60 8/3
Sample Output 1:
3 1/3
Sample Input 2:
2
4/3 2/3
Sample Output 2:
2
Sample Input 3:
3
1/3 -1/6 1/8
Sample Output 3:
7/24
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
typedef long long ll;
//分子结构体
struct Fraction {
    ll up, down; //分子和分母
};
//求最大公约数
ll gcd(ll a, ll b) {
    return b == 0 ? a : gcd(b, a % b);
}
//化简
Fraction reduction(Fraction x) {
    //如果分母为负数，分子和分母都变为相反数
    if(x.down < 0) {
        x.up = -x.up;
        x.down = -x.down;
    }
    //如果分子为0，让分母为1
    if(x.up == 0) {
        x.down = 1;
    } else {
        //如果分子不为0，就正常的进行约分
        ll d = gcd(abs(x.up), abs(x.down)); //求出最大公约数
        x.up /= d;
        x.down /= d;
    }
    return x;
}
//分数的加法
Fraction add(Fraction a, Fraction b) {
    Fraction result;
    result.up = a.up * b.down + b.up * a.down;
    result.down = a.down * b.down;
    result = reduction(result);
    return result;
}
//按要求输出分数 1.分母为1时直接输出整数 2.真分数直接输出 3.假分数要输出整数加分数
void showFraction(Fraction x) {
    //整数
    if(x.down == 1) {
        cout << x.up << endl;
    } else {
        /*假分数
        *这里要注意绝对值的问题
        */
        if(abs(x.up) > x.down) {
            cout << x.up / x.down << " " << abs(x.up) % x.down << "/" << x.down << endl;
        } else {
            //真分数
            cout << x.up << "/" << x.down << endl;
        }
    }

}
int main() {
    int n;
    cin >> n;
    Fraction ans, temp;
    //记得要lld 写d就错啦
    scanf("%lld/%lld", &ans.up, &ans.down);
    for(int i = 0; i < n - 1; i++) {
        scanf("%lld/%lld", &temp.up, &temp.down);
        ans = add(ans, temp);
    }
    showFraction(ans);
    return 0;
}

