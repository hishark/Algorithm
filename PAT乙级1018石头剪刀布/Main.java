package com.example.a777.pat_basic_level.PAT乙级1018石头剪刀布;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Scanner;

/**
 * Created by 777 on 2018/3/28.
 */

/**
 * 用bf只有一个用例会超时哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
 * bf无敌哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
 */

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        //Scanner cin = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        //int N = cin.nextInt();
        int jiaHand[] = new int[]{0,0,0};
        int yiHand[] = new int[]{0,0,0};
        int win=0,draw=0,fail=0;
        for(int i=0;i<N;i++){
            /**
             * Scanner
             */
            //String s1 = cin.next();
            //String s2 = cin.next();
            //char jia = s1.charAt(0);
            //char yi = s2.charAt(0);

            /**
             * BufferReader
             */
            String input = bf.readLine();
            String part[] = input.split(" ");
            char jia = part[0].charAt(0);
            char yi = part[1].charAt(0);




            if(jia==yi&&jia=='C'){
                draw++;

            }
            if(jia==yi&&jia=='J'){
                draw++;

            }
            if(jia==yi&&jia=='B'){
                draw++;

            }



            if(jia=='C'&&yi=='J'){
                win++;
                jiaHand[1]++;

            }

            if(jia=='J'&&yi=='B'){
                win++;
                jiaHand[2]++;

            }

            if(jia=='B'&&yi=='C'){
                win++;
                jiaHand[0]++;

            }

            if(yi=='C'&&jia=='J'){
                fail++;

                yiHand[1]++;
            }

            if(yi=='J'&&jia=='B'){
                fail++;

                yiHand[2]++;
            }

            if(yi=='B'&&jia=='C'){
                fail++;

                yiHand[0]++;
            }



        }


        System.out.println(win+" "+draw+" "+fail);
        System.out.println(fail+" "+draw+" "+win);

        //jiamax用来存下标！
        //千万别忘了是大于等于！！
        int jiamax = jiaHand[0]>=jiaHand[1]?0:1;
        jiamax = jiaHand[jiamax]>=jiaHand[2]?jiamax:2;

        int yimax =yiHand[0]>=yiHand[1]?0:1;
        yimax = yiHand[yimax]>=yiHand[2]?yimax:2;

        //人工排序好再做就很方便了
        String result = "BCJ";
        char r[] = result.toCharArray();
        System.out.println(r[jiamax]+" "+r[yimax]);
    }


}
