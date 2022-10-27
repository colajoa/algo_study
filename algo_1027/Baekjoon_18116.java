package ss_1027;
import java.io.*;
import java.util.*;
public class Baekjoon_18116 {
	static int N;
	static int V, E;
	static Edge[] edgeList;
	static int[] parents;
	static int[] robot;
	
	static class Edge {
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
		}
	}
	
	static void make() {
		parents = new int [1000001];
		robot = new int [1000001];
		
		for(int i=1; i<1000001; i++) {
			parents[i] = i;
			robot[i] = 1;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		// 부모가 같으면 리턴
		if(aRoot==bRoot) return;
		
		// 한 쪽 로봇 부품이 많으면 적은 쪽의 부모를 많은 쪽으로 변경
		// 많은 쪽의 부품에 적은 쪽의 부품 수를 더 해준다.
		if(robot[aRoot] < robot[bRoot]) {
			parents[aRoot] = bRoot;
			//robot[aRoot] += robot[bRoot];
			robot[bRoot] += robot[aRoot];
			//System.out.println(aRoot + " : " +robot[aRoot]+ " " +bRoot+ " : " +robot[bRoot]);
		}
		else {
			parents[bRoot] = aRoot;
			//robot[bRoot] += robot[aRoot];
			robot[aRoot] += robot[bRoot];
			//System.out.println(aRoot + " : " +robot[aRoot]+ " " +bRoot+ " : " +robot[bRoot]);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		make();
		
		for(int n=0; n<N; n++) {
			token = new StringTokenizer(br.readLine());
			String str = token.nextToken();
			
			
			if(str.equals("I")) {
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				
				union(a,b);
				
			}
			
			else if(str.equals("Q")) {
				int a = Integer.parseInt(token.nextToken());
				sb.append(robot[find(a)]).append("\n");
			}
			
		}
		//System.out.println(robot[1]+ " " +robot[2]+" "+ robot[3]);
		System.out.println(sb);
	}
}
