class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

//自己写快排。。。比直接Arrays.sort慢了好多啊
class Solution {
    public int findKthLargest(int[] nums, int k) {
        sortt(nums);
        return nums[nums.length-k];
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
    
    public void quickSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int pivotPos = partition(arr,left,right);
        quickSort(arr,left,pivotPos-1);
        quickSort(arr,pivotPos+1,right);
    }
    
    public void sortt(int[] arr){
		if(arr==null||arr.length==0){
			return;
		}

		quickSort(arr,0,arr.length-1);
	}
}

