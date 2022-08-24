package algo_0824;

import java.io.*;
import java.util.*;

public class Baekjoon_7576 {
	static int N, M;
	static int[][] box;
	static boolean[][] visited;
	static int ans;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void bfs(Queue<int[]> tomato) {
		while (!tomato.isEmpty()) {
			int[] t = tomato.poll();
			for (int i = 0; i < 4; i++) {
				int nx = t[0] + dx[i];
				int ny = t[1] + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					box[nx][ny] = 1;
					tomato.add(new int[] { nx, ny, t[2] + 1 });

				}
			}
			ans = t[2];
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		Queue<int[]> tomato = new ArrayDeque<>();
		box = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(token.nextToken());
				if (box[i][j] != 1)
					continue;
				tomato.add(new int[] { i, j, 0 });
				visited[i][j] = true;
			}
		}
		ans = 0;

		bfs(tomato);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(ans);
	}
}
