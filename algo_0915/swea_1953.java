package ss_0908;

import java.io.*;
import java.util.*;

// 이 정도 문제면 무난.
// 범위 탐색시 탐색할 수 있는지 먼저 검사하기 ex) nr < 0 || nr >= N
public class swea_1953 {
	static int N, M, R, C, L, ans;
	static int[][] map;
	static boolean[][] visited;
	// 상좌하우
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	// 터널마다 연결할 수 있는 방향이 다르기 때문에 터널 종류마다 갈수 있는 배열을 만들어준다. 7개 갈 수 있는 방향으로는 1 없는 방향으로는 0
	static int[][] dir = {{0,0,0,0},{1,1,1,1},{1,0,1,0},{0,1,0,1},{1,0,0,1},{0,0,1,1},{0,1,1,0},{1,1,0,0}};
	
	// 터널의 위치, 종류, 지난 시간을 저장하기 위한 클래스
	static class Tunnel {
		int r, c, type, time;
		Tunnel(int r, int c, int type, int time) {
			this.r = r;
			this.c = c;
			this.type = type;
			this.time = time;
		}
	}
	
	// 탐색을 위한 BFS
	static void bfs() {
		
		Queue<Tunnel> q = new ArrayDeque<>();
		
		// 위치, 종류, 시간
		q.offer(new Tunnel(R, C, map[R][C], 0)); 
		// 방문 처리
		visited[R][C] = true;
		// 갈 수 있는 지점 1개 추가
		ans += 1;
		
		// 큐가 빌때까지 반복
		while(!q.isEmpty()) {
			// 현재 위치
			Tunnel now = q.poll();
			int r = now.r;
			int c = now.c;
			int type = now.type;
			int time = now.time;
			
			for(int d=0; d<4; d++) {
				// 갈 수 있는 방향이 정해져 있기 때문에 갈 수 없는 곳은 건너뛴다.
				if(dir[type][d] == 0) continue;
				
				
				// 갈 수 있다면 방향 설정
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				// 범위를 벗어나거나 터널이 없거나 방문한 터널이라면 건너뛴다.
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 || visited[nr][nc] ) continue;
				
				// 만약 현재의 터널과 다음에 방문할 터널이 서로 연결되있는지 확인. 나머지 연산으로 확인. 0 1 2 3 상 좌 하 우
				if(dir[map[nr][nc]][(d+2)%4] == dir[type][d]) {
					// 연결되있다면 주어진 시간보다 다음에 방문할 터널에서의 시간이 작다면 큐에 넣고, 방문처리, 갈 수 있는 지점의 수 + 1
					if(time + 1 < L) {
					ans += 1;
					q.offer(new Tunnel(nr, nc, map[nr][nc], time+1));
					visited[nr][nc] = true;
					}
				}
			}
			
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			token = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			
			R = Integer.parseInt(token.nextToken());
			C = Integer.parseInt(token.nextToken());
			
			L = Integer.parseInt(token.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int r=0; r<N; r++) {
				token = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(token.nextToken());
				}
			}
			// 정답 출력 변수
			ans = 0;
			bfs();
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
