package algo_0812;

import java.util.Scanner;

public class swea_1227 {
	static void dfs(int x, int y) {
		
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,0};
	static boolean[][] visited = new boolean[100][100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
		int TC = sc.nextInt();
		int[][] maze = new int[100][100];
		int x = 0;
		int y = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				maze[i][j] = sc.nextInt();
				if(maze[i][j]==2) x=i; y=j;
			}
		}
		
		dfs(x, y);
		}
	}
}
