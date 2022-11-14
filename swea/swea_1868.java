package swea;

import java.io.*;
import java.util.*;

public class swea_1868 {
	static int N;
	static char[][] map;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];

			for (int r = 0; r < N; r++) {
				String str = br.readLine();
				for (int c = 0; c < N; c++) {
					map[r][c] = str.charAt(c);	
				}
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					
				}
			}
		}
	}
}
