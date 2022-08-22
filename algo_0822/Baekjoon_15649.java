package algo_0822;

import java.util.Scanner;

public class Baekjoon_15649 {
	static boolean[] visited;
	static int[] num;
	static StringBuilder sb = new StringBuilder();
	static void perm(int depth,int N, int M) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(num[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			num[depth] = i+1;
			perm(depth+1, N, M);
			visited[i] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		visited = new boolean[N];
		num = new int[M];
		perm(0,N, M);
		System.out.println(sb);
	}
}
