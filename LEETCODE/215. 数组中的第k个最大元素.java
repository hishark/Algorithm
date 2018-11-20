class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);//简洁省事牛逼只要4ms
        return nums[nums.length-k];
    }
}

//快速选择！比直接Arrays.sort慢了好多啊!
class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }
    
    public int partition(int[] arr,int left,int right){
        //一般设置左边的为基准数
        int pivotKey = arr[left];
        int pivotPointer = left;
        while(left<right){
            while(left<right&&arr[right]>=pivotKey)
                right--;
            arr[left]=arr[right];
            
            while(left<right&&arr[left]<=pivotKey)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = pivotKey;
        return left;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}


