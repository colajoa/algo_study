package swea;

import java.io.*;
import java.util.*;

public class swea_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			
			for(int r=0; r<N; r++) {
				String str = br.readLine();
				for(int c=0; c<N; c++) {
					map[r][c] = str.charAt(c)-'0';
				}
			}
			int dis = N/2;
			int cr = N/2;
			int cc = N/2;
			int ans = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(dis >= (Math.abs(r-cr)+Math.abs(c-cc))) {
						ans += map[r][c];
					}
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
