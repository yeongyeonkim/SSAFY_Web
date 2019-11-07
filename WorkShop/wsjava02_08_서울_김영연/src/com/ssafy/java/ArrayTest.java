package com.ssafy.java;

import java.util.Scanner;

public class ArrayTest {

	static int[] list;
	
	static void input() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //배열의 길이
		list = new int[n];
		for(int i=0; i<n; i++)
			list[i] = sc.nextInt();
		//console로 부터 입력값을 받아서 배열에 저장
	}
	static void print() {
		for(int i=0; i<list.length; i++)
			System.out.print(list[i] + " ");	
		System.out.println();
	}
	static void total() {
		int sum = 0;
		for(int i=0; i<list.length; i++) {
			sum += list[i];
		}
		System.out.println("배열의 합 : " + sum);
	}
	static void average() {
		int sum = 0;
		for(int i=0; i<list.length; i++) {
			sum += list[i];
		}
		System.out.println("배열의 평균 : " + (sum/list.length));
	}
	static void minimum() {
		selectionSort(list);
		System.out.println("배열의 최소값 : " + list[0]);
	}
	static void selectionSort(int[] list) {
		for(int i=0; i<list.length-1; i++) {
			for(int j=i; j<list.length; j++) {
				if(list[i] > list[j]) {
					int tmp = list[j];
					list[j] = list[i];
					list[i] = tmp;
				}
			}			
		}
	}
	
	public static void main(String[] args) {
		input();
		print();
		total();
		average();
		minimum();
	}

}
