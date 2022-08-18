package ss_0818;

import java.util.Scanner;

public class Baekjoon_1388 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// -와 | 카운트 변수
		int Rcnt = 0;
		int Ccnt = 0;

		// 가로 세로
		int N = sc.nextInt();
		int M = sc.nextInt();
		// 이전 입력 공백 제거
		sc.nextLine();
		// 바닥 배열
		char[][] floor = new char[N][M];
		// 바닥 입력
		for (int i = 0; i < N; i++) {
			String f = sc.nextLine();
			for (int j = 0; j < M; j++) {
				floor[i][j] = f.charAt(j);
			}
		}

		// 가로 검사
		for (int r = 0; r < N; r++) {
			// 같은 모양인지 검사를 위한 boolean
			boolean same = false;
			for (int c = 0; c < M; c++) {
				if (floor[r][c] == '-') {
					// same이 true이면 같은 모양 continue로 탈출
					if (same)
						continue;
					// 가로 판자 + 1 같은 모양 true
					Rcnt += 1;
					same = true;
					// -모양이 아니면 같은 모양이 아니므로 same은 false
				} else {
					same = false;
				}
			}
		}

		// 세로 검사
		for (int c = 0; c < M; c++) {
			// 같은 모양인지 검사를 위한 boolean
			boolean same = false;
			for (int r = 0; r < N; r++) {
				if (floor[r][c] == '|') {
					// same이 true이면 같은 모양 continue로 탈출
					if (same)
						continue;
					// 가로 판자 + 1 같은 모양 true
					Ccnt += 1;
					same = true;
					// |모양이 아니면 같은 모양이 아니므로 same은 false
				} else {
					same = false;
				}
			}
		}

		System.out.println(Ccnt + Rcnt);
	}
}
