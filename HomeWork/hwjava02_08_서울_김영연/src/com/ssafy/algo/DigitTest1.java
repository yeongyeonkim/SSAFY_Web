package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] number = new int[10];
		int n;
		while(true) {
			n = sc.nextInt();
			if(n == 0)
				break;
			if(n < 10)
				number[0]++;			
			else 
			number[n/10]++;			
		}
		for(int i=0; i<=9; i++) {
			if(number[i] != 0)
				System.out.println(i+" : "+number[i]+"개");
		}
	}
}
