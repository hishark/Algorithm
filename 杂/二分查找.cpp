#include<stdio.h>
#include<iostream>
using namespace std;
//A[]Ϊ�ϸ�������У�leftΪ�����½磬rightΪ�����Ͻ磬xΪ����ѯ����
//--->���A[]Ϊ�ݼ����У�ֻ��Ҫ��A[mid]>x��ΪA[mid]<x����
//��������Ϊ[left,right],����ĳ�ֵΪ[0,n-1]
/**
һ��ʹ��mid=left+(right-left)/2�����ȼ�������������
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

