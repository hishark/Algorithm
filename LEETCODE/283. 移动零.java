class Solution {
    public void moveZeroes(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;

        for(int i=0;i<nums.length;i++) {
            if (nums[i] != 0) {
                res[index] = nums[i];
                index++;
            }
        }

        for(int i=0;i<nums.length;i++) {
            nums[i] = res[i];
        }

    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null) {
			return;
		}
        int A = 0;
        for(int B=0;B<nums.length;B++) {
            if (nums[B]!=0){
                int temp = nums[B];
                nums[B] = nums[A];
                nums[A++] = temp;
            }
        }
    }

}