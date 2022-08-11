package algo_0810;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_16935 {
	static void case1() {
		int idx = map.length - 1;
		for (int i = 0; i < map.length / 2; i++) {
			int[] tmp = map[i];
			map[i] = map[idx];
			map[idx] = tmp;
			idx -= 1;
		}

	}

	static void case2() {
		for (int i = 0; i < map.length; i++) {
			int idx1 = map[0].length - 1;
			for (int j = 0; j < map[0].length / 2; j++) {
				int tmp = map[i][j];
				map[i][j] = map[i][idx1];
				map[i][idx1] = tmp;
				idx1 -= 1;
			}
		}

	}

	static void case3() {
		rotmap = new int[M][N];
		int c = N - 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				rotmap[j][c] = map[i][j];
			}
			c--;
		}
		int tmp = N;
		N = M;
		M = tmp;
		map = rotmap;
	}

	static void case4() {
		rotmap = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				rotmap[M - 1 - j][i] = map[i][j];
			}
		}
		int tmp = N;
		N = M;
		M = tmp;
		map = rotmap;
	}

	static void case5() {
		rotmap = new int[N / 2][M / 2];
		int startX = N / 2;
		int startY = 0;
		
		//1번 저장
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				rotmap[i][j] = map[i][j];
			}
		}
		
		//4번 -> 1번 
		for (int i = startX; i < N; i++) {
			for (int j = startY; j < M / 2; j++) {
				map[i - N / 2][j] = map[i][j];
			}
		}
		
		//3번 -> 4번
		startY = M / 2;

		for (int i = startX; i < N; i++) {
			for (int j = startY; j < M; j++) {
				map[i][j - M / 2] = map[i][j];
			}
		}

		//2번 -> 3번
		startX = 0;

		for (int i = startX; i < N / 2; i++) {
			for (int j = startY; j < M; j++) {
				map[i + N / 2][j] = map[i][j];
			}
		}
		
		//마지막 1번 -> 2번
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				map[i][j+M/2] = rotmap[i][j];
			}
		}
	}

	static void case6() {
		rotmap = new int[N / 2][M / 2];
		int startX = 0;
		int startY = M / 2;
		
		//1번 저장
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				rotmap[i][j] = map[i][j];
			}
		}
		
		//2번 -> 1번
		for(int i=startX; i<N/2; i++) {
			for(int j=startY; j<M; j++) {
				map[i][j-M/2] = map[i][j];
			}
		}
	
		//3번 -> 2번
		startX = N/2;
		for(int i=startX; i<N; i++) {
			for(int j=startY ; j<M; j++) {
				map[i-N/2][j] = map[i][j];
			}
		}
			
		//4번 -> 3번
		startY = 0;
		for(int i=startX; i<N; i++) {
			for(int j=startY; j<M/2; j++) {
				map[i][j+M/2] = map[i][j];
			}
		}
			
		//1번 -> 4번
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				map[i+N/2][j] = rotmap[i][j];
			}
		}
	}

	static int N;
	static int M;
	static int R;
	static int[][] map;
	static int[][] rotmap;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder str = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		for (int t = 0; t < R; t++) {
			int ro = sc.nextInt();
			switch (ro) {
			case 1:
				case1();
				break;
			case 2:
				case2();
				break;
			case 3:
				case3();
				break;
			case 4:
				case4();
				break;
			case 5:
				case5();
				break;
			case 6:
				case6();
				break;
			}
		}
		for (int[] r : map) {
			for (int i : r) {
				str.append(i + " ");
			}
			str.append("\n");
		}
		System.out.println(str);
	}
}
