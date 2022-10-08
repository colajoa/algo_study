package ss_1006;

import java.util.*;
import java.io.*;

// 한번만 자를 수 있다.
public class swea_1949 {
	static int N, K, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static class Path {
		int r, c, h;
		public Path(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}
	
	static void dfs(Path path, int length, int cutCount) {
		for(int d=0; d<4; d++) {
			ans = Math.max(ans, length);
			
			int nr = path.r + dr[d];
			int nc = path.c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(visited[nr][nc]) continue;
			
			// 이동 불가
			if(path.h <= map[nr][nc]) {
				// 
				if(cutCount == 0) { 
					if(path.h > map[nr][nc] - K) {
						visited[nr][nc] = true;
						dfs(new Path(nr, nc, path.h-1), length+1, cutCount+1);
						visited[nr][nc] = false;
					}
				}
				
			}
			// 이동 가능
			else {
				visited[nr][nc] = true;
				dfs(new Path(nr, nc, map[nr][nc]), length+1, cutCount);
				visited[nr][nc] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			token = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(token.nextToken());
			K = Integer.parseInt(token.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			ans = Integer.MIN_VALUE;
			int max = Integer.MIN_VALUE;
			for(int r=0; r<N; r++) {
				token = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(token.nextToken());
					if(map[r][c] > max) max = map[r][c];
				}
			}
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == max){
						visited[r][c] = true;
						dfs(new Path(r,c,max),1, 0);
						visited[r][c] = false;
                    }
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	} 
}
