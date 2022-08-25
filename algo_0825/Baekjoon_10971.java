package algo_0825;

import java.util.*;
import java.io.*;

// 하나하나씩 전부 방문. 0~N-1시작해서 전부 방문 후 최소 값
public class Baekjoon_10971 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min;
	
	static void dfs(int start, int now, int cnt, int sum) {
		if (cnt == N && map[now][start] != 0) {
			sum += map[now][start];
			min = min > sum ? sum : min;
			return;
		}
		for (int i = 0; i < N; i++) {

			if (!visited[i]&&map[now][i] != 0) {
				visited[i] = true;
				dfs(start, i, cnt + 1, sum+map[now][i]);
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

		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, i, 1, 0);
			visited[i] = false;
		}
		System.out.println(min);
	}
}
