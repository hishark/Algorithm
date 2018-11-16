import java.util.*;
//简单选择排序
//时间复杂度O(n^2)
public class Main{
	public static void main(String[] args){
		int[] a = new int[]{6,3,5,8,2,1,9,2};
		SelectSort.selectSort(a);
		System.out.println(Arrays.toString(a));
	}
}
class SelectSort{
	public static void selectSort(int[] arr){
		//判断一下是否为空
		if(arr==null||arr.length==0){
			return;
		}

		int minIndex;
		for(int i=0;i<arr.length-1;i++){//只需要比较n-1次
			minIndex = i;
			for(int j=i+1;j<arr.length;j++){
				//从i+1开始比较，因为minIndex已经是i了，就不用和i比较了
				if(arr[j]<arr[minIndex]){
					minIndex = j;
				}
			}

			if(minIndex!=i){
				swap(arr,j,minIndex);
			}
		}
	}

	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}