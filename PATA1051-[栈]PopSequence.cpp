/**
1051 Pop Sequence��25 �֣�
Given a stack which can keep M numbers at most. Push N numbers in the order of 1, 2, 3, ..., N and pop randomly. You are supposed to tell if a given sequence of numbers is a possible pop sequence of the stack. For example, if M is 5 and N is 7, we can obtain 1, 2, 3, 4, 5, 6, 7 from the stack, but not 3, 2, 1, 7, 5, 6, 4.

Input Specification:
Each input file contains one test case. For each case, the first line contains 3 numbers (all no more than 1000): M (the maximum capacity of the stack), N (the length of push sequence), and K (the number of pop sequences to be checked). Then K lines follow, each contains a pop sequence of N numbers. All the numbers in a line are separated by a space.

Output Specification:
For each pop sequence, print in one line "YES" if it is indeed a possible pop sequence of the stack, or "NO" if not.

Sample Input:
5 7 5
1 2 3 4 5 6 7
3 2 1 7 5 6 4
7 6 5 4 3 2 1
5 6 4 3 7 2 1
1 7 6 5 4 3 2
Sample Output:
YES
NO
NO
YES
NO
**/
#include<cstdio>
#include<iostream>
#include<stack>
const int maxn = 1010;
using namespace std;
stack<int> st;
int array[maxn];
int main() {
	int m,n,T;
	//mջ���� n�������� T��������
	cin>>m>>n>>T;
	while(T--) {
		//�ǵ�Ҫ���ջ
		while(!st.empty()){
			st.pop();
		}
		
		 
		for(int i=1; i<=n; i++) {
			cin>>array[i];
		}
		int current = 1;
		bool flag = true;//��ǰ��ջ�����Ƿ�Ϸ� 
		for(int i=1;i<=n;i++){
			st.push(i);
			if(st.size()>m){
				flag  = false;
				break;
			}
			//��ջ��Ϊ��ʱ��ջ��Ԫ�����ջ���е�ǰλ�õ�Ԫ����ͬʱ���ͳ�ջ��currentָ����һ��λ�� 
			while(!st.empty()&&st.top()==array[current]){
				st.pop();
				current++;
			}
		}
		//ջ����flagΪtrueʱ���yes 
		if(st.empty()&&flag == true){
			cout<<"YES"<<endl; 
		}else{
			cout<<"NO"<<endl;
		}
	}
	return 0;
}

