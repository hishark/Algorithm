/**
1014 福尔摩斯的约会 (20)（20 分）
大侦探福尔摩斯接到一张奇怪的字条：“我们约会吧！ 3485djDkxh4hhGE 2984akDfkkkkggEdsb s&hgsfdk d&Hyscvnm”。大侦探很快就明白了，字条上奇怪的乱码实际上就是约会的时间“星期四 14:04”，因为前面两字符串中第1对相同的大写英文字母（大小写有区分）是第4个字母'D'，代表星期四；第2对相同的字符是'E'，那是第5个英文字母，代表一天里的第14个钟头（于是一天的0点到23点由数字0到9、以及大写字母A到N表示）；后面两字符串第1对相同的英文字母's'出现在第4个位置（从0开始计数）上，代表第4分钟。现给定两对字符串，请帮助福尔摩斯解码得到约会的时间。

输入格式：

输入在4行中分别给出4个非空、不包含空格、且长度不超过60的字符串。

输出格式：

在一行中输出约会的时间，格式为“DAY HH:MM”，其中“DAY”是某星期的3字符缩写，即MON表示星期一，TUE表示星期二，WED表示星期三，THU表示星期四，FRI表示星期五，SAT表示星期六，SUN表示星期日。题目输入保证每个测试存在唯一解。

输入样例：

3485djDkxh4hhGE
2984akDfkkkkggEdsb
s&hgsfdk
d&Hyscvnm
输出样例：

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

