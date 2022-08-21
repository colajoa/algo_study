package algo_0821;


import java.io.*;
import java.util.*;

public class swea_7699_2 {
	static int R, C, ans;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[][] island;
	static boolean[] visited;

	static void dfs(int r, int c, int cnt) {
		

		if (ans < cnt)
			ans = cnt;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[island[nr][nc] - 'A']) {
			visited[island[nr][nc] - 'A'] = true;
			dfs(nr, nc, cnt + 1);
			visited[island[nr][nc] - 'A'] = false;
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(token.nextToken());
			C = Integer.parseInt(token.nextToken());
			island = new char[R][C];
			visited = new boolean[26];

			for (int r = 0; r < R; r++) {
				String s = br.readLine();
				for (int c = 0; c < C; c++) {
					island[r][c] = s.charAt(c);
				}
			}
			ans = 0;
			visited[island[0][0] - 'A'] = true;
			dfs(0, 0, 1);
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}

