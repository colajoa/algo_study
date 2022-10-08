package ss_1006;

import java.util.*;
import java.io.*;

// 한번만 자를 수 있다.
// 최대 K만큼 깎을 수 있다.
public class swea_1949_2 {
	static int N, K, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	static void dfs(int r,int c, int length, int cutCount) {
		
		ans = Math.max(ans, length);
		
		for(int d=0; d<4; d++) {
			
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 범위를 벗어나거나 방문한 곳은 뛰어 넘기
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(visited[nr][nc]) continue;
			
			
			// 다음이 현재 보다 높거나 같은 봉우리
			if (map[r][c] <= map[nr][nc]){
			
			// 깎을 횟수가 있다면
			if(cutCount == 0) {
					
					// K번 반복
					for(int i=1; i<=K; i++) {
						// 방문할 곳이 현재위치보다 낮아지면
						if(map[r][c] > map[nr][nc] - i) {
							visited[nr][nc] = true;
							map[nr][nc] -= i;
							dfs(nr, nc, length+1, cutCount+1);
							map[nr][nc] += i;
							visited[nr][nc] = false;
						}	
					}
				}
			}
			// 다음이 낮은 봉우리
			else {
				visited[nr][nc] = true;
				dfs(nr,nc, length+1, cutCount);
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
					if(map[r][c] == max) {
						visited[r][c] = true;
						dfs(r,c, 1, 0);
						visited[r][c] = false;
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	} 
}
