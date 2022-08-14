package algo_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_15686 {
	static int N;
	static int M;
	static List<int[]> home = new ArrayList<>();
	static List<int[]> chi = new ArrayList<>();
	static int[] arr;
	static int cnt;
	static int min = Integer.MAX_VALUE;
	
	static void find(int start, int cnt, int length) {
		if (cnt == M) {
			calc();
			return;
		}
		for(int i=start; i<length; i++) {
			arr[cnt] = i;
			find(i+1, cnt+1, length);
		}
	}
	
	static void calc() {
		int sum = 0;
		for(int[] h : home) {
			int m = Integer.MAX_VALUE;
			for(int a : arr) {
				m = Math.min(m,Math.abs(h[0]-chi.get(a)[0]) + Math.abs(h[1]-chi.get(a)[1]));
			}
			sum += m;
		}
		min = Math.min(min,sum);
	}
	
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer token = null;
		 
		 token = new StringTokenizer(br.readLine(), " ");
		 N = Integer.parseInt(token.nextToken());
		 M = Integer.parseInt(token.nextToken());
		 arr = new int[M];
		 for(int i=0; i<N; i++) {
			 token = new StringTokenizer(br.readLine()," ");
			 for(int j=0; j<N; j++) {
				 int h = Integer.parseInt(token.nextToken());
				 if(h == 1) home.add(new int[] {i,j});
				 else if(h == 2) chi.add(new int[] {i,j});
			 }
		 }
		 
		 find(0,0,chi.size());
		 
		 System.out.println(min);
	}
}
