class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,k=0;
        int[] temp = new int[m+n];
        
        while(i<m&&j<n){
            //谁小谁就放进temp
            if(nums1[i]<=nums2[j]){
                temp[k++] = nums1[i++];
            }else{
                temp[k++] = nums2[j++];
            }
        }
        
        //接下来把剩下的数放进temp即可
        while(i<m){
            temp[k++] = nums1[i++];
        }
        while(j<n){
            temp[k++] = nums2[j++];
        }
        
        for(int p=0;p<m+n;p++){
            nums1[p] = temp[p];
        }
        
    }
}