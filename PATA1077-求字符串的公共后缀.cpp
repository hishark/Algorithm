/**
1077 Kuchiguse (20)（20 分）
The Japanese language is notorious for its sentence ending particles. Personal preference of such particles can be considered as a reflection of the speaker's personality. Such a preference is called "Kuchiguse" and is often exaggerated artistically in Anime and Manga. For example, the artificial sentence ending particle "nyan~" is often used as a stereotype for characters with a cat-like personality:

Itai nyan~ (It hurts, nyan~)

Ninjin wa iyada nyan~ (I hate carrots, nyan~)

Now given a few lines spoken by the same character, can you find her Kuchiguse?

Input Specification:

Each input file contains one test case. For each case, the first line is an integer N (2<=N<=100). Following are N file lines of 0~256 (inclusive) characters in length, each representing a character's spoken line. The spoken lines are case sensitive.

Output Specification:

For each test case, print in one line the kuchiguse of the character, i.e., the longest common suffix of all N lines. If there is no such suffix, write "nai".

Sample Input 1:

3
Itai nyan~
Ninjin wa iyadanyan~
uhhh nyan~
Sample Output 1:

nyan~
Sample Input 2:

3
Itai!
Ninjinnwaiyada T_T
T_T
Sample Output 2:

nai
**/
#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;
int main(){
    int N;
    cin>>N;
    int minLength = 256;
    string str[N];

    //下面用了getline，会吸收换行符，所以务必在这里用getchar先吸收掉换行符~
    getchar();

    //这个循环里取得了最小长度minLength，并且将所有字符串都倒转
    //问题转换为求字符串的最长前缀
    for(int i=0;i<N;i++){
        getline(cin,str[i]);
        if(str[i].size()<minLength){
            minLength = str[i].size();
        }
        int currentLength = str[i].size();
        //reverse(i,j)   [i,j) 区间左闭右开
        reverse(str[i].begin(),str[i].begin()+currentLength);

    }

    //相同的个数
    int ans = 0;

    //判断全部字符串的第i个字符是否相同
    for(int i=0;i<minLength;i++){
        char compare = str[0][i];
        bool isSame = true;
        for(int j=1;j<N;j++){
            if(compare!=str[j][i]){
                isSame = false;
                break;
            }
        }

        if(isSame){
            ans++;
        }else{
            break;
        }
    }


    if(ans>0){
        for(int i=ans-1;i>=0;i--){
            cout<<str[0][i];
        }
        cout<<endl;
    }else{
        cout<<"nai"<<endl;
    }

    return 0;
}

