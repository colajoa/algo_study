package algo_0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_15683 {
	static int cnt; 
	static int[][] of;
//	static int[][] copyof;
	static int[][] cctvKind= new int[][] {{0},{0},{0},{0},{0},{0}};
	static List<int[]> cctv = new ArrayList<>();
	static void search(int cnt, int N) {
		if(cnt == N) {
			
			return;
		}
		
		
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		
		of = new int[N][M];
		cnt = 0;
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				of[i][j] = Integer.parseInt(token.nextToken());
				if(of[i][j] > 0 && of[i][j] < 6) {
					cctv.add(new int[] {of[i][j], i, j});
					cnt += 1;
				}
			}
		}
		search(0, cnt);
		
	}
}
