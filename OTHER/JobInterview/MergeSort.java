import java.util.*;
//归并排序
//空间复杂度为O(n)，时间复杂度为O(nlogn)。
/**
其基本思想是，先递归划分子问题，然后合并结果。
把待排序列看成由两个有序的子序列，然后合并两个子序列，
.....
**/
public class Main{
	public static void main(String[] args){
		int[] a = new int[]{9,5,2,6,7,3,1,3,2};
		QuickSort.sort(a);
		System.out.println(Arrays.toString(a));
	}
}

class MergeSort{
	public static void mergeSort(int[] arr){
		mSort(arr,0,arr.length-1);
	}

	//递归分治
	public static void mSort(int[] arr,int left,int right){
		if(left>=right)
			return;

		int mid = (left+right)/2;

		//递归排序左半边
		mSort(arr,left,mid);

		//递归排序右半边
		mSort(arr,mid+1,right);

		//合并
		merge(arr,left,mid,right);

	}

	//合并两个有序数组[left,mid]和[mid+1,right]
	public static void merge(int[] arr,int left,int mid,int right){
		//中间数组
		int[] temp = new int[right-left+1];

		int i = left;
		int j = mid+1;
		int k = 0;

		while(i<=mid&&j<=right){
			//i和j分别从两个有序数组的最左边开始遍历，谁更小就放temp里去
			if(arr[i]<=arr[j]){
				temp[k++] = arr[i++];
			}else{
				temp[k++] = arr[j++];
			}
		}

		//如果第二个数组的数全部遍历完了，第一个数组还有剩，接下来直接把第一个数组的数全部加进temp即可
		while(i<=mid){
			temp[k++] = arr[i++];
		}

		//如果第一个数组的数全部遍历完了，第二个数组还有剩，接下来直接把第二个数组的数全部加进temp即可
		while(j<=right){
			temp[k++] = arr[j++];
		}

		//此时temp已经是一个合并成功的有序数组，再放回arr就好啦
		for(int p=0;p<temp.length;p++){
			arr[left+p]=temp[p];
			//注意一定是arr[left+p],不是arr[p]，merge函数的参数就是从left开始的！注意！
		}
	}
}