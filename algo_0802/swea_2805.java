package algo_0802;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class swea_2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/algo_0802/input2.txt"));
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int tc=1; tc<=t ;tc++) {
			int profit = 0;
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			char[] temp = null;
			for(int i=0; i<N; ++i) {
				temp = sc.next().toCharArray();
				for(int j=0; j<N; ++j) {
					farm[i][j] = temp[j]-'0';
				}
			}
			int center = N/2;
			int start, end, side = 0;
			for(int n=0; n<N; n++) {
				start = center - side;
				end = center + side;
				for(int i=start; i<=end; i++) {
					profit += farm[n][i];
				}
				if(n<center) {
					side+=1;
				}
				else {
					side-=1;
				}
			}
			System.out.println("#"+tc+" "+profit);
		}
	}
}
