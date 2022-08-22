package algo_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_15654 {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] save, nums;
	static boolean[] visited;
	static void perm(int depth) {
		if(depth==M) {
			for(int i=0; i<M; i++) {
				sb.append(save[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			
			if(visited[i]) continue;
			visited[i] = true;
			save[depth] = nums[i];
			perm(depth+1);
			visited[i] = false;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		token = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		
		nums = new int[N];
		save = new int[M];
		visited = new boolean[N];
		token = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(nums);
		
		perm(0);
		System.out.println(sb);
	}
}
