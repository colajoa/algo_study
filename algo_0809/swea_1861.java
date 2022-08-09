package algo_0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1861 {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static void search(int[] room,int r, int c) {
		for(int i=0; i<room.length; i++) {
			for(int j=0; j<room.length; j++) {
				
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] room= new int[N+1][N+1];
			for(int r=1; r<=N; r++) {
				token = new StringTokenizer(br.readLine(), " ");
				for(int c = 1; c<=N; c++) {
					room[r][c] = Integer.parseInt(token.nextToken());
				}
			}
			int x = 0;
			int y = 0;
			int[] ans = new int[2];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int cnt = 1;
					for(int idx = 0; idx<4; i++) {
						int nx = i + dx[idx];
						int ny = j + dy[idx];
						if(nx > 0 && nx < N+1 && ny > 0 && ny < N+1) {
							
						}
					}
				}
			}
		}
	}
}
