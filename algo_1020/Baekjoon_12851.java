package ss_1020;

import java.util.*;
import java.io.*;

public class Baekjoon_12851 {
	static int N, K, cnt, time;
	static int[] d = {-1,1,2};
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] v = new boolean[100001];
		
		v[N] = true;
		
		q.offer(new int[] {N, 0});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			v[now[0]] = true;
			
			if(now[0]==K) {
				if(time < now[1]) {
					continue;
				}
				else {
					time = now[1];
					cnt += 1;					
				}
			}
			
			for(int i=0; i<3; i++) {
				int n = now[0] + d[i];
				
				if(i==2) n = now[0] * 2;
				
				if(n>=0 && n <= 100000 && !v[n]) {
					q.offer(new int[] {n, now[1]+1});
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		time = Integer.MAX_VALUE;
		cnt = 0;
//		if(N>=K) {
//			System.out.println(N-K);
//			System.out.println(1);
//			return;
//		}
		bfs();
		System.out.println(time);
		System.out.println(cnt);
	}
}
