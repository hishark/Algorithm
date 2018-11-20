class Solution{
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        String result = "";
        for(int i=0;i<nums.length;i++){
            str[i] = nums[i]+"";
        }
        Comparator<String> cmp = new Comparator<String>(){
			public int compare(String str1, String str2){
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1);
			}
		};
		Arrays.sort(str, cmp);

        for(int i=0;i<nums.length;i++){
            result+=str[i];
        }
        
        if(result.charAt(0)=='0'){
            return "0";
        }
        
        return result;
    }
    
  

}