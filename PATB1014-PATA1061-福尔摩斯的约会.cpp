/**
1014 ����Ħ˹��Լ�� (20)��20 �֣�
����̽����Ħ˹�ӵ�һ����ֵ�������������Լ��ɣ� 3485djDkxh4hhGE 2984akDfkkkkggEdsb s&hgsfdk d&Hyscvnm��������̽�ܿ�������ˣ���������ֵ�����ʵ���Ͼ���Լ���ʱ�䡰������ 14:04������Ϊǰ�����ַ����е�1����ͬ�Ĵ�дӢ����ĸ����Сд�����֣��ǵ�4����ĸ'D'�����������ģ���2����ͬ���ַ���'E'�����ǵ�5��Ӣ����ĸ������һ����ĵ�14����ͷ������һ���0�㵽23��������0��9���Լ���д��ĸA��N��ʾ�����������ַ�����1����ͬ��Ӣ����ĸ's'�����ڵ�4��λ�ã���0��ʼ�������ϣ������4���ӡ��ָ��������ַ��������������Ħ˹����õ�Լ���ʱ�䡣

�����ʽ��

������4���зֱ����4���ǿա��������ո��ҳ��Ȳ�����60���ַ�����

�����ʽ��

��һ�������Լ���ʱ�䣬��ʽΪ��DAY HH:MM�������С�DAY����ĳ���ڵ�3�ַ���д����MON��ʾ����һ��TUE��ʾ���ڶ���WED��ʾ��������THU��ʾ�����ģ�FRI��ʾ�����壬SAT��ʾ��������SUN��ʾ�����ա���Ŀ���뱣֤ÿ�����Դ���Ψһ�⡣

����������

3485djDkxh4hhGE
2984akDfkkkkggEdsb
s&hgsfdk
d&Hyscvnm
���������

THU 14:04
**/
#include<stdio.h>
#include<iostream>
#include<cstring>
using namespace std;
int main() {
    //0-MON 1-TUE 2-WED 3-THU 4-FRI 5-SAT 6-SUN
    char week[7][4] = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    char str[5][61];

    for(int i = 1; i < 5; i++) {
        scanf("%s", str[i]);
    }

    int len1 = strlen(str[1]);
    int len2 = strlen(str[2]);
    int len3 = strlen(str[3]);
    int len4 = strlen(str[4]);

    int i;
    for(i = 0; i < len1 && i < len2; i++) {
        if(str[1][i] == str[2][i] && str[1][i] >= 'A' && str[1][i] <= 'G') {
            printf("%s ", week[str[1][i] - 'A']);
            break;
        }
    }

    for(i = i+1; i < len1 && i < len2; i++) {
        if(str[1][i] == str[2][i]) {
            if(str[1][i] >= '0' && str[1][i] <= '9') {
                printf("%02d:", str[1][i]-'0');
                break;
            } else if(str[1][i] >= 'A' && str[1][i] <= 'N') {
                printf("%02d:", str[1][i] - 'A' + 10);
                break;
            }
        }
    }

    for(int i = 0; i < len3 && i < len4; i++) {
        if(str[3][i] == str[4][i]) {
            if(str[3][i] >= 'A' && str[3][i] <= 'Z' || str[3][i] >= 'a' && str[3][i] <= 'z') {
                printf("%02d", i);
                break;
            }


        }
    }

    return 0;
}

