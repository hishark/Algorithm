/**
1018 ���Ӽ����� (20)��20 �֣�
���Ӧ�ö����桰���Ӽ�����������Ϸ������ͬʱ�������ƣ�ʤ��������ͼ��ʾ��



�ָ������˵Ľ����¼����ͳ��˫����ʤ��ƽ�������������Ҹ���˫���ֱ��ʲô���Ƶ�ʤ�����

�����ʽ��

�����1�и���������N��<=10^5^������˫������Ĵ��������N�У�ÿ�и���һ�ν������Ϣ�����ס���˫��ͬʱ�����ĵ����ơ�C�������ӡ���J������������B������������1����ĸ����׷�����2�������ҷ����м���1���ո�

�����ʽ��

�����1��2�зֱ�����ס��ҵ�ʤ��ƽ�������������ּ���1���ո�ָ�����3�и���������ĸ���ֱ����ס��һ�ʤ�����������ƣ��м���1���ո�����ⲻΨһ�����������ĸ����С�Ľ⡣

����������

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
���������

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
        //����if((Anum+1)%3==Bnum)
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
            //����if((Bnum+1)%3==Anum)
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
