//甜姐题解
//https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
//模拟链表
class Solution {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int index = 0;
        while(n>1){
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
}
//约瑟夫环问题 - 数学解法
class Solution {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for(int i=2;i<=n;i++){
            ans = (ans+m)%i;
        }
        return ans;
    }
}
//这个方法可行，但是超时啦！
class Solution {
    public int lastRemaining(int n, int m) {
        //新建一个数组存下所有的数字
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = i;
        }
        //如果只有一个数字，直接返回最后一个值
        if(m==1){
            return a[n-1];
        }
        //剩余数字的个数
        int count = n;
        //指示当前是第几个数字
        int index = 1;

        int i = 0;
        while(true){
            //a[i]==-1视为数字已删除
            //如果数字未删除且当前是第m个数字，就删除
            //剩余数字的个数减1
            //index重新开始计数
            if(a[i]!=-1 && index == m){
                a[i]=-1;
                count--;
                index = 1;
            }
            
            //如果数字未删除，并且index还未增至m。继续加一
            if(a[i]!=-1 && index != m){
                index++;
            }

            //如果数字未删除且只剩下一个数字，那么这个数字就是最终结果
            if(a[i]!=-1 && count == 1){
                return a[i];
            }

            i++;
            //求余保证i不会超过n
            i %= n;  
        }
            
    }
}