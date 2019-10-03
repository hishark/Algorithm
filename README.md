做算法题真的很为难我这个猪脑子( ¯(∞)¯ )

越辣鸡越要练啊大哥(ง •_•)ง

LeetCode中文站子越做越好了 官方题解都很不错 讨论区也很多东西 好好刷题！

Q: Question

A: Answer

🎈

| 题号 | 注意点 |  
| :----:|:----:| 
|LEETCODE-28 [Q](https://leetcode-cn.com/problems/implement-strstr/) [A](https://github.com/hishark/Algorithm/blob/master/LEETCODE/28.%20%E5%AE%9E%E7%8E%B0strStr().java)|[字符串/双指针]重点是i-j|
|LEETCODE-27 [Q](https://leetcode-cn.com/problems/remove-element/) [A](https://github.com/hishark/Algorithm/blob/master/LEETCODE/27.%20%E7%A7%BB%E9%99%A4%E5%85%83%E7%B4%A0.java)|[数组/双指针]法一很简单，法二交换再释放有点意思|
|LEETCODE-20 [Q](https://leetcode-cn.com/problems/valid-parentheses/) [A](https://github.com/hishark/Algorithm/blob/master/LEETCODE/20.%20%E6%9C%89%E6%95%88%E7%9A%84%E6%8B%AC%E5%8F%B7.java)|[栈/字符串]递归结构的问题用栈解决方便的一批|
|LEETCODE-13 [Q](https://leetcode-cn.com/problems/roman-to-integer/) [A](https://github.com/hishark/Algorithm/blob/master/LEETCODE/13.%20罗马数字转整数.java)|[数学/字符串]HashMap|
|LEETCODE-9 [Q](https://leetcode-cn.com/problems/palindrome-number/) [A](https://github.com/hishark/Algorithm/blob/master/LEETCODE/9.%20%E5%9B%9E%E6%96%87%E6%95%B0.java)|[数学]倒转数字比较即可（不转换为字符串🙅‍♀️）|
|LEETCODE-66 [Q](https://leetcode-cn.com/problems/plus-one/) [A](https://github.com/hishark/Algorithm/blob/master/LEETCODE/66.%20%E5%8A%A0%E4%B8%80.java)|[数组]关键还是%=10啦|
|PATA1042|[模拟]取模问题| 
|PATA1046|[模拟]数组预处理|
|PATA1065|[模拟][溢出](https://coolshell.cn/articles/11466.html)|
|PATA1002|[模拟]a[e]=k e幂次 k系数|
|PATA1009|[模拟]一个数组能干的事没必要开俩数组|
|PATB1036|[图形打印]用round记得round((double)N/2)强制类型转换一下 四舍五入还可以用N/2+N%2|
|PATB1004|[查找元素]边输入边比较|
|PATB1028|[查找元素]特判/max的初始值设最小值，min的初始值设最大值|
|PATB1027|[图形打印]奇偶/floor ceil|
|PATA1031|[图形打印]多举几个例子找规律|
|PATB1022|[进制转换]十进制转D进制/除基求余法/dowhile|
|PATB1037|[进制转换]单位之间的关系可用常量来表示 方便计算|
|PATA1027|[进制转换]十进制有范围 可简化进制转换写法|
|PATA1058|[进制转换]进制加法 carry|
|PATB1021|[字符串处理]char当数字用的时候别忘记-'0'|
|PATB1031|[字符串处理]使用数组来建立映射关系会让代码简洁很多|
|PATB1014/PATA1061|[字符串处理]找到了之后记得break 想找的是第一个匹配的 不break就错啦|
|PATB1024/PATA1073|[字符串处理]找对位置关系就不难|
|PATB1048|[字符串处理]结果串ans一定要初始化为空字符串，不然会出现奇奇怪怪的结果</br>char转int char-'0' int转char int+'0'</br>char A[101]={0}是将整个字符串初始化为空值</br>memset(A, '0', sizeof(A))是把整个字符串初始化为“000....000”|
|PATA1005|[字符串处理]12345如果想从前往后输出直接用递归就好了|
|PATA1077|[字符串处理][C++如何输入含空格的字符串](https://blog.csdn.net/zhouhongkai06/article/details/79035005)</br>用getline之前要记得用getchar把换行符吸收掉~|
|PATB1015/PATA1062|[排序]重点在分类 分好类就不难了|
|PATA1012|[排序]排序的问题记得要单独处理第一名 第一名之后的人的名次是他前面的人数+1（分数相同时排名和上一个人的排名相同） 这一题now用的巧妙|
|PATA1028|[排序]char a[10]="hello";char b[10]="hello" a不等于b哦，a和b都是地址，判断两个字符串是否相等用strcmp|
|PATA1055|[排序]预处理可以显著降低查询的复杂度|
|PATB1029/PATA1084|[散列]hashtable长度一般直接设置为ASCII码的个数128即可|
|PATB1033|[散列]字符串输入可能为空 所以不能用cin 要用getline（坑了我半小时886）</br>bool数组初始值默认是false，全置为true用memset，直接bool flag[10]={true}只有第一个是true哦</br>int a[10]={0}可以全置为0，={1}无法全置为1|
|PATB1038|[散列]用cincout会超时，要用scanfprintf|
|PATB1039/PATA1092|[散列]change函数有点意思|
|PATB1042|[散列]输入有空格别用cin啊啊啊用getline（这次反应的快一点了）|
|PATA1050|[散列]这题用string会有两个测试点过不了 很奇怪 char[]没问题|
|PATA1048|[散列]i和m-i|
|PATA1037|[贪心]第二个循环注意是i和j 不要都写成i了|
|PATA1038|[贪心]string.erase/cmp是关键/前导0不确定个数 while别写成if|
|PATB1030/PATA1085|[二分]upper_bound返回的是指针，想获得下标要减去数组首地址|
|PATA1044|[二分]设sum[i]表示A[1]到A[i]的和，然后再求任意区间的连续序列和就很方便了。例如A3+A4+A5=sum[5]-sum[2]</br>upper_bound|
|PATB1040/PATB1045|“假如序列的每一位所需要计算的值都可以通过该位左右两侧的结果计算得到，那么久可以考虑所谓的[左右两侧的结果]是否能通过递推进行预处理得到”</br>int INF=0x3fffffff 一个很大的数</br>B1045如果最后不换行就会有一个测试点格式错误 注意一哈|
|PATA1008|[数学问题]now = to别忘记了|
|PATA1081|[数学问题]分数相加 规定只有分子可以为负 在输出和做运算时要注意绝对值的问题 算最大公约数也是算分子分母绝对值的最大公约数</br>顺便记一下，为了防止溢出不用lcm=a\*b/gcd，用lcm=a/gcd\*b（lcm最小公倍数 gcd最大公约数）|
|PATA1039|[stl-vector]用到了hash，将字符串转换成数字作为下标|
|PATA1047|[stl-vector]数据范围很大的情况一般最好用char数组来存放数据，用string很容易超时</br>这一题用cincout也会超时|
|PATA0163|[stl-set]统计数量的时候，很多情况下可以置初值为max，然后碰到不符合条件的就减一</br>printf("%.1f%")可输出百分比，如果要紧跟一个百分号的话再自己加一个%</br>st.find(value)!=st.end()为true就表示在st中找到了value|
|PATA1054|[stl-map]善用find()，贼方便|
|PATA1071|[stl-map]千万不要用cin输入string，因为输入有空格，要用getline(cin,string)啦|
|LEETCODE-1 [Q](https://leetcode-cn.com/problems/two-sum/) [A](https://github.com/hishark/Algorithm/blob/master/LEETCODE/1.%20两数之和.java) |暴力一时爽 还是用哈希表吧|
|PATA1052|[链表]静态链表/第三个参数注意别写成next了，已经排好序了所以直接输出下一个结点的address即可/记得特判|
|ReHeLu|int转string 用stringstream|
|PATA1103|[DFS]感觉最重要的一步还是预处理，以及字典序的要求可以直接靠从最大值开始遍历来解决|
