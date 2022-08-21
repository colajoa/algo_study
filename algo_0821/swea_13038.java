package algo_0821;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1이 있는 모든 위치의 경우를 다따져야한다. 0인 경우는 볼필요도 없다.
public class swea_13038 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int n = Integer.parseInt(br.readLine());
			token = new StringTokenizer(br.readLine(), " ");
			int[] days;
			days = new int[] { Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),
					Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),
					Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),
					Integer.parseInt(token.nextToken()) };

			
			int ans = Integer.MAX_VALUE;
			int cnt = 0;
			int idx = 0;
			for (int i = 0; i < 7; i++) {
				if (days[i] == 0) continue;
				cnt = 0;
				idx = i;

				while (true) {

					if (days[idx % 7] == 1) {
						cnt += 1;
					}
					idx += 1;

					if (cnt == n) {
						ans = Math.min(ans, idx - i);
						break;
					}
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
