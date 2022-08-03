package study;

import java.util.Scanner;

public class Baekjoon_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		while (N != 0) {
			if(N<2) {
				cnt = -1;
				break;
			}

			if (N % 5 == 0) {
				cnt += N / 5;
				break;
			}

			N -= 3;
			cnt += 1;
		}
		System.out.println(cnt);
	}	
}
