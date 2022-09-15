package ss_0908;

import java.io.*;
import java.util.*;

// 최대한 많은 코어를 연결하고 최소의 전선을 연결해야한다.
// 전선을 놓을 수 있는 경우와 없는 경우를 갈라서 생각한다.
public class swea_1767 {
	static int N, coreCnt, min, maxCore; 
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static List<Core> core;
	
	static class Core{
		int r, c;
		Core(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static void dfs(int depth, int cores, int cable) {
		// 코어를 전부 놓아본 경우
		if(depth == coreCnt) {
			// 지금까지 연결한 코어의 수가 이전 최대 코어 수보다 많은 경우
			if(cores > maxCore) {
				// 전선 최소 수와 코어 최대 수를 갱신
				min = cable;
				maxCore = cores;
			}
			
			// 지금까지 연결한 코어 수가 이전 최대 코어 수와 같은 경우
			else if(cores == maxCore) {
				// 연결한 전선 수를 비교해 최소 값 갱신
				min = Math.min(min, cable);
			}
			return;
		}
			
			// 코어의 위치
			int r = core.get(depth).r;
			int c = core.get(depth).c;
			
			// 전선을 놓을 수 있는 지 확인하기 위해 4방 탐색
			// 놓을 수 있는 전선의 갯수 : flag를 선언해서 조건에 맞으면 flag를 증가시킨다.
			for(int d=0; d<4; d++) {
				int nr = r;
				int nc = c;
				int flag = 0;
				// 한 방향으로 계속 전선을 놓아본다.
				while(true) {
					nr += dr[d];
					nc += dc[d];
					//끝까지 갔다면 반복문 종료
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
						break;
					}
					// 코어나 전선을 만났을 때 전선을 놓을 수 없기때문에 flag를 0으로 만들고 반복문 종료
					if(map[nr][nc] != 0) {
						flag = 0;
						break;
					}
					
					// 끝까지 못갔고 코어나 전선을 만나지 않은 경우 전선을 놓아준다.
					flag += 1;					
				}
				// 전선을 놓을 수 없는 경우
				// 연결한 코어가 없기 때문에 코어와 전선의 수를 증가시키지 않고 다음 코어 탐색을 위해서 depth만 1증가 시킨다.
				if(flag == 0) {
					dfs(depth+1, cores, cable);
				}
				
				// 전선을 놓을 수 있는 경우
				// 전선 수만큼 반복문을 실행시켜 전선을 놓아준다.
				// 다음 코어 탐색을 위해 depth를 1증가 시키고 코어와 전선을 연결했기때문에 각각 1, 전선 수만큼 증가시켜서 탐색
				else {
					nr = r;
					nc = c;
					for(int i=0; i<flag; i++) {
						nr += dr[d];
						nc += dc[d];
						map[nr][nc] = 2;
					}
					dfs(depth+1, cores+1, cable+flag);
					
					// 탐색이 종료되면 다음 위치 탐색을 위해 깔아준 전선을 다시 원상태로 되돌려 준다.
					nr = r;
					nc = c;
					for(int i=0; i<flag; i++) {
						nr += dr[d];
						nc += dc[d];
						map[nr][nc] = 0;
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
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			min = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			core = new ArrayList<>();
			coreCnt = 0; // 초기화를 잘하자.
			for(int r=0; r<N; r++) {
				token = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(token.nextToken());
					
					if(map[r][c] == 1) {
						if(r == 0 || r == N-1 || c == 0|| c == N-1) continue;
						core.add(new Core(r, c));
						coreCnt += 1;
					}
				}
			}
			//System.out.println(core.size());
			dfs(0,0,0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
}