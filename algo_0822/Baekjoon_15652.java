package algo_0822;

import java.util.Scanner;

public class Baekjoon_15652 {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] save;
	static void comb(int depth, int start) {
		if(depth==M) {
			for(int i=0; i<M; i++) {
				sb.append(save[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			save[depth] = i+1;
			comb(depth+1, i);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		save = new int[M];
		comb(0,0);
		System.out.println(sb);
	}
}
