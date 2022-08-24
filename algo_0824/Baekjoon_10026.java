package algo_0824;
import java.io.*;
import java.util.*;

// 주어진 조건 안에 구역이 있다면 반복문을 통해서 하나하나씩 탐색
// 조건을 나눠서 생각도 해봐야한다.
public class Baekjoon_10026 {
	static int N, cnt;
	static char[][] map;
	static char[][] colorBlindMap;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static void dfs(int x, int y, char[][] map) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<N && ny >=0 && ny <N && !visited[nx][ny] && map[nx][ny] == map[x][y]) {
				//System.out.println(nx+" "+ny+" "+map[x][y]+" "+ map[nx][ny]);
				dfs(nx, ny, map);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		colorBlindMap = new char[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'R') {
					colorBlindMap[i][j] = 'G';
					continue;
				}
				colorBlindMap[i][j] = map[i][j];
			}
		}
//		for(char[] c : colorBlindMap) {
//			System.out.println(Arrays.toString(c));
//		}
		
		cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, map);
					cnt += 1;
				}
			}
		}
		//System.out.println();
		sb.append(cnt).append(" ");
		
		cnt = 0;
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, colorBlindMap);
					cnt += 1;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
}
