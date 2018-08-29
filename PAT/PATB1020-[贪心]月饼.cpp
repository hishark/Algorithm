/**
1020 月饼 (25)（25 分）
月饼是中国人在中秋佳节时吃的一种传统食品，不同地区有许多不同风味的月饼。现给定所有种类月饼的库存量、总售价、以及市场的最大需求量，请你计算可以获得的最大收益是多少。

注意：销售时允许取出一部分库存。样例给出的情形是这样的：假如我们有3种月饼，其库存量分别为18、15、10万吨，总售价分别为75、72、45亿元。如果市场的最大需求量只有20万吨，那么我们最大收益策略应该是卖出全部15万吨第2种月饼、以及5万吨第3种月饼，获得 72 + 45/2 = 94.5（亿元）。

输入格式：

每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N表示月饼的种类数、以及不超过500（以万吨为单位）的正整数D表示市场最大需求量。随后一行给出N个正数表示每种月饼的库存量（以万吨为单位）；最后一行给出N个正数表示每种月饼的总售价（以亿元为单位）。数字间以空格分隔。

输出格式：

对每组测试用例，在一行中输出最大收益，以亿元为单位并精确到小数点后2位。

输入样例：

3 20
18 15 10
75 72 45
输出样例：

94.50
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
struct mooncake{
    double stock;//库存量
    double price;//总售价
    double unitPrice;//单价
}cake[1010];
/**
Try commenting in English! :)
**/
//sort from big to small
bool cmp(mooncake a,mooncake b){
    return a.unitPrice>b.unitPrice;
}
int main(){
    int n,D;
    cin>>n>>D;
    //input the stock of mooncake
    for(int i=0;i<n;i++){
        cin>>cake[i].stock;
    }

    //input the price of mooncake and calculate the unit price of mooncake.
    for(int i=0;i<n;i++){
        cin>>cake[i].price;
        cake[i].unitPrice = cake[i].price/cake[i].stock;
    }

    //sort by unitPrice
    sort(cake,cake+n,cmp);

    double ans = 0;
    for(int i =0;i<n;i++){
        if(cake[i].stock>=D){
            //if the stock of mooncake is more than the demand
            ans = ans+cake[i].unitPrice*D;
            D=0;
            break;
        }else if(cake[i].stock<D){
            D = D - cake[i].stock;
            ans = ans + cake[i].price;
        }
    }
    printf("%.2f\n",ans);
    return 0;
}

