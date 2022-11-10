package algo_1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_5427 {
	static int R, C;
	static char[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<Point> fireQ, manQ;
	static class Point {
		int r, c; 
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int bfs() {
			int time = 0;
			
			while(!manQ.isEmpty()) {
				int size = fireQ.size();
				
				for(int i=0; i<size; i++) {
					Point fire = fireQ.poll();
					
					for(int d=0; d<4; d++) {
						int nr = fire.r + dr[d];
						int nc = fire.c + dc[d];
						
						if(nr >= 0 && nr < R && nc >= 0 && nc < C && (map[nr][nc] == '.' || map[nr][nc] == '@')) {
							map[nr][nc] = '*';
							fireQ.add(new Point(nr, nc));
						}
					}
				}
				
				size = manQ.size();
				
				for(int i=0; i<size; i++) {
					Point man = manQ.poll();
					
					for(int d=0; d<4; d++) {
						int nr = man.r + dr[d];
						int nc = man.c + dc[d];
						
						if(nr < 0 || nr >= R || nc < 0 || nc >= C) return time+1;
						if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
							map[nr][nc] = '@';
							manQ.add(new Point(nr, nc));
						}
					}
				}
				time += 1;
			}
			return 0;
	}
	static void print() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			token = new StringTokenizer(br.readLine());
			
			C = Integer.parseInt(token.nextToken());
			R = Integer.parseInt(token.nextToken());
			
			map = new char[R][C];
			fireQ = new ArrayDeque<>();
			manQ = new ArrayDeque<>();
			
			for(int r=0; r<R; r++) {
				String str = br.readLine();
				for(int c=0; c<C; c++) {
					map[r][c] = str.charAt(c);
					if(map[r][c]=='@') {
						manQ.add(new Point(r, c));
					}
					else if(map[r][c] == '*') {
						fireQ.add(new Point(r, c));
					}
				}
			}
			
			int ans = bfs();
			System.out.println(ans == 0 ? "IMPOSSIBLE" : ans);
			
		}
	}
}
