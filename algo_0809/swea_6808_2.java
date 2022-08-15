package algo_0809;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 규영이는 순서 고정 인영이는 순서 무작위
public class swea_6808_2 {
	// cnt : 뽑은 카드 갯수, 규영이 카드 순서, name_Score : 각자 점수.
	static void per(int cnt, int kyuScore, int inScore) {

		// 게임이 끝났다면
		if (cnt == 9) {
			// 규영이 점수가 크다면 승
			if (kyuScore > inScore)
				win += 1;
			// 인영이 점수가 크다면 패
			else if (inScore > kyuScore)
				lose += 1;
		}
		// 0~8까지 순열 : 인영이가 낼 카드 순서 정하기
		for (int i = 0; i < 9; i++) {
			// 이미 고른 카드의 경우 continue로 다음 카드로 넘어감.
			if (isSelected[i])
				continue;
			// 안 고른 카드의 경우 카드를 골라준 후
			isSelected[i] = true;
			// 규영이의 카드와 인영이 카드의 크기 비교
			// 규영이의 카드 숫자가 크다면
			if (kyu.get(cnt) > in.get(i)) {
				// 다음 카드를 뽑으러 가면서, 규영이 점수에 규영이 카드, 인영이 카드 숫자를 더한다.
				per(cnt + 1, kyuScore + kyu.get(cnt) + in.get(i), inScore);
				// 인영이의 카드 숫자가 크다면
			} else if (kyu.get(cnt) < in.get(i)) {
				// 다음 카드를 뽑으러 가면서, 인영이 점수에 규영이 카드, 인영이 카드 숫자를 더한다.
				per(cnt + 1, kyuScore, inScore + kyu.get(cnt) + in.get(i));
			}
			// 다음 뽑을 숫자를 위해서 isSelected false
			isSelected[i] = false;
		}

	}

	static List<Integer> kyu = null;
	static List<Integer> in = null;

	static int win, lose;
	static StringBuilder str = new StringBuilder();
	static boolean isSelected[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			// 규영이와 인영이의 카드패
			kyu = new ArrayList<>();
			in = new ArrayList<>();

			// 순열을 위한 isSelected
			isSelected = new boolean[9];

			// 규영이 카드 패
			for (int i = 0; i < 9; i++) {
				kyu.add(sc.nextInt());
			}
			// 인영이 카드 패
			for (int i = 1; i < 19; i++) {
				in.add(i);
			}
			// 인영이 카드 패에서 규영이가 가지고 있는 카드 삭제
			in.removeAll(kyu);
			// 승패초기화
			win = 0;
			lose = 0;
			// 횟수와 점수 초기화
			per(0, 0, 0);
			str.append("#" + t + " " + win + " " + lose + "\n");
		}
		System.out.println(str);
	}
}
