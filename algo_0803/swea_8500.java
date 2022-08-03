package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_8500 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		int max = Integer.MIN_VALUE;
//		int min = Integer.MAX_VALUE;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] num = new int[N];
			int cnt = N;
			token = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				num[i] = Integer.parseInt(token.nextToken());
				max = Integer.max(num[i], max);
			}
			cnt += max;
			for(int i=0; i<N; i++) {
				cnt += num[i];
			}
			System.out.println(max);
			System.out.println("#"+t+" "+cnt);
		}
	}
}
