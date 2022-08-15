package algo_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_9229 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;

		// 테스트 케이스
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			token = new StringTokenizer(br.readLine(), " ");
			// 과자 갯수
			int N = Integer.parseInt(token.nextToken());
			// 양손에 들수 있는 최대무게
			int M = Integer.parseInt(token.nextToken());
			// 과자 각각의 무게를 배열에 담기
			token = new StringTokenizer(br.readLine(), " ");
			int[] snacks = new int[N];
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(token.nextToken());
			}
			// 들수 있는 최대무게
			int max = 0;
			// 처음부터 끝까지 순회하면서 과자 합의 최대 무게를 구한다.
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int sum = snacks[i] + snacks[j];
					// 최대무게와 비교하면서 max를 갱신한다.
					if (max < sum && sum <= M)
						max = sum;
				}
			}

			// max가 변경되지 않았는지와 최대무게와 작거나 같은지를 검사
			if (max > 0 && max <= M) {
				System.out.println("#" + t + " " + max);
			} else {
				System.out.println("#" + t + " -1");
			}
		}
	}
}
