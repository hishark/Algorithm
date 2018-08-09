/**
1077 Kuchiguse (20)��20 �֣�
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

    //��������getline�������ջ��з������������������getchar�����յ����з�~
    getchar();

    //���ѭ����ȡ������С����minLength�����ҽ������ַ�������ת
    //����ת��Ϊ���ַ������ǰ׺
    for(int i=0;i<N;i++){
        getline(cin,str[i]);
        if(str[i].size()<minLength){
            minLength = str[i].size();
        }
        int currentLength = str[i].size();
        //reverse(i,j)   [i,j) ��������ҿ�
        reverse(str[i].begin(),str[i].begin()+currentLength);

    }

    //��ͬ�ĸ���
    int ans = 0;

    //�ж�ȫ���ַ����ĵ�i���ַ��Ƿ���ͬ
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

