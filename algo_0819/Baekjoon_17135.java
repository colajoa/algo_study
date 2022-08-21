package algo_0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_17135 {

	static int[][] map;
	static int[][] copyMap;
	static boolean[] visited;
	static int[] temp;
	static int N, M, D;
	static int ans = Integer.MIN_VALUE;

	static void comb(int start, int depth) {
		if (depth == 3) {
			defense();
			return;
		}
		for (int i = 0; i < M; i++) {
			map[N][i] = 2;
			comb(i + 1, depth + 1);
			map[N][i] = 0;
		}
	}

	static void defense() {

		Queue<int[]> q = new ArrayDeque<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0)
					continue;
				int minDis = D, y = N, x = M;

				for (int k = Math.max(0, N - D); k < N; k++) {
					for (int l = Math.max(0, j - D); l < Math.min(M, j + D); l++) {
						if (copyMap[k][l] == 1) {
							int dis = N - k + Math.abs(j - l);

							if (dis <= D && dis < minDis || (dis == minDis && l < x)) {
								minDis = dis;
								y = k;
								x = l;
							}
						}
					}
				}
				if (x != M)
					q.add(new int[] { y, x });
			}
			while (!q.isEmpty()) {
				int[] enemy = q.poll();

				if (copyMap[enemy[0]][enemy[1]] == 1) {
					copyMap[enemy[0]][enemy[1]] = 0;
					cnt += 1;
				}
			}

			if (i == N - 1)
				break;

			for (int r = N - 1; i >= 0; r--) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 1) {
						map[r][c] = 0;

						if (r + 1 < N)
							map[r + 1][c] = 1;
					}
				}
			}
		}
		ans = Math.max(cnt, ans);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;

		token = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		D = Integer.parseInt(token.nextToken());
		map = new int[N + 1][M];
		copyMap = new int[N + 1][M];
		temp = new int[N];
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
				copyMap[i][j] = map[i][j];
			}
		}
		comb(0, 0);
		System.out.println(ans);
	}
}
