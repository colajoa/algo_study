package swea;

import java.io.*;
import java.util.*;

public class swea_4192 {
	static int N;
	static int[][] pool;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int startR, startC, endR, endC;

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static void bfs(int sr, int sc) {
		Queue<Point> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		q.add(new Point(sr, sc));
		visited[sr][sc] = true;
		while (!q.isEmpty()) {
			Point now = q.poll();
			if (now.r == endR && now.c == endC)
				break;
			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && pool[nr][nc] == 0) {
					visited[nr][nc] = true;
					pool[nr][nc] = pool[now.r][now.c] + 1;
					q.add(new Point(nr, nc));
				}
			}
			//print();
		}
	}

	static void print() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(pool[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token = null;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			pool = new int[N][N];
			for (int r = 0; r < N; r++) {
				token = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					pool[r][c] = Integer.parseInt(token.nextToken());
				}
			}

			token = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(token.nextToken());
			int startC = Integer.parseInt(token.nextToken());

			token = new StringTokenizer(br.readLine());
			endR = Integer.parseInt(token.nextToken());
			endC = Integer.parseInt(token.nextToken());

			bfs(startR, startC);
			//print();
			sb.append("#").append(t).append(" ").append(pool[endR][endC]!=0 ? pool[endR][endC] : -1).append("\n");
		}
		System.out.println(sb);
	}
}
