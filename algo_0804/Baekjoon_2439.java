package ssafy_study;

import java.util.Scanner;

public class Baekjoon_2439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			for(int j=N-1; j>-1; j--) {
				if(i<j) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.println();
		}
	}
}
