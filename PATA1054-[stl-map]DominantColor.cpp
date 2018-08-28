/**
1054 The Dominant Color（20 分）
Behind the scenes in the computer's memory, color is always talked about as a series of 24 bits of information for each pixel. In an image, the color with the largest proportional area is called the dominant color. A strictly dominant color takes more than half of the total area. Now given an image of resolution M by N (for example, 800×600), you are supposed to point out the strictly dominant color.

Input Specification:
Each input file contains one test case. For each case, the first line contains 2 positive numbers: M (≤800) and N (≤600) which are the resolutions of the image. Then N lines follow, each contains M digital colors in the range [0,2
?24
?? ). It is guaranteed that the strictly dominant color exists for each input image. All the numbers in a line are separated by a space.

Output Specification:
For each test case, simply print the dominant color in a line.

Sample Input:
5 3
0 0 255 16777215 24
24 24 0 0 24
24 0 24 24 24
Sample Output:
24
**/
#include<cstdio>
#include<map>
using namespace std;
map<int,int> mp;
int main(){
	int N,M,input;
	scanf("%d%d",&N,&M);
	for(int i=0;i<N;i++){
		for(int j=0;j<M;j++){
			scanf("%d",&input);
			if(mp.find(input)!=mp.end()){
				//找到了这个值，就次数+1
				mp[input]++; 
			}else{
				//没找到就次数设为1
				mp[input] = 1; 
			}
		}
	}
	
	int key,count = 0;
	//输入完成之后就可以进行遍历了
	for(map<int,int>::iterator it = mp.begin();it!=mp.end();it++){
		if(it->second > count){
			key = it->first;
			count = it->second;
		}
	} 
	printf("%d\n",key);
}

