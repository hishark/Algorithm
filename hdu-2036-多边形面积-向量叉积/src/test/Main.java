package test;

import java.util.Scanner;
/*
 *  这里可以利用向量的叉积来方便地计算多边形的面积，无论这个多边形是否是凸多边形。
    向量的叉积：s=(x1*y2-x2*y1)/2  可以计算凹凸多边形  
 */
public class Main{  
    public static void main(String[] args){  
        Scanner scanner=new Scanner(System.in);  
        while(scanner.hasNext()){  
            int n=scanner.nextInt();  
            int i;  
            if(n==0){  
                break;  
            }  
            else {  
                int[] x=new int[100];  
                int[] y=new int[100];  
                double sum=0;  
                for(i=0;i<n;i++){  
                    x[i]=scanner.nextInt();  
                    y[i]=scanner.nextInt();  
                }  
                for(i=0;i<n-1;i++){  
                    sum+=x[i]*y[i+1]-x[i+1]*y[i];  
                }  
                sum+=x[i]*y[0]-x[0]*y[i];  
                System.out.println(sum/2);  
            }  
        }  
    }  
}  