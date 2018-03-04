package test;

import java.util.Arrays;

/*
 * 这个小哥解释的很清楚
 * http://www.sczyh30.com/posts/Algorithm/algorithm-quicksort/
 */
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{12,433,23,1,3,4,5,699,10,2};
		quick_sort(arr,0,9);
		System.out.println(Arrays.toString(arr));
	}

	static int partition(int arr[], int left, int right) {
	    int i = left, j = right;
	    //挖出一个坑
	    int tmp = arr[left];
	    while (i < j) {
	        while (i < j && arr[j] > tmp)
	            j--;
	        if (i < j) {
	        	//填上坑 又出现一个坑
	            arr[i] = arr[j];
	            i++;
	        }
	        while (i < j && arr[i] < tmp)
	            i++;
	        if (i < j) {
	        	//再填坑
	            arr[j] = arr[i];
	            j--;
	        }
	    }
	    //循环直到i和j相等 所以这里填i填j都ok
	    arr[i] = tmp;
	    return i;
	}
	static void quick_sort(int arr[], int left, int right) {
	    if(left > right)
	        return;
	    int j = partition(arr, left, right);
	    quick_sort(arr, left, j - 1);
	    quick_sort(arr, j + 1, right);
	}
}
