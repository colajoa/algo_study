package algo_0825;
import java.util.*;
import java.io.*;

public class Baekjoon_1753_2 {
	static class Node {
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
	}
	static List<Node>[] list;
	static boolean[] visited;
	static int V, E, K;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(token.nextToken());
		E = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(br.readLine());
		int[] D = new int[V+1];
		visited = new boolean[V+1];
		list = new ArrayList[V+1];
		
		for(int i=1; i<V+1; i++) {
			list[i] = new ArrayList<Node>();
			D[i] = Integer.MAX_VALUE;
		}
		//Node[] adjList = new Node[V];
		
		for(int e=0; e<E; e++) {
			token = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(token.nextToken());
			int to = Integer.parseInt(token.nextToken());
			int w = Integer.parseInt(token.nextToken());
			list[from].add(new Node(to, w));
			//adjList[from] = new Node(to, adjList[from], w);
			//adjList[from] = new Node(from, adjList[to], w);
		}
		//System.out.println(Arrays.toString(D));
		//System.out.println(Arrays.toString(visited));
		//System.out.println();
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> Integer.compare(o1.weight, o2.weight));
		
		D[K] = 0;
		pq.offer(new Node(K,0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int vertex = cur.to;
			int min = cur.weight;
			if(visited[vertex]) continue;
			
			visited[vertex] = true;
			//System.out.println(Arrays.toString(visited));
			//System.out.println(Arrays.toString(D));
			//System.out.println();
			for(int i=0, size = list[vertex].size(); i<size; i++) {
				Node next = list[vertex].get(i);
				int nextTo = next.to;
				int nextWeight = next.weight;
				//System.out.println(vertex+" "+nextTo+" "+D[nextTo] + ">"+D[vertex] +"+" +nextWeight+"="+(D[vertex] +nextWeight));
				// 다음 방문할 곳이 방문되지 않았다면
				if(!visited[nextTo] && D[nextTo] > min + nextWeight) {
					D[nextTo] = min + nextWeight;
					pq.offer(new Node(nextTo, D[nextTo]));
				}
			}
		}
		
		
		//System.out.println(Arrays.toString(visited));
		//System.out.println(Arrays.toString(D));
		
		for(int i =1; i<V+1; i++) {
			if(visited[i]) sb.append(D[i]).append("\n");
			else sb.append("INF");
		}
		System.out.println(sb);
	}
}
