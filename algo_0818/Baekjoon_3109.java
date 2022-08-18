package algo_0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_3109 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	// 우, 우상, 우하
	static int[] dx = { 0, -1, 1 };
	static int[] dy = { 1, 1, 1 };

	static boolean dfs(int x, int y) {
		map[x][y] = 'p';
		if (y == C - 1) {
			return true;
		}

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') {
				map[x][y] = 'p';
				dfs(nx, ny);
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;

		token = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		int count = 1;
		for (int r = 0; r < R; r++) {
			String s = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);
			}
		}
		for (int i = 0; i < R; i++) {
			if (dfs(i, 0)) {
				count += 1;
			}
		}
		System.out.println(count);
	}
}
