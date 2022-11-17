package swea;

import java.io.*;
import java.util.*;

public class swea_1258 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static PriorityQueue<Point> ans;

	static class Point implements Comparable<Point> {
		int r, c, size;

		public Point(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}

		@Override
		public int compareTo(Point o) {
			if (this.size == o.size)
				return Integer.compare(this.r, o.r);
			return Integer.compare(this.size, o.size);
		}
	}

	static void bfs(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(r, c, 0));
		visited[r][c] = true;

		Point now = null;
		while (!q.isEmpty()) {
			now = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Point(nr, nc, 0));
				}
			}
		}
		int ar = Math.abs(now.r - r) + 1;
		int ac = Math.abs(now.c - c) + 1;
		ans.add(new Point(ar, ac, (ar * ac)));
	}

	static void print() {
		int size = ans.size();
		for (int i = 0; i < size; i++) {
			Point p = ans.poll();
			System.out.print(p.r + " " + p.c + " ");
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
			map = new int[N][N];
			visited = new boolean[N][N];
			ans = new PriorityQueue<Point>();
			// ans.add(new Point(-1, -1, 0));
			for (int r = 0; r < N; r++) {
				token = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(token.nextToken());
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] > 0 && !visited[r][c]) {
						bfs(r, c);
					}
				}
			}
//			int size = ans.size();
//			print();
//			sb.append("#").append(t).append(" ").append(ans.size());
//
//			for (int i = 0; i < size; i++) {
//				Point p = ans.poll();
//				sb.append(" ").append(p.r).append(" ").append(p.c);
//			}
//			sb.append("\n");
			
			System.out.print("#"+t+" ");
			PriorityQueue<Point> clone = new PriorityQueue<>(ans);
			print();
			sb.append("#").append(t).append(" ").append(ans.size());
			for (Point p : clone) {
				//print();
				//System.out.println(p.r+ " "+p.c);
				sb.append(" ").append(p.r).append(" ").append(p.c);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
