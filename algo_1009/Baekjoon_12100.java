package algo_1009;

import java.io.*;
import java.util.*;

public class Baekjoon_12100 {
	static int N, ans;
	static int[][] map;
	// 상우하좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static void game(int depth) {
		if (depth == 5) {
			ans = Math.max(ans, findMax());
			return;
		}

		int[][] copy = new int[N][N];
		copyMap(map, copy);

		for (int i = 0; i < 4; i++) {
			move(i);
			game(depth + 1);
			copyMap(copy, map);
		}
	}

	static void move(int dir) {
		switch (dir) {
		case 0:
			for (int c = 0; c < N; c++) {
				for (int r = 0; r < N; r++) {
					
					for(int nr = r+1; nr<N; nr++) {
						if(map[r][c] == map[nr][c]) {
							map[r][c] += map[nr][c];
							map[nr][c] = 0;
							break;
						}
						else if(map[nr][c] != 0 && map[nr][c] != map[r][c]) {
							break;
						}
					}
				}
				
				for(int r=0; r<N; r++) {
					
					if(map[r][c] == 0) {
						
						for(int nr=r+1; nr<N; nr++) {
							if(map[nr][c] != 0) {
								map[r][c] = map[nr][c];
								map[nr][c] = 0;
								break;
							}
						}
					}
				}
			}
			break;
		case 1:
			for (int r = 0; r < N; r++) {
				for (int c = N-1; c > -1; c--) {
					
					for(int nc = c-1; nc > -1; nc--) {
						if(map[r][c] == map[r][nc]) {
							map[r][c] += map[r][nc];
							map[r][nc] = 0;
							break;
						}
						else if(map[r][nc] != 0 && map[r][nc] != map[r][c]) {
							break;
						}
					}
				}
				
				for(int c=N-1; c>-1; c--) {
					
					if(map[r][c] == 0) {
						
						for(int nc=c-1; nc>-1; nc--) {
							if(map[r][nc] != 0) {
								map[r][c] = map[r][nc];
								map[r][nc] = 0;
								break;
							}
						}
					}
				}
			}
			break;
		case 2:
			for (int c = 0; c < N; c++) {
				for (int r = N-1; r > -1; r--) {
					
					for(int nr = r-1; nr>-1; nr--) {
						if(map[r][c] == map[nr][c]) {
							map[r][c] += map[nr][c];
							map[nr][c] = 0;
							break;
						}
						else if(map[nr][c] != 0 && map[nr][c] != map[r][c]) {
							break;
						}
					}
				}
				
				for(int r=N-1; r>-1; r--) {
					
					if(map[r][c] == 0) {
						
						for(int nr=r-1; nr>-1; nr--) {
							if(map[nr][c] != 0) {
								map[r][c] = map[nr][c];
								map[nr][c] = 0;
								break;
							}
						}
					}
				}
			}
			break;
		case 3:
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					
					for(int nc = c+1; nc < N; nc++) {
						if(map[r][c] == map[r][nc]) {
							map[r][c] += map[r][nc];
							map[r][nc] = 0;
							break;
						}
						else if(map[r][nc] != 0 && map[r][nc] != map[r][c]) {
							break;
						}
					}
				}
				
				for(int c=0; c<N; c++) {
					
					if(map[r][c] == 0) {
						
						for(int nc=c+1; nc<N; nc++) {
							if(map[r][nc] != 0) {
								map[r][c] = map[r][nc];
								map[r][nc] = 0;
								break;
							}
						}
					}
				}
			}
			break;
		}
	}

	static int findMax() {
		int max = Integer.MIN_VALUE;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (max < map[r][c])
					max = map[r][c];
			}
		}
		return max;
	}

	static int[][] copyMap(int[][] org, int[][] copy) {

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				copy[r][c] = org[r][c];
			}
		}
		return copy;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(token.nextToken());
			}
		}

		ans = Integer.MIN_VALUE;
		game(0);
		System.out.println(ans);
	}
}
