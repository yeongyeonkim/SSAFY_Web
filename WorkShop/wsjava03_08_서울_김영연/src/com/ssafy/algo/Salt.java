package com.ssafy.algo;
import java.util.Scanner;

public class Salt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TestCase = sc.nextInt();
		for (int t = 1; t <= TestCase; t++) {
			int flag = 0;
			int first_salt = 0;
			int n = sc.nextInt();
			int[][] pond = new int[n][n];
			int s = sc.nextInt();
			for (int i = 1; i <= s; i++) {// 소금쟁이 수 만큼
				int x = sc.nextInt();
				int y = sc.nextInt();
				int dir = sc.nextInt();
				if (dir == 2) {// →
					int[] d = {0,3,5,6};
					for(int j=0; j<d.length; j++) {
						if(y+d[j]+1 >= n)
							break;
						if(pond[x][y+d[j]] == 0)
							pond[x][y+d[j]] = 1;
					}
//					if (pond[x][y] == 0 && pond[x][y + 3] == 0 && pond[x][y + 5] == 0 && pond[x][y + 6] == 0) {
//						pond[x][y] = pond[x][y + 3] = pond[x][y + 5] = pond[x][y + 6] = 1;
//					} // 밟지 않았다면 1로 바꿈
					else { // 하나라도 1의 값이 있는 경우
						if (flag == 0) {
							flag = 1;
							first_salt = s;
						}
					}
				} else { // ↓
					if (pond[x][y] == 0 && pond[x + 3][y] == 0 && pond[x + 5][y] == 0 && pond[x + 6][y] == 0) {
						pond[x][y] = pond[x + 3][y] = pond[x + 5][y] = pond[x + 6][y] = 1;
					} // 밟지 않았다면 1로 바꿈
					else { // 하나라도 1의 값이 있는 경우
						if (flag == 0) {
							flag = 1;
							first_salt = s;
						}
					}
				}
			}
			if (flag == 1)
				System.out.println("#" + t + " " + first_salt);
			else
				System.out.println("#" + t + " 0");
		}
	}
}