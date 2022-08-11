package algo_0811;

import java.util.Scanner;

public class Baekjoon_3040 {
	//comb(시작, 뽑은 횟수, 점수);
	static void comb(int start, int cnt, int sum) {
		if(cnt == 7) {
			if(sum==100) {
				for(int i=0; i<7; i++) {
					System.out.println(num[i]);
				}
			}
			//아니면 탈출
			return;
		}
		
		for(int i=start; i<9; i++) {
			//숫자 선택
			num[cnt] = p[i];
			//다음 숫자 선택
			comb(i+1,cnt+1, sum+p[i]);
		}
		
	}
	static int[] p;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		p = new int[9];
		num = new int[7];
		for(int i=0; i<9; i++) {
			p[i] = sc.nextInt();
		}
		comb(0,0,0);
	}
}
