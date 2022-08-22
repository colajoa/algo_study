package algo_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1759 {
	static int L, C;
	static char[] c;
	static char[] ch;
	static StringBuilder sb = new StringBuilder();
	static void dfs(int depth, int start, int m, int j) {
		if(depth == L) {
			if(m >= 1 && j >= 2) {
			for(int i=0; i<L; i++) {
				sb.append(ch[i]);
			}
			sb.append("\n");
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			ch[depth] = c[i];
			if(!isM(c[i])) {dfs(depth+1, i+1, m, j+1);}
			else if(isM(c[i])) {dfs(depth+1, i+1, m+1, j);}
		}
	}
	
	static boolean isM(char c) {
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
			return true;
		return false;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		// 모음 확인을 위한 배열
		L = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		c = new char[C];
		ch = new char[L];
		String[] s = br.readLine().split(" ");
		for(int i=0, len=s.length; i<len; i++) {
			c[i] = s[i].charAt(0);
		}
		
		Arrays.sort(c);
		dfs(0,0,0,0);
		System.out.println(sb);
	}
}
