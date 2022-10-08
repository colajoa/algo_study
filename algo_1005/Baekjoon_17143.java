package algo_1005;

import java.io.*;
import java.util.*;

public class Baekjoon_17143 {
	static int R, C, M, ans;

	// 상우하좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static List<Shark>[][] map;

	static class Shark {
		int r, c, speed, dir, size;
		boolean move;

		public Shark(int r, int c, int speed, int dir, int size, boolean move) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
			this.move = move;
		}
	}

	static void move(int col) {

		fishing(col);
		swimming();
		eating();

	}

	static void fishing(int col) {
		for (int r = 1; r <= R; r++) {
			if (map[r][col].isEmpty())
				continue;
			if (map[r][col].get(0).size > 0) {
				ans += map[r][col].get(0).size;
				map[r][col].remove(0);
				return;
			}

		}
	}

	static void swimming() {

		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				for (int i = 0; i < map[r][c].size(); i++) {
					Shark shark = map[r][c].get(i);
					int sr = shark.r;
					int sc = shark.c;
					int speed = shark.speed;
					int dir = shark.dir;
					if (shark.move)
						continue;
						int length= shark.speed;
						if(dir==0 || dir==2) {
							length %= (R-1)*2;
						}
						
						if(dir==1 || dir==3) {
							length %= (C-1)*2;
						}
						
					for (int d = 0; d < length; d++) {
						
						int nr = sr + dr[dir];
						int nc = sc + dc[dir];

						if (nr < 1 || nr > R || nc < 1 || nc > C) {
							dir = (dir + 2) % 4;
							sr = sr + dr[dir];
							sc = sc + dc[dir];
							continue;
						}

						sr = nr;
						sc = nc;
					}
					map[r][c].remove(i);
					i--;
					map[sr][sc].add(new Shark(sr, sc, speed, dir, shark.size, true));
//						System.out.println(r+" " + c + " " + map[r][c].size());
//						System.out.println(sr+" "+ sc + " "  + map[sr][sc].size());

				}
			}
		}
	}

	static void eating() {
		for (int r = 1; r < R + 1; r++) {
			for (int c = 1; c < C + 1; c++) {

				if (map[r][c].isEmpty())
					continue;
				if (map[r][c].size() == 1) {
					Shark shark = map[r][c].get(0);
					map[r][c].remove(0);
					map[r][c].add(new Shark(shark.r, shark.c, shark.speed, shark.dir, shark.size, false));
					continue;
				}

				if (map[r][c].size() > 1) {

					map[r][c].sort(new Comparator<Shark>() {

						@Override
						public int compare(Shark o1, Shark o2) {
							// TODO Auto-generated method stub
							return o2.size - o1.size;
						}
					});
					Shark shark = map[r][c].get(0);
					map[r][c].clear();
					map[r][c].add(new Shark(shark.r, shark.c, shark.speed, shark.dir, shark.size, false));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;

		token = new StringTokenizer(br.readLine());

		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());

		map = new ArrayList[R + 1][C + 1];

		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				map[r][c] = new ArrayList<>();
			}
		}
		for (int m = 0; m < M; m++) {
			token = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(token.nextToken());
			int c = Integer.parseInt(token.nextToken());
			int speed = Integer.parseInt(token.nextToken());
			int dir = Integer.parseInt(token.nextToken());
			int size = Integer.parseInt(token.nextToken());

			if (dir == 2)
				dir = 3;
			else if (dir == 3)
				dir = 2;

			map[r][c].add(new Shark(r, c, speed, dir - 1, size, false));
		}

		for (int m = 1; m <= C; m++) {
			move(m);
//			for(int i=1; i<=R; i++) {
//				for(int j=1; j<=C; j++) {
//					
//					if(map[i][j].isEmpty()) {
//						System.out.print(0+" ");
//					}
//					for(int d=0; d<map[i][j].size(); d++) {
//						System.out.print(map[i][j].get(d).size+" ");
//					}
//				}
//				System.out.println();
//			}
		}
		System.out.println(ans);
	}
}
