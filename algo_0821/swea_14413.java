package algo_0821;

import java.util.*;
import java.io.*;

public class swea_14413 {
	// 상 우 하 좌

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		int[][] map;
		for (int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			map = new int[N][M];
			boolean ans = false;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					char c = s.charAt(j);
					if (c == '#')
						map[i][j] = 0;
					else if (c == '.')
						map[i][j] = 1;
					else
						map[i][j] = -1;
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 1; c < M; c++) {
						
				}
			}

	

		}

	}
}
