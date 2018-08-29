#include<stdio.h>
#include<iostream>
using namespace std;
void selectSort(int a[],int n){
    for(int i=0;i<n;i++){
        int k = i;
        for(int j=i;j<n;j++){
            if(a[j]<a[k]){
                k=j;
            }
        }

        //k存下了当前区间i~n最小值的位置
        //然后交换即可
        int temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }
}
int main(){
    int a[] = {5,4,3,2,1};
    selectSort(a,5);
    for(int i=0;i<5;i++){
        cout<<a[i]<<" ";
    }
    return 0;
}
