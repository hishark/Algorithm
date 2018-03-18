package test;

import java.util.Scanner;
/*
 * 柳哥的代码还是稳
 * 又简单又有效
 * 
 * ASCII码在0~255之间
 * 拿一个数组来标记就可以了
 * 这下才255个绝对不会超时啦！
 */
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int ascii[] = new int[256];
		String A = cin.nextLine();
		String B = cin.nextLine();
	 
		
		for(int i=0;i<B.length();i++){
			ascii[B.charAt(i)]=1;
		}
		
		
		for(int i=0;i<A.length();i++){
			//这一行报错 很迷
			if(ascii[A.charAt(i)]==1){
				continue;
			}
			System.out.print(A.charAt(i));
		}
	}
}

/*
 *柳哥的代码没错啦 
#include <iostream>
using namespace std;
int book[256];
int main() {
    string s, a;
    getline(cin, s);
    getline(cin, a);
    for(int i = 0; i < a.length(); i++) {
        book[a[i]] = 1;
    }
    for(int i = 0; i < s.length(); i++) {
        if(book[s[i]] == 1) {
            continue;
        }
        cout << s[i];
    }
    return 0;
}*/


/*
 * 方法我觉得很完美但是超时啦！
 * */
/*public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		String A = cin.nextLine();
		String B = cin.nextLine();
		for(long i=0;i<A.length();i++){
			for(long j=0;j<B.length();j++){
				int I = (int)i;
				int J = (int)j;
				if(A.charAt(I)==B.charAt(J)){
					A = removeCharAt(A, I);
				}
			}
		}
		System.out.println(A);
		
	}
	public static String removeCharAt(String s,long pos){
		int POS=(int)pos;
		return s.substring(0,POS)+s.substring(POS+1);
	}

}*/
