package test;

 
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int N = cin.nextInt();
		int num[] = new int[1001];
		for(int i=0;i<1001;i++){
			num[i] = 0;
		}
		for(int i=0;i<N;i++){
			int k = cin.nextInt();
			for(int j=0;j<k;j++){
				int input = cin.nextInt();
				num[input]++;
			}
		}
		
		int maxValue = 0,maxIndex=0;
		
		for(int i=0;i<1001;i++){
			if(num[i]>=maxValue){
				maxValue=num[i];
				maxIndex=i;
			}
		}
		
		System.out.println(maxIndex+" "+maxValue);

	}
}


/*
 * java最后一个用例超时
 * 用c艹啦
 */

/*
#include <iostream>
using namespace std;
int main() {
    int N;
	cin>>N;
	int num[1001]={0};
	int maxValue = 0,maxIndex=0;
 
	for(int i=0;i<N;i++){
			int k;
			cin>>k;
			for(int j=0;j<k;j++){
				int input;
				cin>>input; 
				num[input]++;
			}
		}
		
		for(int i=0;i<1001;i++){
			if(num[i]>=maxValue){
				maxValue=num[i];
				maxIndex=i;
			}
		}
		cout<<maxIndex;
		cout<<" ";
		cout<<maxValue;
}
*/

 