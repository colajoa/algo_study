package algo_1008;

import java.io.*;
import java.util.*;

public class swea_2382_2 {
	static int N, M, K, ans;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,-1,0,1};
	static int map[][];
	static List<Micro> micro;
	
	static class Micro{
		int r, c, nums, dir;
		
		public Micro(int r, int c, int nums, int dir) {
			this.r = r;
			this.c = c;
			this.nums = nums;
			this.dir = dir;
		}
	}
	
	static void quarantine() {
		for(int m=0; m<M; m++) {
			map = new int[N][N];
			micro.sort((o1, o2)-> Integer.compare(o2.nums, o1.nums));
			
			for(int i=0; i<K; i++) {
				Micro now = micro.get(i);
				
				if(now.nums==0) continue;
				
				now.r += dr[now.dir];
				now.c += dc[now.dir];
				if(now.r == 0 || now.r == N-1 || now.c == 0 || now.c == N-1) {
					now.nums /= 2;
					now.dir = (now.dir+2)%4;
					map[now.r][now.c] = i+1;
					continue;
				}
				
				if(map[now.r][now.c] == 0) {
					map[now.r][now.c] = i+1;
					continue;
				}
				else {
					Micro past = micro.get(map[now.r][now.c]-1);
					
					if(now.nums < past.nums) {
						past.nums += now.nums;
						now.nums = 0;
					}
					
					else {
						now.nums += past.nums;
						past.nums = 0;
						map[now.r][now.c] = i+1;
					}
				}
			}
		}
		answer();
	}
	static void answer() {
		ans = 0;
		for(Micro m : micro) {
			ans += m.nums;
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
			
			micro = new ArrayList<>();
			
			for(int k=0; k<K; k++) {
				token = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(token.nextToken());
				int c = Integer.parseInt(token.nextToken());
				int nums = Integer.parseInt(token.nextToken());
				int dir = Integer.parseInt(token.nextToken())-1;
				
				if(dir == 1) dir = 2;
				else if (dir==2) dir = 1;
				micro.add(new Micro(r, c, nums, dir));
			}
			
			quarantine();
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
