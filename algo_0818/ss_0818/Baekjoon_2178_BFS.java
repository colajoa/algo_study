package ss_0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// BFS
public class Baekjoon_2178_BFS {
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		// 큐가 비어 있을때 까지 탐색
		while(!q.isEmpty()) {
			// 탐색할 기준 위치
			int[] now = q.poll();
			for(int i=0; i<4; i++) {
				// 상하좌우 탐색
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				// map을 벗어나지 않고 map이 1이고 방문하지 않은 곳 탐색
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 0 && !visited[nx][ny]) {
					// 방문처리
					visited[nx][ny] = true;
					// 깊이 누적
					map[nx][ny] = map[now[0]][now[1]] + 1;
					// 큐에 탐색할 좌표 추가
					q.add(new int[] {nx, ny});
				}
			}
		}
		
		
	}
	// 상하좌우
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static int N, M;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine(), " ");
		// 배열 행렬 크기
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
		bfs(0,0);
		// 깊이 누적 출력
		System.out.println(map[N-1][M-1]);
	}
}
