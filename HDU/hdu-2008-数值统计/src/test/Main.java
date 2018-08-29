package test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        int n;
        while(cin.hasNext()){
            n = cin.nextInt();
            int NegNum = 0;
            int ZeroNum = 0;
            int PosNum = 0;
            if(n==0)
                break;
            for(int i=0;i<n;i++){
                double x = cin.nextDouble();
                if(x<0){
                    NegNum++;
                }else if(x>0){
                    PosNum++;
                }else{
                    ZeroNum++;
                }
            }
            System.out.println(NegNum+" "+ZeroNum+" "+PosNum);
        }
    }

}
