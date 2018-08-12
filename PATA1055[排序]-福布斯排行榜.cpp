/**
https://pintia.cn/problem-sets/994805342720868352/problems/994805421066272768
英文题真是OTZ
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

struct person{
    int age;
    int wealth;
    string name;
}pers[100010],validPerson[100010];

int Age[100010]={0};//某年龄的人数

bool cmp(person a,person b){
    if(a.wealth!=b.wealth)
        return a.wealth>b.wealth;
    else if(a.age!=b.age)
        return a.age<b.age;
    else
        return a.name<b.name;
}

int main(){
    int N,K;
    cin>>N>>K;
    for(int i=0;i<N;i++){
        cin>>pers[i].name>>pers[i].age>>pers[i].wealth;
    }

    //按要求进行排序
    sort(pers,pers+N,cmp);

    //进行预处理，把符合要求的人都存在validPerson里头
    int validNum = 0;
    for(int i=0;i<N;i++){
        if(Age[pers[i].age]<100){
            Age[pers[i].age]++;
            validPerson[validNum] = pers[i];
            validNum++;
        }
    }

    //开始查询，在validPeson里进行遍历，查找ageL~ageR里的人
    int M,ageL,ageR;
    for(int i=1;i<=K;i++){
        cin>>M>>ageL>>ageR;
        cout<<"Case #"<<i<<":"<<endl;
        int printNum = 0;
        for(int j=0;j<validNum&&printNum<M;j++){
            if(validPerson[j].age>=ageL&&validPerson[j].age<=ageR){
                cout<<validPerson[j].name<<" "<<validPerson[j].age<<" "<<validPerson[j].wealth<<endl;
                printNum++;
            }
        }
        if(printNum==0){
            cout<<"None"<<endl;
        }
    }

    return 0;
}
