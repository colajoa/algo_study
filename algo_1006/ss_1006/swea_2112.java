package ss_1006;

import java.io.*;
import java.util.*;
// A = 0, B = 1
public class swea_2112 {
	static int D, W, K;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			token = new StringTokenizer(br.readLine());
			D = Integer.parseInt(token.nextToken());
			W = Integer.parseInt(token.nextToken());
			K = Integer.parseInt(token.nextToken());
			
			map = new int[D][W];
			
			for(int r=0; r<D; r++) {
				token = new StringTokenizer(br.readLine());
				for(int c=0; c<W; c++) {
					map[r][c] = Integer.parseInt(token.nextToken());
				}
			}
		}
	}
}
