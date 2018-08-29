/**
1046 Shortest Distance (20)（20 分）提问
The task is really simple: given N exits on a highway which forms a simple cycle, you are supposed to tell the shortest distance between any pair of exits.

Input Specification:

Each input file contains one test case. For each case, the first line contains an integer N (in [3, 10^5^]), followed by N integer distances D~1~ D~2~ ... D~N~, where D~i~ is the distance between the i-th and the (i+1)-st exits, and D~N~ is between the N-th and the 1st exits. All the numbers in a line are separated by a space. The second line gives a positive integer M (<=10^4^), with M lines follow, each contains a pair of exit numbers, provided that the exits are numbered from 1 to N. It is guaranteed that the total round trip distance is no more than 10^7^.

Output Specification:

For each test case, print your results in M lines, each contains the shortest distance between the corresponding given pair of exits.

Sample Input:

5 1 2 4 14 9
3
1 3
2 5
4 1
Sample Output:

3
10
7
**/
#include<stdio.h>
#include<iostream>
using namespace std;
/**
    哇一定要注意范围，如果不定义这个MAXN的话会答案错误
    如果粗心写成10001会出现段错误，总之一定要按照题给条件限制范围
**/
const int MAXN = 100001;
int dis[MAXN];
int main() {
    int K;
    int sum = 0;
    cin >> K;
    //数组预处理
    for(int i = 1; i <= K; i++) {
        int distance;
        cin >> distance;
        dis[i] = sum + distance;
        sum += distance;
    }

    int N;
    cin >> N;
    while(N--) {
        int start, end;
        cin >> start;
        cin >> end;
        //start不一定比end小哦记得换位子
        if(start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        int minDis = dis[end - 1] - dis[start - 1];
        if(sum - minDis < minDis) {
            minDis = sum - minDis;
        }
        cout << minDis << endl;
    }

    return 0;
}
//TIME: 00:07:14
