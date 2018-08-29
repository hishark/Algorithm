package com.example.a777.pat_basic_level.PAT乙级1016部分A加B_字符串处理;

import java.util.Scanner;

/**
 * Created by 777 on 2018/3/28.
 */

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()){
            String A = cin.next();
            String DA = cin.next();
            String B = cin.next();
            String DB = cin.next();
            char da = DA.toCharArray()[0];
            char db = DB.toCharArray()[0];
            char a[] = A.toCharArray();
            char b[] = B.toCharArray();

            int countA = 0;
            for(int i=0;i<a.length;i++){
                if(a[i]==da)
                    countA++;
            }

            int countB = 0;
            for(int i=0;i<b.length;i++){
                if(b[i]==db)
                    countB++;
            }

            //int unitA = Integer.parseInt(da+"");
            //int unitB = Integer.parseInt(db+"");

            String resultA = "";
            for(int i=0;i<countA;i++){
                resultA+=da;
            }


            String resultB = "";
            for(int i=0;i<countB;i++){
                resultB+=db;
            }
            int rA,rB;
            if(!resultA.equals(""))
                rA = Integer.parseInt(resultA);
            else
                rA=0;
            if (!resultB.equals(""))
                rB = Integer.parseInt(resultB);
            else
                rB=0;

            int result = rA+rB;

            System.out.println(result);

        }
    }


}
