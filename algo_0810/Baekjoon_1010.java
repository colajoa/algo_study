import java.util.Scanner;

public class Baekjoon_1010 {
	// 0<N<=M<30
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 조합을 담을 배열
		int[][] comb = new int[31][31];

		// i개 중 1를 뽑을 경우의 수를 담아준다.
		for (int i = 1; i < 31; i++) {
			comb[i][1] = i;
		}

		// 2부터 30까지의 조합을 담아준다.
		for (int i = 2; i < 31; i++) {
			for (int j = 2; j < i + 1; j++) {
				comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
			}
		}
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			System.out.println(comb[M][N]);
		}

	}
}