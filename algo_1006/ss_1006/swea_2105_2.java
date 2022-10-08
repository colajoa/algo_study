package ss_1006;

import java.io.*;
import java.util.*;

public class swea_2105_2 {
	static int N, ans;
	static int[][] map;
	static int[] dr = {1,1,-1,-1};
	static int[] dc = {1,-1,-1,1};
	static boolean[] check;
	static void dfs(int r, int c, int sr, int sc, int depth, int sum) {
		if(r == sr && c == sc && check[map[r][c]]) {
			ans = Math.max(sum, ans);
			return;
		}
		
		
		for(int i=depth; i<=depth+1; i++) {
			if(i > 3) break;
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(check[map[nr][nc]]) continue;
			
			check[map[nr][nc]] = true;
			dfs(nr, nc, sr, sc, i, sum+1);
			check[map[nr][nc]] = false;
			
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			ans = -1;
			map = new int[N][N];
			for(int r=0; r<N; r++) {
				token = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(token.nextToken());
					
				}
			}
			
			for(int r=0; r<N-2; r++) {
				for(int c=1; c<N-1; c++) {
					check = new boolean[101]; 
					dfs(r, c, r, c, 0, 0);
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
