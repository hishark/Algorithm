/**
区间不相交问题：
给出N个开区间（x,y）
从中选择尽可能多的开区间，使得这些开区间两两没有交集
**/
#include<cstdio>
#include<algorithm>左端点
#include<iostream>
using namespace std;
const int maxn = 110;
struct interval{
    int x,y;//the left endpoint and the right endpoint
}IN[maxn];

bool cmp(interval a,interval b){
    //先按左端点从大到小排序
    if(a.x!=b.x)
        return a.x>b.x;
    else//左端点相同的按照右端点从小到大排序
        return a.y<b.y;
}

int main(){
    int n;
    while(scanf("%d",&n),n!=0){
        for(int i=0;i<n;i++){
            scanf("%d%d",&IN[i].x,&IN[i].y);
        }

        //把区间排序
        sort(IN,IN+n,cmp);

        //ans记录不相交区间的个数，lastX记录上一个被选中区间的左端点
        int ans = 1,lastX = IN[0].x;
        for(int i=1;i<n;i++){
            if(IN[i].y<=lastX){//如果该区间的右端点在lastX的左边
                lastX = IN[i].x;//以IN[i]作为新选中的曲线，lastX继续记下左端点
                ans++;
            }
        }
        cout<<ans<<endl;
    }


    return 0;
}
