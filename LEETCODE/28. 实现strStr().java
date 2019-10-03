class Solution {
    public int strStr(String haystack, String needle) {
        char[] hArray = haystack.toCharArray();
        char[] nArray = needle.toCharArray();
        int i=0,j=0;
        while(i<hArray.length&&j<nArray.length){
            if(hArray[i]==nArray[j]){
                i++;
                j++;
            }else{
                i=i-j+1;//*
                j=0;
            }
        }
        if(j==nArray.length)
            return i-j;
        else
            return -1;
    }
}
