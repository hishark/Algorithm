import java.util.*;
//快速排序
//不稳定，平均时间复杂度是O(nlgn)
public class Main{
	public static void main(String[] args){
		int[] a = new int[]{9,5,2,6,7,3,1,3,2};
		QuickSort.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
class QuickSort{
	//一次划分（找到一个基准数，划分后基准数左边都比他小，右边都比他大）
	public static int partition(int[] arr,int left,int right){
		//一般设置最左边的为基准数
		int pivotKey = arr[left];
		//基准数的位置
		int pivotPointer = left;


		//右指针找比基准数小的，左指针找比基准数小的
		while(left<right){
			//先移动右指针，原因http://www.cnblogs.com/wxisme/p/5243631.html
			while(left<right && arr[right]>=pivotKey){
				right--;
			}
			//↑右指针找到了第一个比基准数小的数，就停止循环

			while(left<right && arr[left]<=pivotKey){
				left++;
			}
			//↑左指针找到了第一个比基准数大的数，就停止循环

			//此时交换左右指针指向的数，把大的换到右边，小的换到左边
			swap(arr,left,right);
		}

		//↑上面这个循环结束之后left=right，指向了同一位置，把这个位置的数和基准数交换即可，从而实现基准数左小右大
		swap(arr,pivotPointer,left);//left写成right也可以

		//把这个位置返回，以给下一次划分使用，划分左半边就-1，划分右半边就+1
		return left;//这里换成right也ok
	}

	public static void quickSort(int[] arr,int left,int right){
		if(left>=right){
			return;
		}
		//得到第一次划分的基准数位置
		int pivotPos = partition(arr,left,right);
		//左半边继续快速排序
		quickSort(arr,left,pivotPos-1);
		//右半边继续快速排序
		quickSort(arr,pivotPos+1,right);
	}

	public static void sort(int[] arr){
		if(arr==null||arr.length==0){
			return;
		}

		quickSort(arr,0,arr.length-1);
	}

	public static void swap(int[] arr,int left,int right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

}