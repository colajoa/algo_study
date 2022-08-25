package ss_0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
// 빙빙 돌아가는 톱니바퀴
public class Baekjoon_14891 {
	// N극 0 S극 1
	// 1 시계 방향 -1 반시계 방향
	// 1 : 01234567 -> 70123456
	// -1 : 01234567 -> 12345670
	static List<Integer>[] wheel;
	static int[] clockwise;
	static boolean[] possible;
	// 돌아가는 방향
	static int[] clockwise1 = new int[] { 1, -1, 1, -1 };
	static int[] clockwise2 = new int[] { -1, 1, -1, 1 };

	static void rotate() {
		for (int i = 0; i < 4; i++) {
			if (possible[i]) {
				if (clockwise[i] == 1) {
					// 오른쪽으로 밀기
					int temp = wheel[i].get(7);

					for (int n = 7; n > 0; n--) {
						wheel[i].set(n, wheel[i].get(n - 1));
					}
					wheel[i].set(0, temp);
				} else {
					// 왼쪽으로 밀기
					int temp = wheel[i].get(0);

					for (int n = 0; n < 7; n++) {
						wheel[i].set(n, wheel[i].get(n + 1));
					}
					wheel[i].set(7, temp);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		wheel = new ArrayList[4];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		int ans = 0;
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			wheel[i] = new ArrayList<>();
			for (int c = 0; c < 8; c++) {
				// 입력 받기
				wheel[i].add(s.charAt(c) - 48);
			}
		}
		/*System.out.println();
		for (int i = 0; i < 4; i++) {
			System.out.println(wheel[i]);
		}
		System.out.println();*/
		// 명령 갯수
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			// 돌아가는 톱니
			int pos = Integer.parseInt(token.nextToken()) - 1;
			// 방향
			int rot = Integer.parseInt(token.nextToken());
			// 전체 돌아가는 방향
			clockwise = clockwise1[pos] == rot ? clockwise1 : clockwise2;
			// 돌아갈 수 있는지
			possible = new boolean[4];
			// 돌아가는 톱니는 무조건 돌아가므로 true
			possible[pos] = true;
			// 돌아가는 톱니의 위치를 이용해서 다른 톱니바퀴 돌아가는 지 확인
			switch (pos) {
			case 0:
				for (int j = 1; j < 4; j++) {
					if (wheel[j - 1].get(2) != wheel[j].get(6))
						possible[j] = true;
					else {
						break;
					}

				}
				rotate();
				break;
			case 1:
				if (wheel[pos].get(6) != wheel[pos - 1].get(2))
					possible[pos - 1] = true;
				if (wheel[pos].get(2) != wheel[pos + 1].get(6)) {
					possible[pos + 1] = true; 
				if (wheel[pos + 1].get(2) != wheel[pos + 2].get(6)) {
					possible[pos + 2] = true;
				}
			}
				rotate();
				break;

			case 2:
				if (wheel[pos].get(2) != wheel[pos + 1].get(6))
					possible[pos + 1] = true;
				if (wheel[pos].get(6) != wheel[pos - 1].get(2)) {
					possible[pos - 1] = true;
					if (wheel[pos - 1].get(6) != wheel[pos - 2].get(2)) {
						possible[pos - 2] = true;
					}
				}
				rotate();
				break;

			case 3:
				for (int j = 2; j > -1; j--) {
					if (wheel[j].get(2) != wheel[j + 1].get(6))
						possible[j] = true;
					else {
						break;
					}
				}
				rotate();
				break;
			}
			/*System.out.println("#" + i);
			System.out.println(Arrays.toString(possible));
			for (int n = 0; n < 4; n++) {
				System.out.println(wheel[n]);
			}
			System.out.println();*/
		}
		for (int i = 0; i < 4; i++) {
			int pow = (int) Math.pow(2, i);
			if (wheel[i].get(0) != 0)
				ans += pow;
		}
		System.out.println(ans);
	}
}
