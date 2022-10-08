package algo_1006;

import java.io.*;
import java.util.*;

public class Baekjoon_9205 {
	static int n;
	static Point home, penta;
	static Point[] conve;
	static class Point{
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static boolean bfs(Point[] point) {
		Queue<Point> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n];
		q.add(new Point(home.r, home.c));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int nowr = now.r;
			int nowc = now.c;
			
			// 현재 위치와 펜타 포트 거리가 1000이하면
			if(Math.abs(nowr-penta.r)+Math.abs(nowc-penta.c) <= 1000) {
				return true;
			}
			
			// 편의점 갯수만큼 반복
			for(int i=0; i<n; i++) {
				// 방문한 편의점이 아니면 방문
				if(!visited[i]) {
					// 다음 방문할 편의점 위치
					int nr = point[i].r;
					int nc = point[i].c;
					
					//현재 위치와 다음 방문할 편의점 거리가 1000이하면
					if(Math.abs(nowr-nr)+Math.abs(nowc-nc) <= 1000) {
						// 방문 처리
						visited[i] = true;
						// 다음 방문을 위해 큐에 저장
						q.add(new Point(nr, nc));
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			n = Integer.parseInt(br.readLine());
			
		
			token = new StringTokenizer(br.readLine());
			home = new Point(Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()));
			
			conve = new Point[n];
			for(int i=0; i<n; i++) {
				token = new StringTokenizer(br.readLine());
				conve[i] = new Point(Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()));
			}
			
			token = new StringTokenizer(br.readLine());
			
			penta = new Point(Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()));
			
			String ans = bfs(conve) ? "happy":"sad";
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
