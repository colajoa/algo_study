package swea;

import java.io.*;
import java.util.*;

public class swea_2819 {
	static Queue<Point> q;
	static String[][] nums;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Set<String> ans;
	static class Point{
		int r, c;
		String str;
		public Point(int r, int c, String str) {
			this.r = r;
			this.c = c;
			this.str = str;
		}
	}
	static void bfs() {
		while(!q.isEmpty()) {
			Point num = q.poll();
			if(num.str.length() == 7) {
				ans.add(num.str);
				continue;
			}
			for(int d=0; d<4; d++) {
				int nr = num.r + dr[d];
				int nc = num.c + dc[d];
				
				if(nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {
					q.add(new Point(nr, nc, num.str+nums[nr][nc]));
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ans = new HashSet<>();
			nums = new String[4][4];
			q = new ArrayDeque<>();
			for (int r = 0; r < 4; r++) {
				token = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < 4; c++) {
					nums[r][c] = token.nextToken();
					q.add(new Point(r,c, nums[r][c]));
				}
			}
			bfs();
//			System.out.println(ans);
//			for (String str : ans) {
//				System.out.println(str);
//			}
			sb.append("#").append(t).append(" ").append(ans.size()).append("\n");
			ans.clear();
		}
		System.out.println(sb);
	}
}
