package algo_0818;

import java.util.Scanner;

public class Baekjoon_9663 {
	static int N;
	static int count;
	static int[] queen;
	static void setQueen(int row) {
		if(row == N) {
			count += 1;
			return;
		}
		
		for(int c=0; c<N; c++) {
			queen[row] = c;
			boolean check = true;
			for(int i=0; i<row; i++) {
				if(queen[row] == queen[i] || Math.abs(queen[row]- queen[i]) == row-i) {
					check = false;
					break;
				}
			}
			if(check) {
				setQueen(row+1);
			}
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		queen = new int[N];
		count = 0;
		
		setQueen(0);
		System.out.println(count);
	}
}
