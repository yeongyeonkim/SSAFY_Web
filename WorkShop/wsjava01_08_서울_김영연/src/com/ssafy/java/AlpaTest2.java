package com.ssafy.java;

public class AlpaTest2 {
	public static void main(String args[]) {
		char a = 'A';
		for (int i = 5; i >= 1; i--) {
			for(int j=2*(i-1); j>=1; j--) {
			System.out.print(" ");
			}
			for (int j = 5-i; j >= 0; j--) {
				System.out.print(" "+a);
				a++;
			}
			System.out.println();
		}
	}
}
