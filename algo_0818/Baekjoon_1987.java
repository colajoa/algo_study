package algo_0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_1987 {
	static int R, C;
	static int count = 0;
	static char[][] alpha;
	static List<Character> list = new ArrayList<>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static void dfs(int x, int y, int cnt) {
		
		if(list.contains(alpha[x][y])) {
			count = Math.max(cnt, count);
			return;
		}
		else {
			list.add(alpha[x][y]);
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < R && ny >= 0 && ny < C ) {
					
					dfs(nx, ny, cnt+1);
				}
			}
			
			list.remove((Character)alpha[x][y]);

		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		alpha = new char[R][C];
		for(int i = 0; i<R; i++) {
			alpha[i] = br.readLine().toCharArray();
		}
		dfs(0,0,0);
		System.out.println(count);
	}
	/*static int R, C;
	static int count = 0;
	static char[][] alpha;
	static List<Character> list = new ArrayList<>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static void dfs(int x, int y, int cnt) {
		
		if(check(alpha[x][y])) {
			count = Math.max(cnt, count);
			return;
		}
		else {
			list.add(alpha[x][y]);
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < R && ny >= 0 && ny < C ) {
					
					dfs(nx, ny, cnt+1);
				}
			}
			
			list.remove((Character)alpha[x][y]);

		}
		
	}
	
	static boolean check(char c) {
		if(list.contains(c)) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		alpha = new char[R][C];
		for(int i = 0; i<R; i++) {
			alpha[i] = br.readLine().toCharArray();
		}
		dfs(0,0,0);
		System.out.println(count);
	}*/
}
