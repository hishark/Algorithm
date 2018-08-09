#include<stdio.h>
#include<iostream>
using namespace std;
void insertSort(int a[], int n) {
    for(int i = 1; i < n; i++) {
        //temp临时存放A[i]
        int temp = a[i];
        //j从i开始往前枚举
        int j = i;
        while(j>0&&temp<a[j-1]){
            a[j] = a[j-1];
            j--;
        }
        a[j]= temp;
    }
}
int main() {
    int a[] = {5,4,3,2,1};
    insertSort(a,5);
    for(int i=0;i<5;i++){
        cout<<a[i]<<" ";
    }
    return 0;
}
