package algo_0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//누적합을 이용해서 빼기를 진행
public class Baekjoon_11659 {
	static StringBuilder str = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		
		//System.out.println(N+" "+M);
		
		token = new StringTokenizer(br.readLine()," ");
		
		int[] nums = new int[N+1];
		int p = 0;
		for(int i=0; i<N; i++) {
			nums[i+1] = nums[i]+Integer.parseInt(token.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(token.nextToken());
			int end = Integer.parseInt(token.nextToken());
			
			str.append(nums[end]-nums[start-1]+"\n");
		}
		System.out.println(str);
	}
}
