package algo_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_15656 {
	static StringBuilder sb = new StringBuilder();
	static void perm(int depth, int[] nums, int N, int M, int[] save) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(save[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			save[depth] = nums[i];
			perm(depth+1, nums, N, M, save);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		
		token = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int[] nums = new int[N];
		int[] save = new int[M];
		token = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(nums);
		perm(0,nums,N, M,save);
		System.out.println(sb);
	}
}
