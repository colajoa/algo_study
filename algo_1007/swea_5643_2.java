package algo_1007;

import java.io.*;
import java.util.*;

public class swea_5643_2 {
	static int N, M, cnt;

	static int[][] adjMatrix;
	
	// 
	static void tallerBfs(int from) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		visited[from] = true;
		q.add(from);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=1; i<=N; i++) {
				if(!visited[i] && adjMatrix[now][i] == 1) {
					visited[i] = true;
					q.add(i);
					System.out.print(i + " ");
					cnt +=1;
				}
			}
		}
		
	}
	
	static void shorterBfs(int from) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		visited[from] = true;
		q.add(from);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=1; i<=N; i++) {
				if(!visited[i] && adjMatrix[i][now] == 1) {
					visited[i] = true;
					q.add(i);
					System.out.print(i + " ");
					cnt +=1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int ans = 0;
			
			adjMatrix = new int[N+1][N+1];
			
			for(int m = 0; m < M; m++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				adjMatrix[from][to] = 1;
			}
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					System.out.print(adjMatrix[i][j] +" ");
				}
				System.out.println();
			}
			System.out.println();
			for(int from=1; from<=N; from++) {
				cnt = 0;
				System.out.println(from);
				System.out.print("taller : ");
				tallerBfs(from);
				System.out.println();
				System.out.print("shorter : ");
				shorterBfs(from);
				System.out.println("\n");
				if(cnt == N-1) ans+=1;
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}