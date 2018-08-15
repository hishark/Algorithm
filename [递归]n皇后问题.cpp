#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<cstring>
using namespace std;
const int maxn = 10000;
//PΪ��ǰ�±��Ӧ���кţ�hashTable��¼�ʺ�x�Ƿ��ѷ�������
int n, P[maxn], hashTable[maxn] = {false};
int num = 0;

//����ö��
void generateP1(int index) {
    if(index == n + 1) { //�ݹ�߽磬����һ�����У����������ж��Ƿ�Ϸ�
        bool flag = true;//flagΪtrueʱ��ʾ��ǰ����Ϊһ���Ϸ�����
        for(int i = 1; i <= n; i++) {
            //�������������ʺ�
            for(int j = i + 1; j <= n; j++) {
                //i��j��������P[i]P[j]�������������������Ĳ���ͬ��ʾ��һ���Խ�����
                if(abs(i - j) == abs(P[i] - P[j])) {
                    flag = false;//���Ϸ�
                }
            }
        }
        if(flag == true)
            num++;//����ǰ�����Ϸ���num��һ
        return;
    }

    for(int x = 1; x <= n; x++) {
        if(hashTable[x] == false) {
            P[index] = x;
            hashTable[x] = true;
            generateP1(index + 1);
            hashTable[x] = false;
        }
    }
}

//����
void generateP2(int index) {
    if(index == n + 1) {
        //�ݹ�߽磬����һ���Ϸ�����
        num++;//�ܵ��������һ���ǺϷ���
        return;
    }

    // ��x�� line x
    for(int x = 1; x <= n; x++) {
        //��x�л�û�лʺ�
        if(hashTable[x] == false) {
            //flagΪtrue��ʾ��ǰ�ʺ󲻻��֮ǰ�Ļʺ��ͻ
            bool flag = true;

            //����֮ǰ�Ļʺ�
            for(int pre = 1; pre < index; pre++) {
                //��index�лʺ���к�Ϊx����pre�лʺ���к�ΪP[pre]
                if(abs(index - pre) == abs(x - P[pre])) {
                    flag = false;//��֮ǰ�Ļʺ���һ���Խ����ϣ���ͻ
                    break;

                }
            }

            //������԰ѻʺ���ڵ�x��
            if(flag == true) {
                //���index�лʺ���к�Ϊx
                P[index] = x;

                //��x���Ѿ���ռ��
                hashTable[x] = true;

                //�ݹ鴦���index+1�лʺ�
                generateP2(index + 1);

                //�ݹ���ϣ���ԭ��x��δ��ռ��
                hashTable[x] = false;

            }

        }
    }
}

//���Լ�дһ�»���
void generateP(int index) {
    if(index == n + 1) {
        num++;
        return;
    }
    for(int x = 1; x <= n; x++) { //��x��
        //�����x�л�û�зŻʺ�
        if(hashTable[x] == false) {
            //index���У�x���С�
            bool flag = true;//flagΪtrue��ʾ�Ϸ���û���γɶԽ���Ŷ
            //������ȷ���Ƿ���֮ǰ�Ļʺ��γɶԽ���
            for(int pre = 1; pre < index; pre++) {
                //index��pre���кţ�x��P[pre]���к�
                if(abs(index - pre) == abs(x - P[pre])) {
                    //����γ��˶Խ����򲻺Ϸ�
                    flag = false;
                    break;
                }
            }

            //����Ϸ��ͷŽ�����
            if(flag == true) {
                P[index] = x;
                hashTable[x] = true;
                generateP(index + 1);
                hashTable[x] = false;
            }
        }
    }
}

int main() {
    n = 8;
    generateP(1);//��1��ʼö��
    cout << num;
    return 0;
}
