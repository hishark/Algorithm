package test;

import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
/*
 * ���˺þ�ʱ��Ŷ�����
��һ��ʼ�������Լ���
Ȼ����һ���˼·
Ȼ����������
Ȼ��ȥ���
�������ջ��

��ð������ϰ��һ��
�����򵥵����򷽷�
ѡ�ε�ʱ����ô��ȥ��һ��Ŷ�������
300��Ǯ���������
���ѡ��ͨ����
���ƶ�������ˢ���˰ɹ�������

Ȼ����������Ŀ
���е��������
printf \n���оͻ�GG

java��û�нṹ���Ҫ������bean����

���⻹��һ���Ӿ�����Ŀ�ᵽ��non-negative�Ǹ���
��Ȼ�ǷǸ����͵�Ȼ����0��������
һ��Ҫ���ǳ���0Ҫ��ô��
�м��м�
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
            // �Ž�һ���������ˣ��������ͽ�������
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
            // �ź����˹���������������������������������Ȼ��ʼ����
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
            // ��BigDecimal����С������λ û����
            /*
             * String max=String.valueOf(maxsum); BigDecimal bd = new
             * BigDecimal(max); bd = bd.setScale(3,BigDecimal.ROUND_HALF_UP);
             * System.out.println(bd);
             */
            // һ��Ҫ�������� �����printf����\n���о�gg
            System.out.printf("%.3f", maxsum);
            System.out.println();
            M = cin.nextInt();
            N = cin.nextInt();
        }
    }

	

}
