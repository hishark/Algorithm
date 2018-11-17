import java.util.*;
//快速排序
//不稳定，平均时间复杂度是O(nlgn)

/**
再优化，之前代码中基准数已经在pivotKey中保存了，
所以不需要每次交换都设置一个temp变量，
在交换左右指针的时候只需要先后覆盖就可以了。
这样既能减少空间的使用还能降低赋值运算的次数。
**/

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


		//右指针找比基准数小的，左指针找比基准数大的
		while(left<right){
			//先移动右指针，原因http://www.cnblogs.com/wxisme/p/5243631.html
			while(left<right && arr[right]>=pivotKey){
				right--;
			}
			//↑右指针找到了第一个比基准数小的数，就停止循环，并把小的数移动到左边
			arr[left] = arr[right];


			while(left<right && arr[left]<=pivotKey){
				left++;
			}
			//↑左指针找到了第一个比基准数大的数，就停止循环，并把小的数移动到左边
			arr[right] = arr[left];
		}
		//把基准值赋值给两个指针碰头的地方，也就是中间
		arr[left] = pivotKey;//left换成right一样的

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