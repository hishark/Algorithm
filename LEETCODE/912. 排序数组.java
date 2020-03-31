//快速排序
//https://zh.wikipedia.org/wiki/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F#Java
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public static void quickSort(int[] arr, int head, int tail) {
        //边界值判断
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }

        //取中间值作为基准值进行比较
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            //i指针一直移动到大于等于基准值的位置
            while (arr[i] < pivot) {
                ++i;
            }
            //j指针一直移动到小于等于基准值的位置
            while (arr[j] > pivot) {
                --j;
            }
            //如果i指针小于j指针 交换两个指针的值
            //交换后继续移动指针
            if (i < j) {
                //交换值
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                //i指针右移 j指针左移
                ++i;
                --j;
            } else if (i == j) {
                //两个指针碰面的时候，只增加i，然后i>j，退出循环
                ++i;
            }
        }
        //当结束上面的循环时，i>j
        //此时head到i之间的数都比pivot小
        //j到tail之间的数都比pivot大
        //之后对两坨分别进行递归的快排即可
        quickSort(arr, head, j);
        quickSort(arr, i, tail);
    }

}

//面试这么写你会挨打
class Solution {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;        
    }
}