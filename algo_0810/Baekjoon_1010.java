package algo_0810;

import java.util.Scanner;

public class Baekjoon_1010 {
	/*static int comb(int m, int n) {
		if(n == m || n == 0) {
			return 1;
		}
		return comb(m-1, n-1)+comb(m-1, n);
	}*/
	static int[][] comb = new int[30][30];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder str = new StringBuilder();
		for(int i=1; i<30; i++) {
			for(int j=0; j<30; i++) {
				if(i==j||j==0) {
					comb[i][j] = 1;
					continue;
				}
				if(!(j-1 < 0))
				comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
			}
		}
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			str.append(comb[N][M]);
		}
		System.out.println(str);
	}
}
