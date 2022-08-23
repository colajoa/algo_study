package algo_0823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Baekjoon_1197 {
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		
	}
	
	static void make() {
		parents = new int [V+1];
		for(int v=1; v<=V; v++) {
			parents[v] = v;
		}
	}
	
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int V, E;
	static Edge[] edgeList;
	static int[] parents;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		token = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(token.nextToken());
		E = Integer.parseInt(token.nextToken());
		
		edgeList = new Edge[E];
		
		for(int i=0; i<E; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(token.nextToken());
			int to = Integer.parseInt(token.nextToken());
			int weight = Integer.parseInt(token.nextToken());
			
			edgeList[i] = new Edge(from, to, weight);
		}
		
		make();
		Arrays.sort(edgeList);
		long ans = 0;
		int cnt = 0;
		
		for(Edge e: edgeList) {
			if(union(e.from, e.to)) {
				ans += e.weight;
				if(++cnt == V-1) break;
			}
		}
		sb.append(ans);
		bw.write(sb.toString());
		bw.close();
	}
}
