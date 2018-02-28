package test;

import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
/*
 * 花了好久时间哦这道题
从一开始不打算自己做
然后有一点点思路
然后遇到问题
然后去解决
还是有收获的

把冒泡排序复习了一遍
超级简单的排序方法
选拔的时候怎么不去做一下哦你这个猪
300块钱买个进步啦
如果选拔通过了
估计都不会来刷题了吧哈哈哈哈

然后就是这个题目
换行的问题很贼
printf \n换行就会GG

java里没有结构体就要利用起bean啦！

另外还有一个坑就是题目提到了non-negative非负数
既然是非负数就当然会有0的问题了
一定要考虑出现0要怎么办
切记切记
 */
	static class Room {
        int catneed;
        double per;
        public int getCatneed() {
            return catneed;
        }
        public void setCatneed(int catneed) {
            this.catneed = catneed;
        }
        public double getPer() {
            return per;
        }
        public void setPer(double per) {
            this.per = per;
        }
    }
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int M, N;
        M = cin.nextInt();
        N = cin.nextInt();
        while (M >= 0 && N >= 0) {
            int J[] = new int[N];
            int F[] = new int[N];
            for (int i = 0; i < N; i++) {
                J[i] = cin.nextInt();
                F[i] = cin.nextInt();
            }
            double perprice[] = new double[N];
            for (int i = 0; i < N; i++) {
                if (F[i] == 0) {
                    perprice[i] = J[i];
                } else {
                    perprice[i] = (double) J[i] / F[i];
                }
            }
            Room r[] = new Room[N];
            for (int i = 0; i < N; i++) {
                r[i] = new Room();
            }
            for (int i = 0; i < N; i++) {
                r[i].setPer(perprice[i]);
                r[i].setCatneed(F[i]);
            }
            // 放进一个数组里了，接下来就进行排序
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (r[i].getPer() < r[j].getPer()) {
                        Room temp = new Room();
                        temp = r[i];
                        r[i] = r[j];
                        r[j] = temp;
                    }
                }
            }
            // 排好序了哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈然后开始计算
            int currentM = M;
            double maxsum = 0;
            for (int i = 0; i < N; i++) {
                if (r[i].getCatneed() <= currentM) {
                    if (r[i].getCatneed() == 0) {
                        maxsum += r[i].getPer();
                    } else {
                        maxsum += (double) r[i].getPer() * r[i].getCatneed();
                    }
                    currentM -= r[i].getCatneed();
                } else {
                    maxsum += (double) currentM * r[i].getPer();
                    currentM = 0;
                    continue;
                }
            }
            // 用BigDecimal保留小数后三位 没问题
            /*
             * String max=String.valueOf(maxsum); BigDecimal bd = new
             * BigDecimal(max); bd = bd.setScale(3,BigDecimal.ROUND_HALF_UP);
             * System.out.println(bd);
             */
            // 一定要这样换行 如果在printf里用\n换行就gg
            System.out.printf("%.3f", maxsum);
            System.out.println();
            M = cin.nextInt();
            N = cin.nextInt();
        }
    }

	

}
