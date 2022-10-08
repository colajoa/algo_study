package algo_1007;

import java.io.*;
import java.util.*;

public class swea_5643 {
	static int N, M, cnt;

	static int[][] adjMatrix;
	
	// 
	static void shortBfs(int from) {
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
					cnt +=1;
				}
			}
		}
		
	}
	
	static void tallBfs(int from) {
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
			
			for(int from=1; from<=N; from++) {
				cnt = 0;
				shortBfs(from);
				tallBfs(from);
				if(cnt == N-1) ans+=1;
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Solution_키순서 {
//    static ArrayList<Integer>[] Graph;
//    static ArrayList<Integer>[] Graph2;
//    static boolean[][] adj;
//    static int N;
//
//public static void main(String[] args) throws NumberFormatException, IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringBuilder sb = new StringBuilder();
//    StringTokenizer st = null;
//    int T = Integer.parseInt(br.readLine());
//    for (int tc = 1; tc <= T; tc++) {
//
//        N = Integer.parseInt(br.readLine());
//        int M = Integer.parseInt(br.readLine());
//        Graph = new ArrayList[N + 1];
//        Graph2 = new ArrayList[N + 1];
//        adj = new boolean[N + 1][N + 1];
//
//        for (int i = 0; i <= N; i++) {
//            Graph[i] = new ArrayList<>();
//            Graph2[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            Graph[a].add(b);
//            Graph2[b].add(a);
//        }
//        for (int i = 1; i <= N; i++) {
//            connect(i, Graph);
//            connect(i, Graph2);
//        }
//
//        for (int i = 1; i < N + 1; i++) {
//            for (int j = 1; j < N + 1; j++) {
//                System.out.print(adj[i][j] + "\t");
//            }
//            System.out.println();
//        }
//        int result = 0;
//
//        loop: for (int i = 1; i < N + 1; i++) {
//            int cnt = 0;
//            for (int j = 1; j < N + 1; j++) {
//                if (i != j && adj[i][j])
//                    cnt++;
//            }
//            if (cnt == N - 1)
//                result++;
//        }
//
//        sb.append("#").append(tc).append(" ").append(result).append("\n");
//    }
//    System.out.println(sb);
//}
//
//static void connect(int s, ArrayList<Integer>[] Graph) {
//    boolean[] visited = new boolean[N + 1];
//    Queue<Integer> q = new LinkedList<>();
//    q.add(s);
//    visited[s] = true;
//
//    while (!q.isEmpty()) {
//        int now = q.poll();
//
//        for (int i = 0; i < Graph[now].size(); i++) {
//            int next = Graph[now].get(i);
//
//            if (!visited[next]) {
//                visited[next] = true;
//                adj[now][next] = true;
//                adj[s][next] = true;
//                q.add(next);
//            }
//        }
//    }
//}
//}