package test;

import java.util.Scanner;
/*
 * 蓝桥杯2017第二题
 * 暴力枚举
 * 哎卧槽这代码好丑哦OTZ
 */
public class Main {

	public static void main(String[] args) {
		int a,b,c,d,e,f,g,h,i,sum=0;
		for(a=1;a<=9;a++){
			for(b=1;b<=9;b++){
				for(c=1;c<=9;c++){
					for(d=1;d<=9;d++){
						for(e=1;e<=9;e++){
							for(f=1;f<=9;f++){
								for(g=1;g<=9;g++){
									for(h=1;h<=9;h++){
										for(i=1;i<=9;i++){
											if(a+b+c+d==d+e+f+g&&d+e+f+g==a+i+h+g){
												if(a!=b&&a!=c&&a!=d&&a!=e&&a!=f&&a!=g&&a!=h&&a!=i){
													if(b!=c&&b!=d&&b!=e&&b!=f&&b!=g&&b!=h&&b!=i){
														if(c!=d&&c!=e&&c!=f&&c!=g&&c!=h&&c!=i){
															if(d!=e&&d!=f&&d!=g&&d!=h&&d!=i){
																if(e!=f&&e!=g&&e!=h&&e!=i){
																	if(f!=g&&f!=h&&f!=i){
																		if(g!=h&&g!=i){
																			if(h!=i){
																				sum++;
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		/*
		 * 2-镜像
		 * 3-旋转
		 */
		System.out.println(sum/2/3);
	}

}
