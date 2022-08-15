package algo_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1227 {
	static void dfs(int x, int y) {
		if(ans==1) return;
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(maze[nx][ny]==3) {
				ans = 1;
				return;
			}
			
			if(nx>=0 && nx<100 && ny>=0 && ny<100 && maze[nx][ny] == 0 && !visited[nx][ny])
				dfs(nx, ny);
		}
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[][] maze;
	// 방문여부
	static boolean[][] visited;
	static int ans;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int TC = Integer.parseInt(br.readLine());
			maze = new int[100][100];
			visited = new boolean[100][100];
			int x = 0;
			int y = 0;
			for (int i = 0; i < 100; i++) {
				String s = br.readLine();
				for (int j = 0; j < 100; j++) {
					maze[i][j] = s.charAt(j) - '0';
					if (maze[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			ans = 0;
			dfs(x, y);
			str.append("#"+TC+" "+ans+"\n");
		}
		System.out.println(str);
	}
}
