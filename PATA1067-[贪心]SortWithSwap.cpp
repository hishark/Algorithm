/**
1067 Sort with Swap(0,*) (25)��25 �֣�
Given any permutation of the numbers {0, 1, 2,..., N-1}, it is easy to sort them in increasing order. But what if Swap(0, *) is the ONLY operation that is allowed to use? For example, to sort {4, 0, 2, 1, 3} we may apply the swap operations in the following way:

Swap(0, 1) => {4, 1, 2, 0, 3}\ Swap(0, 3) => {4, 1, 2, 3, 0}\ Swap(0, 4) => {0, 1, 2, 3, 4}

Now you are asked to find the minimum number of swaps need to sort the given permutation of the first N nonnegative integers.

Input Specification:

Each input file contains one test case, which gives a positive N (<=10^5^) followed by a permutation sequence of {0, 1, ..., N-1}. All the numbers in a line are separated by a space.

Output Specification:

For each case, simply print in a line the minimum number of swaps need to sort the given permutation.

Sample Input:

10 3 5 7 2 6 4 9 0 8 1
Sample Output:

9
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){
    int n;
    cin>>n;
    int position[n];//position[x]��ʾx������λ�ã�0~9��
    int left = n-1;//left��ʾ��0�����λ������
    for(int i=0;i<n;i++){
        int num;
        cin>>num;
        position[num] = i;//���³�ʼ״����ÿ������������λ��

        //��������ʱͳ��left�����
        if(position[num]==num){
            left--;
        }
    }

    int k=1;//k������¼��0���ⲻ�ڱ�λ����С��һ�����֣���ʼΪ1
    int ans = 0;
    //���ڴ�λ������ʱ�ͼ���
    while(left>0){
        //���0��0λʱ
        if(position[0]==0){
                //�ҵ�һ�����ڱ�λ�ϵ�����������0����
                while(k<n){
                    if(position[k]!=k){
                        swap(position[0],position[k]);//��k��0����λ��
                        ans++;
                        break;
                    }
                    k++;
                }
        }
        //���0����0λ ��ֱ�ӽ���
        while(position[0]!=0){
            swap(position[0],position[position[0]]);
            ans++;
            left--;
        }
    }
    cout<<ans<<endl;
    return 0;
}
