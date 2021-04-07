// 排序
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}

// 堆
// ref:
// https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/zui-xiao-de-kge-shu-by-leetcode-solution/
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 数组中最小的 k 个数
        int[] ans = new int[k];

        // 判空
        if (k == 0)
            return ans;

        /**
         * Java中默认的为小根堆，实现大根堆需要重写一下 Comparator 题目要求前 k 小的数字，所以需要使用一个容量为 k 的大根堆
         * 
         * 遍历数组的时候，若堆的大小小于 k，就直接把数字放进去 若堆的大小已经为 k，需要判断当前数字和堆顶数字的大小： 
         * 1. 若当前数字 >= 堆顶数字，那么这个数就直接跳过 
         * 2. 若当前数字 < 堆顶数字，那么就先把堆顶数字 poll 掉，然后把当前数字放入堆中
         * 
         */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });

        // ⬆️ 即：PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((x, y) -> (y - x));

        // 首先，先把数字的前 k 个数字全部怼入堆中
        for (int i = 0; i < k; i++) {
            maxHeap.offer(arr[i]);
        }

        // 接着继续遍历数组中剩下的数字
        for (int i = k; i < arr.length; i++) {
            // 如果「当前遍历的数字」 <「堆顶数字」
            if (maxHeap.peek() > arr[i]) {
                // 就把堆顶数字送出去
                maxHeap.poll();
                // 并把当前数字放入堆中
                maxHeap.offer(arr[i]);
            }
            // 如果「当前遍历的数字」 >=「堆顶数字」，直接跳过即可
        }

        // 此时，大根堆中已经存好了前 k 小的数字们，放入结果数组即可
        for (int i = 0; i < k; i++)
            ans[i] = maxHeap.poll();

        return ans;
    }
}
//read : 1

// 快排
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 首先做一下判空
        if ((k == 0) || (arr.length == 0)) {
            return new int[0];
        }

        // 通过快排切分排好第 K 小的数（下标为 K-1），那么它左边的数就是比它小的另外 K-1 个数。
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSort(arr, 0, arr.length - 1, k - 1);
    }

    // 快速排序
    private int[] quickSort(int[] nums, int left, int right, int k) {
        // 每切分1次，找到排序后下标为pivot的元素，
        int pivot = partition(nums, left, right);

        // 如果pivot恰好等于k就返回pivot以及pivot左边所有的数。（左边的数都比pivot小）
        if (pivot == k) {
            return Arrays.copyOf(nums, pivot + 1);
        }

        // 否则根据下标pivot与k的大小关系来决定继续切分左段还是右段。
        // pivot更大，说明k在pivot的左边，所以继续切分左边
        // pivot更小，说明k在pivot的右边，所以继续切分右边
        return (pivot > k) ? quickSort(nums, left, pivot - 1, k)
                           : quickSort(nums, pivot + 1, right, k);
    }

    public int partition(int[] arr, int left, int right) {
        //一般设置最左边的为基准数
        int pivotKey = arr[left];

        //基准数的位置
        int pivotPointer = left;

        //右指针找比基准数小的，左指针找比基准数大的，然后进行交换
        while (left < right) {
            // 先移动右指针，原因http://www.cnblogs.com/wxisme/p/5243631.html
            while ((left < right) && (arr[right] >= pivotKey)) {
                right--;
            }

            //↑右指针找到了第一个比基准数小的数，就停止循环，并把小的数移动到左边
            arr[left] = arr[right];

            while ((left < right) && (arr[left] <= pivotKey)) {
                left++;
            }

            //↑左指针找到了第一个比基准数大的数，就停止循环，并把大的数移动到右边
            arr[right] = arr[left];
        }

        //把基准值赋值给两个指针碰头的地方，也就是中间
        // 退出上面循环的时候，left=right
        arr[left] = pivotKey; //所以left换成right是一样的

        //把这个位置返回，以给下一次划分使用，划分左半边就-1，划分右半边就+1
        return left; //这里换成right也ok
    }
}
