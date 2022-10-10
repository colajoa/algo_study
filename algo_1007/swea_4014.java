package algo_1007;

import java.io.*;
import java.util.*;

public class swea_4014 {
	static int N, X, ans;

	static int[][] rowMap;
	static int[][] colMap;
	static boolean[] visited;

	static boolean check(int[] arr) {
		visited = new boolean[N];

		for (int n = 1; n < N; n++) {
			// 높이 2차이
			if (Math.abs(arr[n] - arr[n - 1]) >= 2) {
				return false;
			}

			// 높이 1차이
			if (Math.abs(arr[n] - arr[n - 1]) == 1) {
				if (!road(arr, n)) {
					return false;
				}
			}

		}
		return true;
	}

	static boolean road(int[] arr, int n) {
		// 오른쪽으로 내려가는
		if (arr[n] - arr[n - 1] == -1) {
			int idx = n-1;
			for (int x = 1; x <= X; x++) {
				if(idx+x == N) return false;
				if(arr[idx]-arr[idx+x]!=1 || visited[idx+x]) return false;
				visited[idx+x] = true;
			}
			return true;
		}

		// 오른쪽으로 올라가는
		if (arr[n] - arr[n - 1] == 1) {
			int idx = n;
			for (int x = 1; x <= X; x++) {
				if(idx-x == -1) return false;
				if(arr[idx] - arr[idx-x] != 1 || visited[idx-x]) return false;
				visited[idx-x] = true;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine());

			N = Integer.parseInt(token.nextToken());
			X = Integer.parseInt(token.nextToken());
			ans = 0;

			rowMap = new int[N][N];
			colMap = new int[N][N];

			for (int i = 0; i < N; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					rowMap[i][j] = Integer.parseInt(token.nextToken());
					colMap[j][i] = rowMap[i][j];
				}
			}

			for (int r = 0; r < N; r++) {
				if(check(rowMap[r]))
					ans += 1;
			}
			//System.out.println();
			for (int c = 0; c < N; c++) {
				if(check(colMap[c])) 
					ans += 1;
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
