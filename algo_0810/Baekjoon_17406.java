import java.util.Scanner;

public class Baekjoon_17406 {
	// idx : 뽑은 순서를 저장 . c : 주어진 r,c,s 갯수 K.
	static void dfs(int idx, int c) {
		// 뽑은 갯수가 주어진 갯수와 같다면
		if (idx == c) {
			// 기존의 입력 받은 배열을 복사.
			int[][] rotmap = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					rotmap[i][j] = map[i][j];
				}
			}
			// 배열을 돌리는 메서드 호출
			rotate(rotmap);
			return;
		}
		
		// 주어진 갯수 K만큼 반복
		for (int i = 0; i < K; i++) {
			// 뽑은 수라면 다음 수 검사
			if (visited[i])
				continue;
			// 뽑지 않았다면 뽑아 주고 perm에 순서를 저장.
			visited[i] = true;
			perm[idx] = i;
			// 다음 수를 뽑으러 메서드호출
			dfs(idx + 1, c);
			// 다른 순열에서 뽑아야하기 때문에 false로 처리.
			visited[i] = false;
		}
	}

	static void rotate(int[][] rotmap) {
		for (int p : perm) {
			// 좌측 상단 (lx, ly) 우측 하단 (rx, ry) 좌표
			int lx = rcs[p][0] - rcs[p][2] - 1;
			int ly = rcs[p][1] - rcs[p][2] - 1;
			int rx = rcs[p][0] + rcs[p][2] - 1;
			int ry = rcs[p][1] + rcs[p][2] - 1;
			// 회전시킬 배열의 크기를 구해서 회전 횟수구하기
			// 여기서 회전 횟수는 전체를 회전시킬 횟수가 아닌 중심으로 가면서 회전되는 배열 갯수이다.
			int n = rx - lx;
			int m = ry - ly;
			// 가로 세로 크기의 최소값을 2로 나누기.
			int sq = Math.min(n, m) / 2;
			
			// idx를 0부터 시작해서 회전 횟수를 정해주고 idx가 증가하면서
			// 배열 중심으로 좌표가 이동하면서 안쪽까지 회전한다.
			for (int idx = 0; idx < sq; idx++) {
				// 시작지점 tmp에 저장
				int tmp = rotmap[lx+idx][ly+idx];
				// 하 -> 상
				for (int i = lx+idx; i < rx-idx; i++) {
					rotmap[i][ly+idx] = rotmap[i + 1][ly+idx];
				}
				// 오 -> 왼
				for (int i = ly+idx; i < ry-idx; i++) {
					rotmap[rx-idx][i] = rotmap[rx-idx][i + 1];
				}
				// 상 -> 하
				for (int i = rx-idx; i > lx+idx; i--) {
					rotmap[i][ry-idx] = rotmap[i - 1][ry-idx];
				}
				// 왼 -> 오
				for (int i = ry-idx; i > ly+idx; i--) {
					rotmap[lx+idx][i] = rotmap[lx+idx][i - 1];
				}
				// 시작 지점의 값을 옮겨질 위치로 변경
				rotmap[lx+idx][ly+idx + 1] = tmp;

			}
		}
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += rotmap[i][j];
			}
			min = Math.min(min, sum);
		}
	}

	static int N, M, K;
	static int[][] rcs;
	static boolean[] visited;
	static int[][] map;
	static int[] perm;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// r, c, s를 담을 배열
		rcs = new int[K][3];

		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			// r,c,s 순서대로 저장
			rcs[i] = new int[] { r, c, s };
		}

		// 순열 담을 배열
		perm = new int[K];
		// 번호 방문 여부
		visited = new boolean[K];
		dfs(0, K);
		System.out.println(min);
	}
}