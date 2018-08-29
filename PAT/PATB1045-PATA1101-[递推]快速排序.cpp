/**
1045 快速排序（25 分）
著名的快速排序算法里有一个经典的划分过程：我们通常采用某种方法取一个元素作为主元，通过交换，把比主元小的元素放到它的左边，比主元大的元素放到它的右边。 给定划分后的 N 个互不相同的正整数的排列，请问有多少个元素可能是划分前选取的主元？

例如给定 $N = 5$, 排列是1、3、2、4、5。则：

1 的左边没有元素，右边的元素都比它大，所以它可能是主元；
尽管 3 的左边元素都比它小，但其右边的 2 比它小，所以它不能是主元；
尽管 2 的右边元素都比它大，但其左边的 3 比它大，所以它不能是主元；
类似原因，4 和 5 都可能是主元。
因此，有 3 个元素可能是主元。

输入格式：
输入在第 1 行中给出一个正整数 N（≤10
​5
​​ ）； 第 2 行是空格分隔的 N 个不同的正整数，每个数不超过 10
​9
​​ 。

输出格式：
在第 1 行中输出有可能是主元的元素个数；在第 2 行中按递增顺序输出这些元素，其间以 1 个空格分隔，行首尾不得有多余空格。

输入样例：
5
1 3 2 4 5
输出样例：
3
1 4 5
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
const int MAXN = 100010;
const int INF = 0x3fffffff;
int main(){
    int N;
    cin>>N;
    int a[N];
    for(int i=0;i<N;i++){
        cin>>a[i];
    }
    //num是主元的个数，ans存下所有主元
    int ans[MAXN],num=0;

    //leftMax存当前位左边最大值，rightMin存当前位右边最小值
    int leftMax[MAXN],rightMin[MAXN];
    //先初始化左边
    leftMax[0] = 0;//第一个数的左边没有比他大的数
    for(int i=1;i<N;i++){
        leftMax[i] = max(leftMax[i-1],a[i-1]);
    }
    //初始化右边
    rightMin[N-1] = INF;//最后一个数的右边没有比他小的数
    for(int i=N-2;i>=0;i--){
        rightMin[i] = min(rightMin[i+1],a[i+1]);
    }

    //只要leftMax比当前位还小，rightMin比当前位还大，那么当前位就是主元
    for(int i=0;i<N;i++){
        if(leftMax[i]<a[i]&&rightMin[i]>a[i]){
            ans[num] = a[i];
            num++;
        }
    }

    sort(ans,ans+num);
    cout<<num<<endl;
    for(int i=0;i<num;i++){
        if(i==0){
            cout<<ans[i];
        }else{
            cout<<" "<<ans[i];
        }
    }

    cout<<endl;
    return 0;
}

