package com.ssafy.java;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int r;

		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.println("번호를 입력하세요. ");
		int number = sc.nextInt();
		int count = 0;
		String str = new String();
		switch (number) {
		case 1:
			for (int i = 0; i < 5; i++) {
				System.out.print("가위바위보 중 하나 입력:");
				str = sc.next();
				r = (int) (Math.random() * 3) + 1;
				switch (str) {
				case "가위":
					if (r == 1) {
						System.out.println("비겼습니다!!!");
					} else if (r == 2) {
						System.out.println("졌습니다!!!");
						count--;
					} else {
						System.out.println("이겼습니다!!!");
						count++;
					}
					break;
				case "바위":
					if (r == 1) {
						System.out.println("이겼습니다!!!");
						count++;
					} else if (r == 2) {
						System.out.println("비겼습니다!!!");
					} else {
						System.out.println("졌습니다!!!");
						count--;
					}
					break;
				case "보":
					if (r == 1) {
						System.out.println("졌습니다!!!");
						count--;
					} else if (r == 2) {
						System.out.println("이겼습니다!!!");
						count++;
					} else {
						System.out.println("비겼습니다!!!");
					}
					break;
				}
			}
			if (count >= 1) {
				System.out.println("### 사용자 승!!!");
				break;
			}
			else if(count ==0) {
				System.out.println("### 무승부입니다!!!");
				break;
			}
			else {
				System.out.println("### 컴퓨터 승!!!");
				break;
			}
		case 2:
			for (int i = 0; i < 3; i++) {
				System.out.print("가위바위보 중 하나 입력:");
				str = sc.next();
				r = (int) (Math.random() * 3) + 1;
				switch (str) {
				case "가위":
					if (r == 1) {
						System.out.println("비겼습니다!!!");
					} else if (r == 2) {
						System.out.println("졌습니다!!!");
						count--;
					} else {
						System.out.println("이겼습니다!!!");
						count++;
					}
					break;
				case "바위":
					if (r == 1) {
						System.out.println("이겼습니다!!!");
						count++;
					} else if (r == 2) {
						System.out.println("비겼습니다!!!");
					} else {
						System.out.println("졌습니다!!!");
						count--;
					}
					break;
				case "보":
					if (r == 1) {
						System.out.println("졌습니다!!!");
						count--;
					} else if (r == 2) {
						System.out.println("이겼습니다!!!");
						count++;
					} else {
						System.out.println("비겼습니다!!!");
					}
					break;
				}
			}
			if (count >= 1) {
				System.out.println("### 사용자 승!!!");
				break;
			}
			else if(count ==0) {
				System.out.println("### 무승부입니다!!!");
				break;
			}
			else {
				System.out.println("### 컴퓨터 승!!!");
				break;
			}
		case 3:
			for (int i = 0; i < 1; i++) {
				System.out.print("가위바위보 중 하나 입력:");
				str = sc.next();
				r = (int) (Math.random() * 3) + 1;
				switch (str) {
				case "가위":
					if (r == 1) {
						System.out.println("비겼습니다!!!");
					} else if (r == 2) {
						System.out.println("졌습니다!!!");
						count--;
					} else {
						System.out.println("이겼습니다!!!");
						count++;
					}
					break;
				case "바위":
					if (r == 1) {
						System.out.println("이겼습니다!!!");
						count++;
					} else if (r == 2) {
						System.out.println("비겼습니다!!!");
					} else {
						System.out.println("졌습니다!!!");
						count--;
					}
					break;
				case "보":
					if (r == 1) {
						System.out.println("졌습니다!!!");
						count--;
					} else if (r == 2) {
						System.out.println("이겼습니다!!!");
						count++;
					} else {
						System.out.println("비겼습니다!!!");
					}
					break;
				}
			}
			if (count >= 1) {
				System.out.println("### 사용자 승!!!");
				break;
			}
			else if(count ==0) {
				System.out.println("### 무승부입니다!!!");
				break;
			}
			else {
				System.out.println("### 컴퓨터 승!!!");
				break;
			}
		}

	}

}
