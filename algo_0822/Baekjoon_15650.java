package algo_0822;

import java.util.Scanner;

public class Baekjoon_15650 {
	static StringBuilder sb = new StringBuilder();
	static void comb(int depth, int start,int N, int M, int[] save) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(save[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++ ) {
			save[depth] = i+1;
			comb(depth+1, i+1,N,M, save);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] save = new int[M];
		comb(0, 0, N, M, save);
		System.out.println(sb);
	}
}
