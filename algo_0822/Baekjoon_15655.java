package algo_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_15655 {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] save, nums;
	static void comb(int depth, int start) {
		if(depth==M) {
			for(int i=0; i<M; i++) {
				sb.append(save[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<N; i++) {
			
			save[depth] = nums[i];
			comb(depth+1, i+1);
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

		token = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(nums);
		
		comb(0,0);
		System.out.println(sb);
	}
}
