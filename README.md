做算法题真的很为难我这个猪脑子( ¯(∞)¯ )

越辣鸡越要练啊大哥

がんばって(ง •_•)ง

🎈

| 题号 | 注意点 |  
| :----:|:----:|  
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


