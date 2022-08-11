package algo_0810;

import java.util.Scanner;

public class Baekjoon_16926 {
//	static int[] dx = {};
//	static int[] dy = {};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		int sq = Math.min(n, m) / 2;
		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int ro = 0; ro < r; ro++) {
			for (int idx = 0; idx < sq; idx++) {
				int dn = n - idx - 1;
				int dm = m - idx - 1;

				int tmp = map[idx][idx];
				// 오 -> 왼
				for (int i = idx; i <dm; i++) {
					map[idx][i] = map[idx][i+1];
				}
				// 하 -> 상
				for (int i = idx; i < dn; i++) {
					map[i][dm] = map[i+1][dm];
				}
				// 왼 -> 오
				for (int i = dm; i > idx; i--) {
					map[dn][i] = map[dn][i-1];
				}
				// 상 -> 하
				for (int i = dn; i > idx; i--) {
					map[i][idx] = map[i-1][idx];
				}
				map[idx + 1][idx] = tmp;
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
