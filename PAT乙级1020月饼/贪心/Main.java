package com.example.a777.pat_basic_level.PAT乙级1020月饼.贪心;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * Created by 777 on 2018/3/28.
 * 妈呀我爱Bufferreader！！！！！！！！不会超时了！！！！！！！！
 * 100ms都不会超时了！！！！！！！！！！！！
 */

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bf.readLine();
        String par1[] = input1.split(" ");
        int N = Integer.parseInt(par1[0]);
        int D = Integer.parseInt(par1[1]);

        double stock[] = new double[N];
        double price[] = new double[N];
        double unitPrice[] = new double[N];

        String input2 = bf.readLine();
        String par2[] = input2.split(" ");

        for(int i=0;i<N;i++){
            stock[i] = Double.parseDouble(par2[i]);

        }

        String input3 = bf.readLine();
        bf.close();
        String par3[] = input3.split(" ");

        for(int i=0;i<N;i++){
            price[i] = Double.parseDouble(par3[i]);
        }

        for(int i=0;i<N;i++){
            unitPrice[i] = price[i]/stock[i];
        }

        MoonCake cake[] = new MoonCake[N];
        for(int i=0;i<N;i++){
            cake[i] = new MoonCake();
            cake[i].price = price[i];
            cake[i].stock = stock[i];
            cake[i].uniteprice = unitPrice[i];
        }

        Arrays.sort(cake);

        double maxMoney = 0;

        for(int i=0;i<N;i++){
            if(cake[i].stock>=D){
                maxMoney += (double)D*cake[i].uniteprice;
                break;
            }else{
                maxMoney += (double)cake[i].stock*cake[i].uniteprice;
                D -= cake[i].stock;
            }
        }

        System.out.printf("%.2f\n",maxMoney);



    }


}
class MoonCake implements Comparable{
    double stock;
    double price;
    double uniteprice;
    @Override
    public int compareTo(Object arg0) {
        // TODO Auto-generated method stub
        MoonCake mc = (MoonCake)arg0;
        return (uniteprice<mc.uniteprice)?1:-1;
    }
}