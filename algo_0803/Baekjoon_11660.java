package algo_0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_11660 {
	static int areaSum(int x1, int y1, int x2, int y2) {
		return sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
	}
	static int[][] chart;
	static int[][] sum;
	static StringTokenizer token = null;
	static StringBuilder str = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		token = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		chart = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=N; j++) {
				chart[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		sum = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sum[i][j] = +sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+chart[i][j]; 
			}
		}
		int x1, y1, x2, y2;
		for(int i =0; i<M;i++) {
			token = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(token.nextToken());
			y1 = Integer.parseInt(token.nextToken());
			x2 = Integer.parseInt(token.nextToken());
			y2 = Integer.parseInt(token.nextToken());
			
			str.append(areaSum(x1, y1, x2, y2)+"\n");
		}
		System.out.println(str);
	}
}
