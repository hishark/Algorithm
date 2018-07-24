/**
1010 一元多项式求导 (25)（25 分）
设计函数求一元多项式的导数。（注：x^n（n为整数）的一阶导数为n*x^n-1^。）

输入格式：以指数递降方式输入多项式非零项系数和指数（绝对值均为不超过1000的整数）。数字间以空格分隔。

输出格式：以与输入相同的格式输出导数多项式非零项的系数和指数。数字间以空格分隔，但结尾不能有多余空格。注意“零多项式”的指数和系数都是0，但是表示为“0 0”。

输入样例：

3 4 -5 2 6 1 -2 0
输出样例：

12 3 -10 1 6 0
//**/

/**
这个多好啊才十几行代码！搞那么复杂> <
**/
#include<stdio.h>
#include<iostream>
using namespace std;
int main(){
    int a,b;
    bool flag = false;
    while(cin>>a>>b){
        if(b!=0){
            if(flag==true){
                cout<<" ";
            }
            cout<<a*b<<" "<<b-1;
            flag = true;
        }
    }
    if(flag==false){
        cout<<"0 0";
    }
    return 0;
}
//晴神这个办法真的是辣鸡。。我觉得这个还是柳神的方法比较好
//哦不过感觉是在给书上的下一题做铺垫
//#include<stdio.h>
//#include<iostream>
//using namespace std;
//int main(){
//    //数组a用来存系数，a[e]表示指数为e的项的系数
//    int a[1001] = {0};
//    int k,e;
//    bool flag = false;
//
//    while(scanf("%d%d",&k,&e)!=EOF){
//        a[e] = k;
//    }
//
//    for(int i=1;i<=1000;i++){
//        a[i-1] = a[i] * i;
//        //a[i] = 0;
//
//    }
//    a[1000]=0;
//
//    for(int i=1000;i>=0;i--){
//        if(a[i]!=0){
//            if(flag){
//                cout<<" ";
//            }
//            cout<<a[i]<<" "<<i;
//            flag = true;
//        }
//    }
//
//    if(flag==false)
//        cout<<"0 0";
//
//    return 0;
//}
