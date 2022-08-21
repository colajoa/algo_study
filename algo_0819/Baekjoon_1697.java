package algo_0819;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1697 {
	static int[] d = {-1,1,2};
	static int K, ans = 0;
	static void bfs(int N) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] v = new boolean[100001];
		
		v[N] = true;
		q.offer(new int[] {N, 0});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if (now[0]==K) { 
				ans = now[1];
				return; 
				}
			for(int i=0; i<3; i++) {
				int n = now[0] + d[i];
				
				if(i==2) n= now[0]*d[i];

				if(n >= 0 && n <= 100000 && !v[n]) {
					v[n] = true;
					q.offer(new int[] {n, now[1]+1});
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		bfs(N);
		System.out.println(ans);
	}
}
