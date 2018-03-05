package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * String.next()这个输入的字符串不可以包括空格
 * String.nextLine()这个输入的字符串可以包括空格
 * 
 * cin.nextLine()完美解决问题了哈哈哈哈哈哈
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			
			/*
			 * 最重要滴一句
			 */
			cin.nextLine();
			
			String str[] = new String[n];
			for(int i=0;i<n;i++){
				str[i] = cin.nextLine();
				char s[]=str[i].toCharArray();
				boolean isLegal=true;
				for(int j=0;j<s.length;j++){
			          if(j>0&&s[j]<='9'&&s[j]>='0'){
			             continue;
			          }
			        if(s[j]=='_'||s[j]>='A'&&s[j]<='z'||s[j]>='a'&&s[j]<='z'){
			            continue;
			        }
			        //除了上面的情况 其他情况都是不合法的！
			        isLegal=false;
			        break;
			    }
				if(isLegal){
					System.out.println("yes");
				}else{
					System.out.println("no");
				}
				
			} 
		}
	}
}
