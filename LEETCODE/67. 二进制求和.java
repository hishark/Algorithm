//转数字做，会溢出，int范围内的测试用例才可行，
class Solution {
    
    public int two2ten(String s){
        char[] a = s.toCharArray();
        int flag = 0;
        int result = 0;
        for(int i=a.length-1;i>=0;i--){
            int temp = a[i] - '0';
            result += (Math.pow(2, flag) * temp);
            flag++;
        }
        return result;
    }
    
    public String addBinary(String a, String b) {
        int sum = two2ten(a) + two2ten(b);
        if(sum==0)
            return "0";
        String result = "";
        while(sum!=0){
            result += ( sum%2 + "");
            sum/=2;
        }
        return new StringBuffer(result).reverse().toString();
    }
}

//补全0之后再按位求和
class Solution {
    public String addBinary(String a, String b) {
        int addZeroLen = Math.max(a.length(), b.length()) - Math.min(a.length(), b.length());
        
        //补全0
        if(a.length()<b.length()){
            for(int i=0;i<addZeroLen;i++)
                a = "0" + a;
        }else{
            for(int i=0;i<addZeroLen;i++)
                b = "0" + b;
        }
        
        StringBuffer ans = new StringBuffer();
        String result = "";
        int carry = 0;
        
        for(int i=a.length()-1;i>=0;i--){
            int tempA = a.charAt(i) - '0';
            int tempB = b.charAt(i) - '0';
            int cur = (tempA + tempB + carry)%2;
            carry = (tempA + tempB + carry)/2;
            result = cur + result;
        }
        
        if(carry==1){
            result = "1" + result;
        }
        
        return result;
    }
}

