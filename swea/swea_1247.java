package swea;
import java.util.*;
import java.io.*;
public class swea_1247 {
	static int N;
	static Point[] point;
	static Point com, home;
	static int ans;
	static boolean[] visited;
	static int[] num;
	static class Point {
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int distance() {
		int dis = 0;
		
		dis = Math.abs(com.r-point[num[0]].r)+ Math.abs(com.c-point[num[0]].c);
		
		for(int i=0; i<N-1; i++) {
			//System.out.println(num[i]+ " "+num[i+1]);
			
			dis += Math.abs(point[num[i]].r-point[num[i+1]].r)+ Math.abs(point[num[i]].c-point[num[i+1]].c);
		}
		//System.out.println(num[N-1]);
		dis += Math.abs(home.r-point[num[N-1]].r)+ Math.abs(home.c-point[num[N-1]].c);
		
		//System.out.println(dis);
		return dis;
	}
	static void perm(int depth) {
		if(depth == N) {
			ans = Math.min(ans, distance());
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			num[depth] = i;
			perm(depth+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			point = new Point[N];
			visited = new boolean[N];
			num = new int[N];
			ans = Integer.MAX_VALUE;
			token = new StringTokenizer(br.readLine());
			
			com = new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
			home = new Point(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
			
			for(int i=0; i<N; i++) {
				int r = Integer.parseInt(token.nextToken());
				int c = Integer.parseInt(token.nextToken());
				point[i] = new Point(r, c);
				//System.out.println(point[i].r+ " "+point[i].c);
			}
			
            perm(0);
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
