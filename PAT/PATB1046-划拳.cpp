/**
1046 ��ȭ(15)��15 �֣�
��ȭ�ǹ����й����Ļ���һ����Ȥ����ɲ��֡����������˻�ȭ�ķ���Ϊ��ÿ�˿��к���һ�����֣�ͬʱ���ֱȻ���һ�����֡����˭�Ȼ������������õ������˺���������֮�ͣ�˭��Ӯ�ˣ���ҷ�һ���ơ�����ͬӮ������ͬ���������һ�֣�ֱ��Ψһ��Ӯ�ҳ��֡�

��������ס������˵Ļ�ȭ��¼������ͳ���������ֱ���˶��ٱ��ơ�

�����ʽ��

�����һ���ȸ���һ��������N��<=100�������N�У�ÿ�и���һ�ֻ�ȭ�ļ�¼����ʽΪ��

�׺� �׻� �Һ� �һ�

���С������Ǻ��������֣��������ǻ��������֣���Ϊ������100������������ֻ��һ�𻮣���

�����ʽ��

��һ�����Ⱥ�����ס������˺ȾƵı����������һ���ո�ָ���

����������

5
8 10 9 12
5 10 5 10
3 8 5 12
12 18 1 13
4 16 12 15
���������

1 2
**/
#include<stdio.h>
#include<iostream>
using namespace std;
int main(){
    int AYell,AHand,BYell,BHand;
    int ADrink = 0, BDrink = 0;
    int N;
    cin>>N;
    //�׺� �׻� �Һ� �һ�
    while(N--){
        int YellSum = 0;
        cin>>AYell>>AHand>>BYell>>BHand;
        YellSum = AYell + BYell;
        //˭���ĺ�YellSumһ����Ӯ��
        if(AHand==YellSum&&BHand==YellSum){
            continue;
        }else if(AHand==YellSum&&BHand!=YellSum){
            BDrink++;
        }else if(AHand!=YellSum&&BHand==YellSum){
            ADrink++;
        }
    }
    cout<<ADrink<<" "<<BDrink<<endl;
    return 0;
}
