package algo_0821;

import java.util.*;
import java.io.*;

public class Baekjoon_14889 {
	static int[][] team;
	static int N;
	static boolean[] visited;
	static int min;
	static void comb(int start, int depth) {
		if(depth == N/2) {
			//System.out.println(Arrays.toString(visited));
			int a = 0;
			int b = 0;
			for(int i=0; i<N; i++) {
				
				for(int j=0; j<N; j++) {
					if(visited[i] && visited[j])
						a += team[i][j];
					else if(!visited[i] && !visited[j])
						b += team[i][j];
				}
			}
			
			min = Math.min(min, Math.abs(a-b));
			return;
		}
		
		for(int i=start; i<N; i++) {
			
			visited[i] = true;
			comb(i+1, depth+1);
			visited[i] = false;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		N = Integer.parseInt(br.readLine());
		team = new int[N][N];
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				team[i][j] = Integer.parseInt(token.nextToken());
			}	
		}
		
		visited = new boolean[N];
		min = Integer.MAX_VALUE;
		comb(0,0);
		System.out.println(min);
	}
}
