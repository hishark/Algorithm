#include<cstdio>
#include<iostream>
using namespace std;
const int maxn = 11;

/**
�����е��±��Ϊ1~n û��0Ŷ��
**/

//PΪ��ǰ���У�hashTable��¼����x�Ƿ��Ѿ���P��
int n, P[maxn], hashTable[maxn]={false};

//��ǰ�������еĵ�index��λ
void generateP(int index){
    if(index==n+1){
        //�ݹ�߽磬�Ѿ����������е�1~nλ
        for(int i=1;i<=n;i++){
            cout<<P[i];//�����ǰ����
        }
        cout<<endl;
        return;
    }

    //ö��1~n ��ͼ��x����P[index]
    for(int x=1;x<=n;x++){
        if(hashTable[x]==false){//���x����P[1]~P[index]��
            //��P�ĵ�indexλΪx������x���뵱ǰ����
            P[index] = x;

            //��x�Ѿ���P��
            hashTable[x] = true;

            //�������еĵ�index+1λ
            generateP(index+1);

            //�Ѵ�����P[index]Ϊx�������⣬��ԭ״̬
            hashTable[x] = false;
        }
    }
}

int main(){
    n = 3;//�����1~3��ȫ����
    generateP(1);//��P[1]��ʼ��
    return 0;
}
