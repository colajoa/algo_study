package algo_0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 서로소
public class swea_7465 {
	static int N, M;
	static int[] parents;
	static boolean[] c;
	static int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			parents = new int[N+1];
			
			for (int i = 1; i < N + 1; i++) {
				parents[i] = i;
			}
			for (int i = 0; i < M; i++) {
				token = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(token.nextToken());
				int to = Integer.parseInt(token.nextToken());
				union(from,to);
			}
			
			c = new boolean[N+1];
			int ans =0;
			for(int i=1; i<N+1; i++) {
				if(c[find(i)]) continue;
				c[find(i)] = true;
				ans += 1;
				
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
