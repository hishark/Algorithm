/**
1018 锤子剪刀布 (20)（20 分）
大家应该都会玩“锤子剪刀布”的游戏：两人同时给出手势，胜负规则如图所示：



现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。

输入格式：

输入第1行给出正整数N（<=10^5^），即双方交锋的次数。随后N行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。C代表“锤子”、J代表“剪刀”、B代表“布”，第1个字母代表甲方，第2个代表乙方，中间有1个空格。

输出格式：

输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。第3行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有1个空格。如果解不唯一，则输出按字母序最小的解。

输入样例：

10
C J
J B
C B
B B
B C
C C
C B
J B
B C
J J
输出样例：

5 3 2
2 3 5
B B
**/
#include<stdio.h>
#include<iostream>
using namespace std;
int change(char c){
    if(c=='B')
        return 0;
    if(c=='C')
        return 1;
    if(c=='J')
        return 2;
    return -1;
}
int main(){
    int N;
    int AWIN=0,BWIN=0,ALOSE=0,BLOSE=0,AP=0,BP=0;
    int AB=0,AC=0,AJ=0,BB=0,BC=0,BJ=0;
    cin>>N;
    while(N--){
        char A,B;
        cin>>A;
        cin>>B;
        int Anum,Bnum;
        Anum = change(A);
        Bnum = change(B);
        //或者if((Anum+1)%3==Bnum)
        if((Anum==0&&Bnum==1)||(Anum==1&&Bnum==2)||(Anum==2&&Bnum==0)){
            AWIN++;
            BLOSE++;

            switch(Anum){
            case 0:
                AB++;
                break;
            case 1:
                AC++;
                break;
            case 2:
                AJ++;
                break;
            }
            //或者if((Bnum+1)%3==Anum)
        }else if((Bnum==0&&Anum==1)||(Bnum==1&&Anum==2)||(Bnum==2&&Anum==0)){
            ALOSE++;
            BWIN++;
            switch(Bnum){
            case 0:
                BB++;
                break;
            case 1:
                BC++;
                break;
            case 2:
                BJ++;
                break;
            }
        }else if(Anum==Bnum){
            AP++;
            BP++;
        }
    }

    cout<<AWIN<<" "<<AP<<" "<<ALOSE<<endl;
    cout<<BWIN<<" "<<BP<<" "<<BLOSE<<endl;


    int AMAX = AB;
    if(AC>AMAX){
        cout<<'C'<<" ";
    }else if(AJ>AMAX){
        cout<<'J'<<" ";
    }else{
        cout<<'B'<<" ";
    }

    int BMAX = BB;
    if(BC>BMAX){
        cout<<'C'<<endl;
    }else if(BJ>BMAX){
        cout<<'J'<<endl;
    }else{
        cout<<'B'<<endl;
    }



    return 0;
}
