package ss_0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// DFS
public class Baekjoon_2178_DFS {
	static void dfs(int x, int y, int cnt) {
		// 찾고자 하는 위치이면 방문 횟수를 min 값과 비교해 min을 갱신
		if(x == N-1 && y == M-1) {
			min = Math.min(min, cnt);
			return;
		}
		
		for(int i=0; i<4; i++) {
			// 상하좌우 탐색
			int nx = x + dx[i];
			int ny = y + dy[i];
			// map을 벗어나지 않고 map이 1이고 방문하지 않은 곳 탐색
			if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1) {
				map[x][y] = -1;
				dfs(nx, ny, cnt+1);
				map[x][y] = 1;
			}
		}
	}
	// 상하좌우
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static int N, M, min = Integer.MAX_VALUE; 
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		dfs(0,0,1);
		System.out.println(min);
	}
}
