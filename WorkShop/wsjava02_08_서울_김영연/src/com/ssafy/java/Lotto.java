package com.ssafy.java;

import java.util.Random;

public class Lotto {

	public static void main(String[] args) {

		Random r = new Random();
		int tmp = 0;
		int[] number = new int[46];
		for(int i=0; i<6; i++) {
			tmp = r.nextInt(45) + 1;
			if(number[tmp] == 0)
				number[tmp]++;
			else 
				i--;
		}
		for(int i=0; i<=45; i++) {
			if(number[i] == 1)
				System.out.print(i+" ");
		}
	}

}
