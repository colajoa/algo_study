package algo_0826;

import java.io.*;
import java.util.*;

public class Baekjoon_4485 {
	static int N, ans;
	static int[][] map;
	static int[][] distance;
	static boolean[][] visited;
	// 상우하좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class point {
		int r, c, w;

		public point(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

	}

	static void dijkstra(int startR, int startC) {
		PriorityQueue<point> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		distance[startR][startC] = 0;
		pq.offer(new point(startR, startC, map[0][0]));
		while (!pq.isEmpty()) {
			point now = pq.poll();

			if (visited[now.r][now.c])
				continue;

			visited[now.r][now.c] = true;

			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];

				if (nr >= N || nr < 0 || nc >= N || nc < 0)
					continue;
				// 방문하지 않았고 가중치가 현재위치 비용과 가려고하는 곳의 비용 보다 크다면 가중치 갱신
				if (!visited[nr][nc] && distance[nr][nc] > now.w + map[nr][nc]) {
					distance[nr][nc] = now.w + map[nr][nc];
					pq.offer(new point(nr, nc, distance[nr][nc]));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token = null;

		int cnt = 0;

		N = Integer.parseInt(br.readLine());

		while (N != 0) {
			map = new int[N][N];
			distance = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				token = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(token.nextToken());
					distance[i][j] = Integer.MAX_VALUE;
				}
			}

			dijkstra(0, 0);
			ans = distance[N-1][N-1];
			for(int i=0; i<N; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println();
			for(int i=0; i<N; i++) {
				System.out.println(Arrays.toString(distance[i]));
			}
			System.out.println();
			
			for(int i=0; i<N; i++) {
				System.out.println(Arrays.toString(visited[i]));
			}
			System.out.println();
			N = Integer.parseInt(br.readLine());
			cnt += 1;
			sb.append("Problem ").append(cnt).append(": ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
