package algo_0826;

import java.io.*;
import java.util.*;

public class Baekjoon_17144 {
	static int R, C, T;
	static int[][] map;
	static int[][] copyMap;
	static int[] airCleaner;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static void spreadDust() {
		boolean[][] visited = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] > 3) {
					visited[r][c] = true;
				}
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (visited[r][c]) {
					int cnt = 0;
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
							cnt += 1;
							copyMap[nr][nc] += map[r][c] / 5;
						}
					}
					map[r][c] = map[r][c] - ((map[r][c] / 5) * cnt);
				}
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] != -1) {
					map[r][c] += copyMap[r][c];
				}
			}
		}
	}

	static void startCleaner() {
		// 위쪽 airCleaner r : [0][0] c : 0
		// 좌측 상단 우측 하단
		for (int r = airCleaner[0] - 1; r > 0; r--)
			map[r][0] = map[r - 1][0];
		for (int c = 0; c < C - 1; c++)
			map[0][c] = map[0][c + 1];
		for (int r = 0; r < airCleaner[0]; r++)
			map[r][C - 1] = map[r + 1][C - 1];
		for (int c = C - 1; c > 1; c--)
			map[airCleaner[0]][c] = map[airCleaner[0]][c - 1];
		map[airCleaner[0]][1] = 0;

		// 아래쪽 airCleaner r : [1][0] c : 0
		// 좌측 하단 우측 상단
		for (int r = airCleaner[1] + 1; r < R - 1; r++)
			map[r][0] = map[r + 1][0];
		for (int c = 0; c < C - 1; c++)
			map[R - 1][c] = map[R - 1][c + 1];
		for(int r = R-1; r > airCleaner[1]; r--)
			map[r][C-1] = map[r-1][C-1];
		for(int c=C-1; c > 1; c--)
			map[airCleaner[1]][c] = map[airCleaner[1]][c-1];
		map[airCleaner[1]][1] = 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;

		token = new StringTokenizer(br.readLine());
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		T = Integer.parseInt(token.nextToken());
		map = new int[R][C];
		copyMap = new int[R][C];
		airCleaner = new int[2];
		int ans = 0;
		int idx = 0;
		for (int r = 0; r < R; r++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(token.nextToken());
				if (map[r][c] == -1) {
					airCleaner[idx] = r;
					idx += 1;
				}
			}
			// copyMap[r] = Arrays.copyOf(map[r], C);
		}

		for (int i = 0; i < T; i++) {
			copyMap = new int[R][C];
			spreadDust();
			startCleaner();
		}
		/*for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}*/

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1)
					ans += map[i][j];
			}
		}
		System.out.println(ans);
	}
}
