package algo_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5215 {
	static void subset(int index) {
		
		if(index == N) {
			int score = 0;
			int kcal = 0;
			for(int i =0; i<N; i++) {
				if(isSelected[i]) {
					score += recipe[i][0];
					kcal += recipe[i][1];
				}
			}
			if(kcal <= L) {
				max = Math.max(max, score);
			}
			return;
		}
		
		//유도
		//원소 선택
		isSelected[index] = true;
		subset(index+1);
		//원소 미선택
		isSelected[index] = false;
		subset(index+1);
	}
	static boolean[] isSelected;
	static int N, L;
	static int[][] recipe;
	static int max;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder str = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			token = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(token.nextToken());
			L = Integer.parseInt(token.nextToken());
			recipe = new int[N][2];
			isSelected = new boolean[N];
			max = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				token = new StringTokenizer(br.readLine()," ");
				recipe[i][0] = Integer.parseInt(token.nextToken());
				recipe[i][1] = Integer.parseInt(token.nextToken());
			}
			
			subset(0);
			str.append("#"+t+" "+max+"\n");
		}
		System.out.println(str);
	}
}
