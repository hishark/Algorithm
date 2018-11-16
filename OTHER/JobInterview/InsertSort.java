import java.util.*;
//插入排序
//时间复杂度O(n^2)
public class Main{
	public static void main(String[] args){
		int[] a = new int[]{9,5,2,6,7,3,1,3,2};
		InsertSort.insertSort(a);
		System.out.println(Arrays.toString(a));
	}
}
class InsertSort{
	public static void insertSort(int[] arr){
		//判断是否为空
		if(arr==null||arr.length==0){
			return;
		}

		for(int i=1;i<arr.length;i++){//假设第一个位置(0)是有序的,所以从1开始遍历
			//j指向一个空位置
			int j=i;

			//待插入的数
			int target = arr[i];

			//不停的往前遍历，每当遇到比target大的数都往后移，直到出现比target小的数，停止循环
			while(j>0 && target < arr[j-1]) {
				arr[j] = arr[j-1];
				j--;
			}

			//确定位置了插入target即可，当前j指向的位置一定是空位
			arr[j] = target;
		}
	}
}