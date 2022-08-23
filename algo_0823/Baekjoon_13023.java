package algo_0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_13023 {
	static int N, M;
	static boolean friends;
	static boolean[] visited;
	static List<Integer>[] list;
	static void dfs(int v, int depth) {
		// depth가 5면
		if(depth == 5) {
			// 관계를 true
			friends = true;
			return;
		}
		// 현재 노드 방문
		visited[v] = true;
		// 현재 노드 중 방문하지 않은 노드 dfs
		for(int i: list[v]) {
			if(!visited[i]) {
				dfs(i,depth+1);
			}
		}
		// 다음을 위한 방문처리 false
		visited[v] = false;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine()," ");

		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		// 친구 관계 인접리스트로 저장
		list = new ArrayList[N];
		// 정답 출력을 위한 플래그
		friends = false;
		// 방문 배열
		visited = new boolean[N];
		// 관계를 저장할 리스트 배열 초기화
		for(int i=0; i<N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		// 관계 저장
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(token.nextToken());
			int to = Integer.parseInt(token.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		// 노드 수만큼 반복
		for(int i=0; i<N; i++) {
			// dfs
			dfs(i,1);
			// depth가 5라면
			if(friends)
				break;
		}
		// 정답 출력  depth 5가 있으면 1 없으면 0
		if(friends)
			System.out.println("1");
		else 
			System.out.println("0");
	}
}
