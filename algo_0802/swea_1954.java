package algo_0802;

import java.util.Scanner;

public class swea_1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int[] turn = {0,1,2,3}; 
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[][] sn = new int[N][N];
			int start = 0;
			int num = 1;
			int x = 0;
			int y = 0;
			while(num<=N*N) {
				int nx = x + dx[start];
				int ny = y + dy[start];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N || sn[nx][ny]!=0) {
					start = (start+1)%4;
					nx = x + dx[start];
					ny = y + dy[start];
				}
				sn[x][y] = num++;
				x = nx;
				y = ny;
				
			}
			System.out.println("#"+t);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(sn[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}
