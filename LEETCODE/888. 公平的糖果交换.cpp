#include<iostream>
#include<vector>
using namespace std; 
class Solution {
public:
    vector<int> fairCandySwap(vector<int>& A, vector<int>& B) {
        vector<int> ans;
        int lenA = A.size();
	int lenB = B.size();
	
	int sumA=0,sumB=0;
	for(int i=0;i<lenA;i++){
		sumA+=A[i];
	}
	for(int i=0;i<lenB;i++){
		sumB+=B[i];
	}
	
	for(int i=0;i<lenA;i++){
		for(int j=0;j<lenB;j++){
			if(sumA-A[i]+B[j]==sumB-B[j]+A[i]){
				ans.push_back(A[i]);
				ans.push_back(B[j]);
                
				return ans;
			}
		}
	} 
    }
};
int main(){
	vector<int> A,B,ans;
	A.push_back(1);
	A.push_back(2);
	A.push_back(5);
	B.push_back(2);
	B.push_back(4); 
	Solution solution;
	ans = solution.fairCandySwap(A,B);
	cout<<ans[0]<<","<<ans[1]<<endl;
	
	return 0;
}
