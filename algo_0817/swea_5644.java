package algo_0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_5644 {

	static int[][] map = new int[11][11];
	//
	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };
	static int[] loA;
	static int[] loB;
	static int[] pathA;
	static int[] pathB;
	static int[][] BC;
	static int M, A, ans;

	static void move(int cnt) {
		if (cnt == M + 1)
			return;
		// A, B 위치 이동
		loA[0] += dx[pathA[cnt]];
		loA[1] += dy[pathA[cnt]];
		loB[0] += dx[pathB[cnt]];
		loB[1] += dy[pathB[cnt]];
		//System.out.println(loA[0]+" "+loA[1]+" "+loB[0]+" "+loB[1]);
		// 충전기 탐색
		search();
		move(cnt + 1);
	}

	static void search() {
		// 충전 가능 충전기
		List<Integer> AvailA = new ArrayList<>();
		List<Integer> AvailB = new ArrayList<>();
		for (int i = 0; i < A; i++) {
			// 충전기와 거리 계산 X, Y를 바꿔서 넣어 준다.
			if (Math.abs(loA[0] - BC[i][1]) + Math.abs(loA[1] - BC[i][0]) <= BC[i][2]) {
				// 충전 가능 충전기 저장
				AvailA.add(i);
			}
			// 충전기와 거리 계산  X, Y를 바꿔서 넣어 준다.
			if (Math.abs(loB[0] - BC[i][1]) + Math.abs(loB[1] - BC[i][0]) <= BC[i][2]) {
				// 충전 가능 충전기 저장
				AvailB.add(i);
			}
		}

		int max = 0, maxA = 0, maxB = 0;
		// 충전 가능 충전기가 없을 경우
		if (AvailA.isEmpty() && AvailB.isEmpty())
			return;
		// A만 충전이 가능한 경우
		else if (AvailB.isEmpty()) {
			// 충전기 중에서 최고 성능 고르기
			for (int i : AvailA) {
				maxA = maxA < BC[i][3] ? BC[i][3] : maxA;
			}
		}
		// B만 충전이 가능한 경우
		else if (AvailA.isEmpty()) {
			// 충전기 중에서 최고 성능 고르기
			for (int i : AvailB) {
				maxB = maxB < BC[i][3] ? BC[i][3] : maxB;
			}
		}
		
		// 둘 다 충전이 가능한 경우
		else {
			for (int ai : AvailA) {
				for (int bi : AvailB) {
					int sum = 0;
					// 같은 곳 충전기를 공유하는 경우.
					if (ai == bi) {
						sum = BC[bi][3];
						// 최고 성능보다 같은 충전기를 사용 합이 더 높을 경우
						if(sum > max) {
						maxA = sum/2;
						maxB = sum/2;
						max = sum;
						}
					}
					// 다른 충전기를 쓸 경우
					else {
						// 두 충전기 성능의 합
						sum = BC[ai][3] + BC[bi][3];
						// 최고 성능보다 두 충전기 사용 합이 높을 경우
						if(sum > max) {
							maxA = BC[ai][3];
							maxB = BC[bi][3];
							max = sum;
						}
					}

				}
			}
		}

		ans += maxA + maxB;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		StringTokenizer token = null;
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			token = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(token.nextToken());
			A = Integer.parseInt(token.nextToken());
			pathA = new int[M + 1];
			pathB = new int[M + 1];
			
			//A,B 시작 좌표
			loA = new int[] { 1, 1 };
			loB = new int[]{ 10, 10 };
			// 충전기 좌표, 충전거리, 충전량
			BC = new int[A][4];

			token = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i < M + 1; i++) {
				pathA[i] = Integer.parseInt(token.nextToken());
			}

			token = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i < M + 1; i++) {
				pathB[i] = Integer.parseInt(token.nextToken());
			}

			for (int i = 0; i < A; i++) {
				token = new StringTokenizer(br.readLine(), " ");
				// 충전기 좌표, 충전 거리, 충전량
				BC[i] = new int[] { Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),
						Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()) };
			}
			
			//System.out.println(Arrays.toString(pathA));
			//System.out.println(Arrays.toString(pathB));
			// 정답
			ans = 0;
			move(0);
			str.append("#" + t + " " + ans + "\n");
		}
		System.out.println(str);
	}
}
