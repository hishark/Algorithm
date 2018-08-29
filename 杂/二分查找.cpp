#include<stdio.h>
#include<iostream>
using namespace std;
//A[]为严格递增序列，left为二分下界，right为二分上界，x为欲查询的数
//--->如果A[]为递减序列，只需要将A[mid]>x改为A[mid]<x即可
//二分区间为[left,right],传入的初值为[0,n-1]
/**
一般使用mid=left+(right-left)/2这条等价语句来避免溢出
**/
int binarySearch(int A[],int left,int right,int x){
    int mid;
    while(left<=right){
        mid = (left+right)/2;
        if(A[mid]==x){
            return mid;
        }else if(A[mid]>x){
            right = mid-1;
        }else{
            left = mid+1;
        }
    }
    return -1;
}



int main(){
    const int n =10;
    int A[n] = {1,3,4,6,7,8,10,11,12,15};
    cout<<binarySearch(A,0,n-1,6)<<endl;
    cout<<binarySearch(A,0,n-1,9)<<endl;
}

