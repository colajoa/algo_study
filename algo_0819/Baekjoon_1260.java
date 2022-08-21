package algo_0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1260 {
	static void dfs(int V, boolean[] v) {
		v[V] = true;
		sb.append(V+" ");
		for(int i = 1; i<N+1; i++) {
			if(!v[i]&& map[V][i] != 0) {
				dfs(i, v);
			}
		}
	}
	
	static void bfs(int V) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] v = new boolean[N+1];
		
		v[V] = true;
		
		q.offer(V);
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");
			for(int i = 1; i<N+1; i++) {
				if(!v[i] && map[now][i] != 0) {
					v[i] = true;
					q.offer(i);
				}
			}
		}
	}
	
	
	static int[][] map;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		
		token = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		int V = Integer.parseInt(token.nextToken());
		
		map = new int[N+1][N+1];
		boolean[] v = new boolean[N+1];
		
		for(int m=0; m<M; m++) {
			token = new StringTokenizer(br.readLine()," ");
			int i = Integer.parseInt(token.nextToken());
			int j = Integer.parseInt(token.nextToken());
			
				map[i][j] = map[j][i] = 1;
		}
		dfs(V,v);
		sb.append("\n");
		bfs(V);
		System.out.println(sb);
	}
}
