package algo_0825;

import java.util.*;
import java.io.*;
// 2번에 조건만 넣은 것 -> sum <= min 만족하면  dfs 아니면 원래 상태로 돌아간다.
public class Baekjoon_10971_3 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min;

	static void dfs(int start, int now, int cnt, int sum) {
		if (cnt == N && start == now) {
			min = min > sum ? sum : min;
			return;
		}
		for (int i = 0; i < N; i++) {

			if (!visited[i]&&map[now][i] != 0) {
				visited[i] = true;
				sum += map[now][i];
	
				if (sum <= min) {
					dfs(start, i, cnt + 1, sum);
				}
				sum -= map[now][i];
				visited[i] = false;
				
			}
		}

	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		visited = new boolean[N];

		
			dfs(0, 0, 0, 0);
		
		System.out.println(min);
	}
}
