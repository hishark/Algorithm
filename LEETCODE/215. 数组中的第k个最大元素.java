// 快速排序
class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }

    // 划分操作，找出基准数应该在的位置（这个位置的左边都比他小，右边都比他大）
    public static int partition(int[] arr, int left, int right) {
        // 随机选择一个数作为基准数，这里就直接选择最左边的数
        int pivotKey = arr[left];
        // 基准数的初始位置 此时是left
        int pivotPointer = left;
        
        // 循环条件♻️
        while(left < right) {
            // 如果右指针指向的数比基准数更大，那么就满足需求，继续将右指针往左移动
            // 等跳出这个循环时，right就指向了一个比基准数更小的元素
            while(left < right && arr[right] >= pivotKey)
                right --;
            while(left < right && arr[left] <= pivotKey)
                left ++;
            
            // 结束两个while循环后，交换left和right指向的元素
            swap(arr, left, right); //把大的交换到右边，把小的交换到左边。
        }

        // 最后把基准数交换到左右指针相遇的位置
        swap(arr, pivotPointer, left); 
        // 此时，相遇的位置就是基准数应该在的位置
        return left;
    }
    
    // 快排 数组、左指针、右指针
    public static void quickSort(int[] arr, int left, int right) {
        // 左右指针相遇了就结束
        if(left >= right)
            return ;
        // 通过划分得到基准数的位置
        int pivotPos = partition(arr, left, right);
        // 继续对基准数左边的数进行快排
        quickSort(arr, left, pivotPos-1);
        // 继续对基准数右边的数进行快排
        quickSort(arr, pivotPos+1, right);
    }
    
    public static void sort(int[] arr) {
        // 边界判断
        if(arr == null || arr.length == 0)
            return ;
        // 对 0-length-1的元素进行快速排序
        quickSort(arr, 0, arr.length-1);
    }
    
    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
