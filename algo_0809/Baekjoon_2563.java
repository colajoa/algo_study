package algo_0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2563 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine()," ");
			int w = Integer.parseInt(token.nextToken());
			int h = Integer.parseInt(token.nextToken());
			for(int r=h; r<h+10; r++) {
				 for(int c=w; c<w+10; c++){
					map[r][c] = 1; 
				 }
			}
		}
		int cnt = 0;
		for(int r=1; r<=100; r++) {
			for(int c=1; c<=100; c++) {
				if(map[r][c]==1)
					cnt += 1;
			}
		}
		System.out.println(cnt);
	}
}
