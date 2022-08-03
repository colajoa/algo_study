package algo_0803;

import java.util.Scanner;

public class swea_2001 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			int n, m;
			n = sc.nextInt();
			m = sc.nextInt();
			int[][] area = new int[n][n];
			int i,j,x,y, sum, max = 0;
			
			for(i=0; i<n; i++) {
				for(j=0; j<n; j++) {
					area[i][j] = sc.nextInt();
				}
			}
			
			for(i=0; i<n-m+1; i++) {
				for(j=0; j<n-m+1; j++) {
					sum = 0;
					for(y=0; y<m; y++) {
						for(x=0; x<m; x++) {
							sum += area[y+i][x+j];
						}
					}
					if (sum > max) max = sum;
				}
			}
			System.out.printf("#%d %d\n", test_case, max);
		}
	}
}
