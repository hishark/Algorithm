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
//���ӽṹ��
struct Fraction {
    ll up, down; //���Ӻͷ�ĸ
};
//�����Լ��
ll gcd(ll a, ll b) {
    return b == 0 ? a : gcd(b, a % b);
}
//����
Fraction reduction(Fraction x) {
    //�����ĸΪ���������Ӻͷ�ĸ����Ϊ�෴��
    if(x.down < 0) {
        x.up = -x.up;
        x.down = -x.down;
    }
    //�������Ϊ0���÷�ĸΪ1
    if(x.up == 0) {
        x.down = 1;
    } else {
        //������Ӳ�Ϊ0���������Ľ���Լ��
        ll d = gcd(abs(x.up), abs(x.down)); //������Լ��
        x.up /= d;
        x.down /= d;
    }
    return x;
}
//�����ļӷ�
Fraction add(Fraction a, Fraction b) {
    Fraction result;
    result.up = a.up * b.down + b.up * a.down;
    result.down = a.down * b.down;
    result = reduction(result);
    return result;
}
//��Ҫ��������� 1.��ĸΪ1ʱֱ��������� 2.�����ֱ����� 3.�ٷ���Ҫ��������ӷ���
void showFraction(Fraction x) {
    //����
    if(x.down == 1) {
        cout << x.up << endl;
    } else {
        /*�ٷ���
        *����Ҫע�����ֵ������
        */
        if(abs(x.up) > x.down) {
            cout << x.up / x.down << " " << abs(x.up) % x.down << "/" << x.down << endl;
        } else {
            //�����
            cout << x.up << "/" << x.down << endl;
        }
    }

}
int main() {
    int n;
    cin >> n;
    Fraction ans, temp;
    //�ǵ�Ҫlld дd�ʹ���
    scanf("%lld/%lld", &ans.up, &ans.down);
    for(int i = 0; i < n - 1; i++) {
        scanf("%lld/%lld", &temp.up, &temp.down);
        ans = add(ans, temp);
    }
    showFraction(ans);
    return 0;
}

