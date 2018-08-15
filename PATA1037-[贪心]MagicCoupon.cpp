/**
1037 Magic Coupon (25)（25 分）
The magic shop in Mars is offering some magic coupons. Each coupon has an integer N printed on it, meaning that when you use this coupon with a product, you may get N times the value of that product back! What is more, the shop also offers some bonus product for free. However, if you apply a coupon with a positive N to this bonus product, you will have to pay the shop N times the value of the bonus product... but hey, magically, they have some coupons with negative N's!

For example, given a set of coupons {1 2 4 -1}, and a set of product values {7 6 -2 -3} (in Mars dollars M\$) where a negative value corresponds to a bonus product. You can apply coupon 3 (with N being 4) to product 1 (with value M\$7) to get M\$28 back; coupon 2 to product 2 to get M\$12 back; and coupon 4 to product 4 to get M\$3 back. On the other hand, if you apply coupon 3 to product 4, you will have to pay M\$12 to the shop.

Each coupon and each product may be selected at most once. Your task is to get as much money back as possible.

Input Specification:

Each input file contains one test case. For each case, the first line contains the number of coupons NC, followed by a line with NC coupon integers. Then the next line contains the number of products NP, followed by a line with NP product values. Here 1<= NC, NP <= 10^5^, and it is guaranteed that all the numbers will not exceed 2^30^.

Output Specification:

For each test case, simply print in a line the maximum amount of money you can get back.

Sample Input:

4
1 2 4 -1
4
7 6 -2 -3
Sample Output:

43
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
const int maxn = 100010;
int main() {
    int n, m;
    int a[maxn], b[maxn];

    //initialize
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
    cin >> m;
    for(int i = 0; i < m; i++) {
        cin >> b[i];
    }

    //sort from small to large
    sort(a, a + n);
    sort(b, b + m);

    //output i是a数组下标 j是b数组下标 ans是乘积之和
    int i = 0, j, ans = 0;
    while(i < n && i < m && a[i] < 0 && b[i] < 0) {
        ans += a[i] * b[i];
        i++;
    }
    //i和j移向数组的最后一项
    i = n - 1;
    j = m - 1;
    while(i >= 0 && j >= 0 && a[i] > 0 && b[j] > 0) {
        ans += a[i] * b[j];
        i--;
        j--;
    }
    cout << ans << endl;
    return 0;
}

