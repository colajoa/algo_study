package swea;

import java.io.*;
import java.util.*;

public class swea_1824 {
	static int R, C;
	// 우하좌상
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	static boolean[][][][] visited;
	static char[][] map;

	static class Point {
		int r, c, dir, num;

		public Point(int r, int c, int dir, int num) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.num = num;
		}
	}

	static boolean bfs() {
		Queue<Point> q = new ArrayDeque<>();
		
		q.add(new Point(0, 0, 0, 0));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(visited[now.r][now.c][now.dir][now.num]) continue;
			
			char cmd = map[now.r][now.c];
			
			visited[now.r][now.c][now.dir][now.num] = true;
			
			if(cmd >= '0' && cmd <= '9') now.num = cmd - '0';
			else if(cmd=='<') now.dir = 2;
			else if(cmd=='>') now.dir = 0;
			else if(cmd=='^') now.dir = 3;
			else if(cmd=='v') now.dir = 1;
			
			else if(cmd=='_') now.dir = (now.num == 0) ? 0 : 2 ;
			else if(cmd=='|') now.dir = (now.num == 0) ? 1 : 3 ;
			else if(cmd=='?') {
				for(int d=0; d<4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					
					if(now.r < 0) now.r = R-1;
					else if(now.r >= R) now.r = 0;
					else if(now.c < 0) now.c = C-1;
					else if(now.c >= C) now.c = 0;
					
					q.add(new Point(nr, nc, d, now.num));
				}
				continue;
			}
			
			else if(cmd=='+') now.num = (now.num == 15) ? 0 : now.num+1;
			else if(cmd=='-') now.num = (now.num == 0) ? 15 : now.num-1;
			
			else if(cmd=='@') return true;
			
			now.r += dr[now.dir];
			now.c += dc[now.dir];
			
			if(now.r < 0) now.r = R-1;
			else if(now.r >= R) now.r = 0;
			else if(now.c < 0) now.c = C-1;
			else if(now.c >= C) now.c = 0;
			
			q.add(now);
		}
		return false;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			token = new StringTokenizer(br.readLine());
			
			R = Integer.parseInt(token.nextToken());
			C = Integer.parseInt(token.nextToken());
			
			map = new char[R][C];
			visited = new boolean[R][C][4][16];
			
			for(int r=0; r<R; r++) {
				String str = br.readLine();

				for(int c=0; c<C; c++) {
					map[r][c] = str.charAt(c);
				}
			}
			
			sb.append("#").append(t).append(" ").append(bfs() ? "YES" : "NO").append("\n");
		}
		System.out.println(sb);
	}
}
