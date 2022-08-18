package ss_0818;

import java.util.Scanner;

// nC4
public class Baekjoon_3049 {
	// N : 꼭짓점 갯수 = 뽑을 범위. start : 시작숫자. cnt : 뽑을 횟수.
	static void comb(int N, int start, int cnt) {
		// 4개 뽑았을 경우 전체 뽑은 횟수 1증가.
		if (cnt == 4) {
			totalcnt += 1;
			return;
		}

		// start부터 N-1까지 숫자 뽑기.
		for (int i = start; i < N; i++) {
			// 뽑을 범위, 다음 시작 숫자 = 중복을 피하기 위해 i+1, 뽑은 횟수 1증가
			comb(N, i + 1, cnt + 1);
		}
	}

	// 전체 뽑은 횟수
	static int totalcnt;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// N이 3이면 대각선을 구할수 없기때문에 종료 없어도 무관.
		if (N == 3) {
			System.out.println("0");
			return;
		}
		// 뽑기
		comb(N, 0, 0);
		// 출력
		System.out.println(totalcnt);
	}
}
