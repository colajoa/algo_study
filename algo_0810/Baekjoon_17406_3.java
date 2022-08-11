package algo_0810;

import java.util.Scanner;

public class Baekjoon_17406_3 {

	static void dfs(int idx, int c) {
		if (idx == c) {
			int[][] rotmap = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					rotmap[i][j] = map[i][j];
				}
			}
			rotate(rotmap);
			return;
		}

		for (int i = 0; i < K; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			perm[idx] = i;
			dfs(idx + 1, c);
			visited[i] = false;
		}
	}

	static void rotate(int[][] rotmap) {
		int lx;
		int ly;
		int rx;
		int ry;
		for (int p : perm) {
			lx = rcs[p][0] - rcs[p][2] - 1;
			ly = rcs[p][1] - rcs[p][2] - 1;
			rx = rcs[p][0] + rcs[p][2] - 1;
			ry = rcs[p][1] + rcs[p][2] - 1;
	
			int n = rx - lx;
			int m = ry - ly;
			int sq = Math.min(n, m) / 2;

			for (int idx = 0; idx < sq; idx++) {
				lx += idx;
				ly += idx;
				rx -= idx;
				ry -= idx;
				int tmp = rotmap[lx][ly];
				// 하 -> 상
				for (int i = lx; i < rx; i++) {
					rotmap[i][ly] = rotmap[i + 1][ly];
				}
				// 오 -> 왼
				for (int i = ly; i < ry; i++) {
					rotmap[rx][i] = rotmap[rx][i + 1];
				}
				// 상 -> 하
				for (int i = rx; i > lx; i--) {
					rotmap[i][ry] = rotmap[i - 1][ry];
				}
				// 왼 -> 오
				for (int i = ry; i > ly; i--) {
					rotmap[lx][i] = rotmap[lx][i - 1];
				}
				rotmap[lx][ly + 1] = tmp;
				
				
			}
		}
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += rotmap[i][j];
			}
			min = Math.min(min, sum);
		}
	}

	static int N, M, K;
	static int[][] rcs;
	static boolean[] visited;
	static int[][] map;
	static int[] perm;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// r, c, s를 담을 배열
		rcs = new int[K][3];

		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			// r,c,s 순서대로 저장
			rcs[i] = new int[] { r, c, s };
		}

		// 순열 담을 배열
		perm = new int[K];
		// 번호 방문 여부
		visited = new boolean[K];
		dfs(0, K);
		System.out.println(min);
	}
}
