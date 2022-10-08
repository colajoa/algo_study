package algo_1005;

import java.io.*;
import java.util.*;

public class Baekjoon_2636 {
	static int R, C;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] visited;
	static List<Integer> list;
	static class Hole {
		int r, c;
		public Hole(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int bfs() {
		Queue<Hole> q = new ArrayDeque<>();
		q.add(new Hole(0, 0));
		visited[0][0] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			Hole now = q.poll();
			int r = now.r;
			int c = now.c;
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
					if(map[nr][nc] == 0) {
						visited[nr][nc] = true;
						q.add(new Hole(nr, nc));
					}
					else if(map[nr][nc] == 1) {
						map[nr][nc] = 0;
						visited[nr][nc] = true;
						cnt += 1;
					}
				}
			}
		}
		list.add(cnt);
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		map = new int[R][C];
		list = new ArrayList<>();
		for(int r=0; r<R; r++) {
			token = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(token.nextToken());
			}
		}
		int time = 0;
		int cnt = 0;
		while(true) {
		visited = new boolean [R][C];
		time += 1;
		cnt = bfs();
		if(cnt==0)
			break;
		}
		System.out.println(time-1);
		System.out.println(list.get(list.size()-2));
	}
}
