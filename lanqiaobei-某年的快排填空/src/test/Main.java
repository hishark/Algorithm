package test;

import java.util.Arrays;

/*
 * 这里看到滴
 * http://www.z16388.top/2017/01/18/【ACM教程】3-7排序（一）/
 */
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{12,433,23,1,3,4,5,699,10,2};
		quicksort(arr,0,9);
		System.out.println(Arrays.toString(arr));
	}

	
	static void swap(int a[], int i, int j)
	{
	    int t = a[i];
	    a[i] = a[j];
	    a[j] = t;
	}
	static int partition(int a[], int p, int r)
	{
	    int i = p;
	    int j = r + 1;
	    int x = a[p];
	    while(true){
	        while(i<r && a[++i]<x);
	        while(a[--j]>x);
	        if(i>=j) break;
	        swap(a,i,j);
	    }
	    /*
	     * 下面这一行是填空！不是swap(a,p,i)噢，退出上面的循环时i不一定等于j
	     */
	    swap(a,p,j);
	    return j;
	}
	static void quicksort(int a[], int p, int r)
	{
	    if(p<r){
	    int q = partition(a,p,r);
	    quicksort(a,p,q-1);
	    quicksort(a,q+1,r);
	    }
	}
}



