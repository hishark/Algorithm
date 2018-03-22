package test;

 
import java.util.Arrays;
 
import java.util.Scanner;
/*
 * 简单贪心
 * pat对java选手太不友好啦！
 * 只能用cpp了OTZ
 */
public class Main {
	 
	public static void main(String[] args){
		long start=System.currentTimeMillis(); //获取开始时间  
		Scanner cin =new Scanner(System.in);
		int N = cin.nextInt();
		int D = cin.nextInt();
		double stock[] = new double[N];
		double price[] = new double[N];		
		double unitPrice[] = new double[N];		
	
		for(int i=0;i<N;i++){
			stock[i] = cin.nextInt();
		}
		for(int i=0;i<N;i++){
			price[i] = cin.nextInt();
		}
		long end=System.currentTimeMillis(); //获取结束时间
		for(int i=0;i<N;i++){
			unitPrice[i] = price[i]/stock[i];
		}
	
		MoonCake cake[] = new MoonCake[N];
		for(int i=0;i<N;i++){
			cake[i] = new MoonCake();
			cake[i].price = price[i];
			cake[i].stock = stock[i];
			cake[i].uniteprice = unitPrice[i];
		}
		
		Arrays.sort(cake);
		
		double maxMoney = 0;
		
		for(int i=cake.length-1;i>=0;i--){
			if(cake[i].stock>=D){
				maxMoney += D*cake[i].uniteprice;
				break;
			}else{
				maxMoney += cake[i].stock*cake[i].uniteprice;
				D -= cake[i].stock;
			}
		}
		
		System.out.printf("%.2f",maxMoney);
		
	System.out.println("程序运行时间： "+(end-start)+"ms");   
	
	}
	
	
}
class MoonCake implements Comparable{
	double stock;
	double price;
	double uniteprice;
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		MoonCake mc = (MoonCake)arg0;
		return (uniteprice>mc.uniteprice)?1:-1;
	}
}

/*
 * CPP的AC代码
 */
/*
#include<iostream> 
#include<algorithm>
using namespace std;

struct mooncake{
	double mount;
	double price;
	double unit;
};

int cmp(mooncake a,mooncake b){
	return a.unit>b.unit;
}

int main() {
    int n;
    cin>>n;
    int need;
    cin>>need;
    
    mooncake *a = new mooncake[n];
    for(int i=0;i<n;i++){
    	cin>>a[i].mount;
	} 
	for(int i=0;i<n;i++){
    	cin>>a[i].price;
	} 
	for(int i=0;i<n;i++){
    	a[i].unit = a[i].price / a[i].mount;
	} 
	sort(a,a+n,cmp);
	
	double result = 0;
	
	for (int i = 0; i < n; i++) {
        if (a[i].mount>=need) {
            result += need*a[i].unit; 
            break;
        } else {
            result += a[i].mount*a[i].unit;
			need -= a[i].mount;
				
             
        }
         
    }
    printf("%.2f",result);
 
}







*/
