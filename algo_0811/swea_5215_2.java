package algo_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5215_2 {
	//집합이기때문에 전체 순회하는 것보다 주어진 조건이 있다면 조건에서 멈추어 끝까지 가지 않도록 한다.
	static void subset(int index, int score, int kcal) {
		if(kcal>L) {
			return;
		}
		if(index == N) {
			if(kcal <= L) {
				max = Math.max(max, score);
			}
			return;
		}
		
		subset(index+1, score+recipe[index][0], kcal+recipe[index][1]);
		subset(index+1, score, kcal);
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
			
			subset(0,0,0);
			str.append("#"+t+" "+max+"\n");
		}
		System.out.println(str);
	}
}
