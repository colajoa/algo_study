package algo_0819;

import java.util.*;
import java.io.*;

public class swea_3234_2 {
	static int N;
	static int[] weight;
	static int count;
	static boolean[] isSelected;
	static int[] perm;

	// 부분집합
	static void dfs(int depth, int left, int right) {
		// 탐색 완료시 횟수 + 1
		if (depth == N) {
			count += 1;
			return;
		}
		
			dfs(depth + 1, left + perm[depth], right);
			if (left >= right + perm[depth]) { 
			dfs(depth + 1, left, right + perm[depth]);
			}
	}

	// 순열
	static void perm(int depth) {
		if (depth == N) {
			dfs(0, 0, 0);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			perm[depth] = weight[i];
			perm(depth + 1);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			isSelected = new boolean[N];
			perm = new int[N];
			
			token = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(token.nextToken());
			}

			count = 0;

			perm(0);
			sb.append("#").append(t).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
}
