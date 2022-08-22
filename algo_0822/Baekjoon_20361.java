package algo_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_20361 {
	// 종이 컵 위치를 바꿔줄 메서드
	static void swap(int a, int b, int[] cups) {
		// 바꿀 위치 저장
		int temp = cups[a];
		// a와 b 자리 교환
		cups[a] = cups[b];
		cups[b] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		// 종이 컵 갯수, 간식이 있는 종이 컵, 컵 위치 바꾸는 횟수.
		int N;
		int X;
		int K;
		// 둘째 줄 입력
		// 종이 컵 갯수, 간식이 있는 종이 컵, 컵 위치 바꾸는 횟수 입력
		token = new StringTokenizer(br.readLine(), " ");
		// 종이 컵 갯수, 간식이 있는 종이 컵, 컵 위치 바꾸는 횟수 할당
		N = Integer.parseInt(token.nextToken());
		X = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());
		// 종이 컵 배열
		int[] cups = new int[N + 1];
		// 간식이 있는 종이 컵
		cups[X] = 1;
		// 컵 위치 바꾸는 입력
		for (int i = 0; i < K; i++) {
			// 종이컵 바꾸는 위치 입력
			token = new StringTokenizer(br.readLine(), " ");
			// 종이컵 바꾸는 위치
			int A = Integer.parseInt(token.nextToken());
			int B = Integer.parseInt(token.nextToken());
			// 종이컵 위치 바꾸기
			swap(A, B, cups);
		}
		// 간식이 든 종이 컵 위치 출력
		for (int i = 1; i < N + 1; i++) {
			// 간식이 들었다면 위치를 저장하고 탈출
			if (cups[i] == 1) {
				// 간식이 든 종이컵 위치 결과
				sb.append(i);
				break;
			}
		}
		// 결과 출력
		System.out.println(sb);
	}
}
