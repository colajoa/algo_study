package ss_0908;

import java.io.*;
import java.util.*;

// 맵을 복사하면서 진행하지 말고 경우의 수를 뽑고 결과를 확인한다음 처음 원본으로 되돌린다.
// 중복조합으로 뽑은 조합으로 전부 탐색을 진행하여 결과를 출력
public class swea_5656 {
	static int N, W, H;
	static int[][] map, copy;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int min;
	static int[] chose;
	static Queue<Coordi> q;

	// 좌표와 블록에 적힌 수를 저장하기 위한 클래스
	static class Coordi {
		int r;
		int c;
		int blockNum;
		
		Coordi(int r, int c, int blockNum) {
			super();
			this.r = r;
			this.c = c;
			this.blockNum = blockNum;
		}
	}
	
	// 중복조합 뽑기
	static void comp(int depth) {
		// N개 만큼 뽑았다면 공을 떨어트린다.
		if (depth == N) {
			dropBall(chose);
			// 공을 다 떨어트렸다면 블록의 남은 블록의 갯수를 세서 최소값이랑 비교
			min = Math.min(min, blockCnt());
			// map을 초기 상태도 되돌려준다.
			copyMap();
			return;
		}

		// 조합 뽑기 중복조합이기때문에 start를 선언해주지 않는다.
		for (int i = 0; i < W; i++) {
			chose[depth] = i;
			comp(depth + 1);
		}

	}
	
	// 맵 원복시키기
	static void copyMap() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = copy[i][j];
			}
		}
	}
	
	// 공 떨어뜨리기
	static void dropBall(int[] chose) {
		
		// N번 떨어뜨리기 때문에 N번 반복문
		for(int n=0; n<N; n++) {
			// 큐를 여기서 선언해서 다음 떨어뜨릴때 마다 블록이면 새로운 큐에 집어 넣어준다.
			q = new ArrayDeque<>();
			int w = chose[n];
			for(int h=0; h<H; h++) {
				// 행에서 가장 처음 맞이하는 블록을 큐에 좌표와 적힌 숫자를 저장한 후 위치의 숫자를 0으로 만들어주고 반복문을 탈출한다.
				if(map[h][w] != 0) {
					q.add(new Coordi(h, w, map[h][w]));
					map[h][w] = 0;
					break;
				}
			}
			// 블록 지우기
			removeBlocks();
			// 남은 블록을 아래로 내린다.
			dropBlock();
		}
		
	}
	
	// 블록 지우기
	static void removeBlocks() {
		
			// 큐가 빌때까지 반복
			while (!q.isEmpty()) {
				// 큐에 있는 공이 떨어진 위치와 블록에 적힌 숫자 꺼내기
				Coordi now = q.poll();
				// 4방 탐색 시작
				for (int dir = 0; dir < 4; dir++) {
					// 행과 열을 변수로 선해주고 블록에 적힌 수만큼 반복해준다. n-1만큼 옆으로 나가지만 확산되는 기준점부터 카운트했습니다.
					int r = now.r;
					int c = now.c;
					int cnt = 1;
					
					// 확산되어 없어진 블록의 숫자가 블록에 적힌 숫자와 같을 때까지 반복
					while (cnt != now.blockNum) {
						
						// 나아갈 방향
						int nr = r + dr[dir];
						int nc = c + dc[dir];
						
						// 탐색 범위를 벗어나면 종료 반복문 탈출
						if(nr < 0 || nr >= H || nc < 0 || nc >= W) break;
							
							// 블록에 적힌 숫자가 0이 아니면 큐에 담고 그 위치를 0으로 만들어 준 다음 r과 c를 변경하고 cnt를 하나 올린다.
							if(map[nr][nc] != 0 ) {
								q.offer(new Coordi(nr, nc, map[nr][nc]));
								map[nr][nc] = 0;
								r = nr;
								c = nc;
								cnt += 1;
							}
							// 0이면 r과 c만 바꾸고 cnt를 하나 올린다.
							else {
								r = nr;
								c = nc;
								cnt += 1;
							}	
						
					}
				}
			}
	}
	
	// 남은 블록 아래로 내리기
	static void dropBlock() {
		// 열 단위로 내리기 위해서 열부터 반복문을 시작해서 행을 안에서 반복시켜준다.
		for (int c = 0; c < W; c++) {
			// 리스트를 이용해서 남은 블록을 밑에서부터 담아준다.
			List<Integer> col = new ArrayList<>();
			// 배열 가장 아래 행부터 탐색 시작
			for (int r = H - 1; r > -1; r--) {
				// 블록이면 리스트에 담아주고 그 위치는 0으로 바꿔준다.
				if (map[r][c] != 0) {
					col.add(map[r][c]);
					map[r][c] = 0;
				}
			}
			// 아래 행부터 담았기 때문에 맵 아래부터 배열 앞부터 차례로 꺼내서 쌓아준다. 
			int r = H-1;
			for(int i=0; i<col.size(); i++) {
				map[r-i][c] = col.get(i);
			}
		}
	}
	
	// 남은 블록 세기 0보다 크면 cnt를 하나 올리고 반복문이 끝나면 cnt 리턴
	static int blockCnt() {
		int cnt = 0;
		for(int r=0; r<H; r++) {
			for(int c=0; c<W; c++) {
				if(map[r][c] > 0) {
					cnt += 1;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine());

			N = Integer.parseInt(token.nextToken());
			W = Integer.parseInt(token.nextToken());
			H = Integer.parseInt(token.nextToken());
			map = new int[H][W];
			copy = new int[H][W];
			chose = new int[N];

			for (int h = 0; h < H; h++) {
				token = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					map[h][w] = Integer.parseInt(token.nextToken());
					copy[h][w] = map[h][w];
				}
			}
			min = Integer.MAX_VALUE;
			comp(0);
			
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
}
