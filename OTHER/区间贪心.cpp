/**
���䲻�ཻ���⣺
����N�������䣨x,y��
����ѡ�񾡿��ܶ�Ŀ����䣬ʹ����Щ����������û�н���
**/
#include<cstdio>
#include<algorithm>��˵�
#include<iostream>
using namespace std;
const int maxn = 110;
struct interval{
    int x,y;//the left endpoint and the right endpoint
}IN[maxn];

bool cmp(interval a,interval b){
    //�Ȱ���˵�Ӵ�С����
    if(a.x!=b.x)
        return a.x>b.x;
    else//��˵���ͬ�İ����Ҷ˵��С��������
        return a.y<b.y;
}

int main(){
    int n;
    while(scanf("%d",&n),n!=0){
        for(int i=0;i<n;i++){
            scanf("%d%d",&IN[i].x,&IN[i].y);
        }

        //����������
        sort(IN,IN+n,cmp);

        //ans��¼���ཻ����ĸ�����lastX��¼��һ����ѡ���������˵�
        int ans = 1,lastX = IN[0].x;
        for(int i=1;i<n;i++){
            if(IN[i].y<=lastX){//�����������Ҷ˵���lastX�����
                lastX = IN[i].x;//��IN[i]��Ϊ��ѡ�е����ߣ�lastX����������˵�
                ans++;
            }
        }
        cout<<ans<<endl;
    }


    return 0;
}
