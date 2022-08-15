package algo_0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1861 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder str = new StringBuilder();
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 배열의 크기
			int N = Integer.parseInt(br.readLine());
			// 방
			int[][] room = new int[N][N];
			// 방에 있는 숫자 입력
			for (int r = 0; r < N; r++) {
				token = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					room[r][c] = Integer.parseInt(token.nextToken());
				}
			}
			// 정답 출력을 위한 배열
			int[] ans = new int[2];
			// 방에 적힌 숫자가 가장 작은 값 출력을 위한 min값
			ans[0] = Integer.MAX_VALUE;
			// 최대 이동 횟수
			ans[1] = 0;
			// N x N 배열 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 방 이동 횟수
					int cnt = 1;
					// 현재 위치
					int nx = i;
					int ny = j;
					// 사방 탐색 1개라도 가능하면 계속 탐색
					while (true) {
						// 탐색 실패 여부 확인
						int fail = 0;
						// 사방 탐색을 위한 반복문
						for (int idx = 0; idx < 4; idx++) {
							// 배열 범위를 벗어나지 않고 현재 위치보다 상하좌우에서 + 1이 큰지 검사.
							if (nx + dx[idx] >= 0 && nx + dx[idx] < N && ny + dy[idx] >= 0 && ny + dy[idx] < N
									&& room[nx][ny] + 1 == room[nx + dx[idx]][ny + dy[idx]]) {
								// 이동 횟수 증가
								cnt += 1;
								// 현재 위치 이동할 방으로 갱신.
								nx += dx[idx];
								ny += dy[idx];
								// 탈출
								break;
							}
							// 아니라면 fail 증가
							fail += 1;
						}
						// 사방 탐색이 모두 실패시 while 탈출
						if (fail == 4) {
							break;
						}
					}
					// 이동 탐색이 끝났다면
					// 현재 저장된 최대 횟수와 현재 이동 횟수를 비교
					if (ans[1] < cnt) {
						// 현재 이동 횟수가 크다면 최대 횟수 갱신
						ans[1] = cnt;
						// 방 번호 갱신
						ans[0] = room[i][j];
						// 현재 이동 횟수가 최대 횟수와 같고 현재 방 번호가 저장된 방 번호보다 작다면
					} else if (ans[1] == cnt && ans[0] > room[i][j]) {
						// 방 번호를 작은 것으로 갱신.
						ans[0] = room[i][j];
					}
				}
			}
			str.append("#" + t + " " + ans[0] + " " + ans[1] + "\n");
		}
		System.out.println(str);
	}
}
