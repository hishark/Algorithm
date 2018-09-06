/**
��n����Ʒ��ÿ����Ʒ������Ϊw[i]����ֵΪc[i]��������Ҫѡ�����ɼ���Ʒ����һ������ΪV�ı���
ʹ����ѡ�뱳������Ʒ�����Ͳ���������V��ǰ���£��ñ�������Ʒ�ļ�ֵ֮�����������ֵ
(1<=n<=20) 
**/ 
#include<cstdio>
const int maxn = 30;
int n,V,maxValue = 0;//��Ʒ����n����������V������ֵmaxValue
int w[maxn],c[maxn];
//DFS,indexΪ��ǰ�������Ʒ���(index��0~n-1)
//sumW��sumC�ֱ�Ϊ��ǰ�������͵�ǰ�ܼ�ֵ
void DFS(int index,int sumW,int sumC){
	//�Ѿ�����˶�n����Ʒ��ѡ������ͬ�� 
	if(index==n){
		if(sumW<=V && sumC >maxValue){
			maxValue = sumC;//��������������ʱ��������ֵmaxValue 
		}
		return; 
	}
	//�����
	DFS(index+1,sumW,sumC);//��ѡ��index����Ʒ
	DFS(index+1,sumW+w[index],sumC+c[index]);//ѡ��index����Ʒ 
} 
void dfs(int index,int sumW,int sumC){
	if(index==n){
		return;//�Ѿ���ɶ�n����Ʒ��ѡ�� ������ͬ�� 
	}
	dfs(index+1,sumW,sumC);//��ѡ��index����Ʒ
	//ֻ�м����index����Ʒ��δ��������V�����ܼ���
	if(sumW+w[index]<=V){
		if(sumC+c[index]>maxValue){
			maxValue = sumC+c[index];
		}
		dfs(index+1,sumW+w[index],sumC+c[index]);//ѡ��index����Ʒ 
	} 
}
int main(){
	scanf("%d%d",&n,&V);
	for(int i=0;i<n;i++){
		scanf("%d",&w[i]);
	}
	for(int i=0;i<n;i++){
		scanf("%d",&c[i]);
	}
	DFS(0,0,0);//��ʼʱΪ��0����Ʒ����ǰ���������ܼ�ֵ��Ϊ0
	printf("%d\n",maxValue);
	return 0; 
} 
