package algo_0824;

import java.io.*;
import java.util.*;

public class Baekjoon_3055 {
	static int R, C, ans;
	static int[] cave, go;
	static char[][] map;
	static boolean[][] visited;
	static boolean arrived;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void bfs(Queue<int[]> q) {
		while (!q.isEmpty()) {
			int[] p = q.poll();

			if (map[p[0]][p[1]] == '*') {
				for (int i = 0; i < 4; i++) {
					int nx = p[0] + dx[i];
					int ny = p[1] + dy[i];

					if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && map[nx][ny] == '.') {
						visited[nx][ny] = true;
						map[nx][ny] = '*';
						q.offer(new int[] { nx, ny });
					}
				}
			}

			if (map[p[0]][p[1]] == 'S') {
				// 동굴 찾으면 종료 시켜주기
				if(p[0]==cave[0] && p[1]==cave[1]) {
					ans = p[2];
					return;
				}
				for (int i = 0; i < 4; i++) {
					int nx = p[0] + dx[i];
					int ny = p[1] + dy[i];

					if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]
							&& (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
						visited[nx][ny] = true;
						map[nx][ny] = 'S';
						map[p[0]][p[1]] = '.';
						q.offer(new int[] { nx, ny, p[2] + 1 });
					}
				}
			}
			
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		Queue<int[]> q = new ArrayDeque<int[]>();
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		map = new char[R][C];
		cave = new int[2];
		go = new int[2];
		visited = new boolean[R][C];
		arrived = false;
		for (int r = 0; r < R; r++) {
			String s = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);
				if (map[r][c] == '*') {
					q.add(new int[] { r, c });
					visited[r][c] = true;

				} else if (map[r][c] == 'D') {
					cave[0] = r;
					cave[1] = c;
				} else if (map[r][c] == 'S') {
					go[0] = r;
					go[1] = c;
					visited[r][c] = true;
				} else if (map[r][c] == 'X') {
					visited[r][c] = true;
				}
			}
		}
		q.add(new int[] { go[0], go[1], 0 });

		ans = 0;
		bfs(q);
		
		for(int i =0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'D') {
					System.out.println("KAKTUS");
					return;
				}
			}
		}
		System.out.println(ans);
	}
}
