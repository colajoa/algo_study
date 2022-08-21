package algo_0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1697_2 {
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		
		dfs(N,K,0);
		System.out.println(ans);
	}
	private static void dfs(int n, int k, int count) {
		//탈출 조건 or 동생이 수빈이 보다 앞선위치에 있을때 바로 탈출. ex) 30 20
		if(n >= k) {
			count += n - k;
			if(ans > count) {
				ans = count;
			}
			return;
		}
		// 한칸씩 바로 이동
		dfs(n, n, count+k-n);
		
		// 수빈이 위치 0일때 1이동.
		if(n==0) {
			n = 1;
			count += 1;
		}
		// 동생위치가 홀수인 경우
		if( k % 2 == 1 ) {
			dfs(n, k + 1, count + 1);
			dfs(n, k - 1, count + 1);
		}
		// 동생위치가 짝수인 경우
		else {
			dfs(n, k / 2, count + 1);
		}
	}
}
