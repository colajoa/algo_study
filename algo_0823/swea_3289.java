package algo_0823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea_3289 {
	static int N, M;
	static int[] parents;

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			parents = new int[N+1];
			for (int n = 1; n < N+1; n++) {
				parents[n] = n;
			}
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < M; i++) {
				token = new StringTokenizer(br.readLine(), " ");
				int calc = Integer.parseInt(token.nextToken());
				int from = Integer.parseInt(token.nextToken());
				int to = Integer.parseInt(token.nextToken());

				if (calc == 0) {
					union(from, to);
				}

				else {
					if (find(from) == find(to)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
				
			}
			sb.append("\n");
			
		}
		bw.write(sb.toString());
		bw.close();
	}
}