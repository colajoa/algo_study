package swea;
import java.io.*;
import java.util.*;
public class swea_1486 {
	static int N, B, H[], ans;
	
	static void subSet(int depth, int sum) {
		if(depth==N) {
			if(sum >= B)
				ans = Math.min(sum-B, ans);
			return;
		}
		
		subSet(depth+1, sum+H[depth]);
		subSet(depth+1, sum);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token =null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			token = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(token.nextToken());
			B = Integer.parseInt(token.nextToken());
			H = new int[N];
			ans = Integer.MAX_VALUE;
			token = new StringTokenizer(br.readLine());
			
			for(int n=0; n<N; n++) {
				H[n] = Integer.parseInt(token.nextToken());
			}
			
			subSet(0,0);
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
