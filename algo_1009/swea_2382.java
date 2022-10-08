package algo_1008;

import java.io.*;
import java.util.*;

public class swea_2382 {
	static int N, M, K, ans;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,-1,0,1};
	static List<Micro>[][] micro;
	static class Micro{
		int r, c, nums, dir;
		boolean isMoved;
		
		public Micro(int r, int c, int nums, int dir, boolean isMoved) {
			this.r = r;
			this.c = c;
			this.nums = nums;
			this.dir = dir;
			this.isMoved = isMoved;
		}
	}
	static void print() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(micro[r][c].isEmpty()) {
					System.out.print(0+" ");
				}
				for(int i=0; i<micro[r][c].size(); i++) {
				System.out.print(micro[r][c].get(i).nums+" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	static void quarantine() {
		for(int i=0; i<M; i++) {
			move();
			add();
		}
		count();
			//print();
	}
	static void move() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!micro[r][c].isEmpty()) {
					for(int i=0; i<micro[r][c].size(); i++) {
						Micro m = micro[r][c].get(i);
						if(!m.isMoved) {
							int nr = m.r + dr[m.dir];
							int nc = m.c + dc[m.dir];
							
							if(nr == 0 || nr == N-1 || nc == 0 || nc == N-1) {
								if(m.nums/2 == 0) {
									micro[r][c].remove(i);
									i--;
									continue;
								}
								
								micro[r][c].remove(i);
								i--;
								micro[nr][nc].add(new Micro(nr, nc, m.nums/2, (m.dir+2)%4, true));
								continue;
							}
							
							
							micro[r][c].remove(i);
							i--;
							micro[nr][nc].add(new Micro(nr, nc, m.nums, m.dir, true));
						}
					}
				}
			}
		}
	}
	
	static void add() {
		for(int r = 0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(micro[r][c].size()==1) {
					micro[r][c].get(0).isMoved = false;
				}
				if(micro[r][c].size() > 1) {
					Micro max = micro[r][c].get(0);
					int sum = 0;
					sum += max.nums;
					for(int i=1; i<micro[r][c].size(); i++) {
						sum += micro[r][c].get(i).nums;
						if(max.nums < micro[r][c].get(i).nums) {
							max = micro[r][c].get(i);
						}
					}
					
					micro[r][c].clear();
					micro[r][c].add(new Micro(r, c, sum, max.dir, false));
				}
			}
		}
	}
	
	static void count() {
		ans = 0;
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!micro[r][c].isEmpty()) {
					ans += micro[r][c].get(0).nums;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			token = new StringTokenizer(br.readLine());

			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			K = Integer.parseInt(token.nextToken());
			
			micro = new ArrayList[N][N];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					micro[r][c] = new ArrayList<>();
				}
			}
			
			for (int k = 0; k < K; k++) {
				token = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(token.nextToken());
				int c = Integer.parseInt(token.nextToken());
				int nums = Integer.parseInt(token.nextToken());
				int dir = Integer.parseInt(token.nextToken())-1;
				
				if(dir == 1)
					dir = 2;
				
				else if(dir == 2)
					dir = 1;
				
				
				micro[r][c].add(new Micro(r, c, nums, dir, false));
			}
			//print();
			
			quarantine();
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
