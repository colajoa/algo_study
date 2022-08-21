package algo_0819;

import java.util.*;
import java.io.*;

public class swea_3234 {
	static int N;
	static int[] weight;
	static int count;
	static boolean[] isSelected;

	static void dfs(int depth, int left, int right, int start) {
		// 탐색 완료시 횟수 + 1
		if (depth == N) {
			count += 1;
			return;
		}
		// 조합 + 순열
		for (int i = start; i < N; i++) {
			isSelected[depth] = true;
			dfs(depth + 1, left + weight[depth], right, i + 1);
			if (left + weight[depth] >= right) {
				dfs(depth + 1, left, right + weight[i + 1], i + 1);
			} else {
				return;
			}
			isSelected[depth] = false;
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
			token = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(token.nextToken());
			}

			count = 0;

			dfs(0, 0, 0, 0);
			System.out.println(count);
		}
	}
}
