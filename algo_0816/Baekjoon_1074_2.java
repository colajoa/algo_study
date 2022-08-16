package algo_0816;

import java.util.Scanner;

// 사분면으로 계산.
public class Baekjoon_1074_2 {
	static void search(int startX, int startY, int size) {
		if (size == 1) {
			return;
		}
		// 현재 있는 사분면 계산
		int sr = (r / (size/2)) * (size/2);
		int sc = (c / (size/2)) * (size/2);
		
		// startX와 startY를 기준으로 현재 있는 사분면으로 방문한 칸의 갯수
		if (sr == startX && sc > startY)
			count += (size/2)*(size/2);
		else if (sr > startX && sc == startY)
			count += (size/2)*(size/2) * 2;
		else if (sr > startX && sc > startY)
			count += (size/2)*(size/2) * 3;
		
		// 다음에 쓸 좌상단 좌표와  배열의 길이를 반으로 줄여 넘겨준다.
		search(sr, sc, size / 2);
	}

	static int count;
	static int r, c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 크기 2^N * 2^N
		int N = sc.nextInt();
		// 찾고자하는 좌표
		r = sc.nextInt();
		c = sc.nextInt();
		// 한변의 길이
		int size = 1 << N;
		// 정답
		count = 0;
		// 좌상단 좌표, 배열의 길이
		search(0, 0, size);
		System.out.println(count);
	}
}
