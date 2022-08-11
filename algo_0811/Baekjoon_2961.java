package algo_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2961 {
	static void comb(int cnt, int s, int b) {

		if (cnt == N) {
			min = Math.min(min, s + b);
			return;
		}

		comb(cnt + 1, s * so[cnt], b + bit[cnt]);
		comb(cnt + 1, s, b);
	}

	static int so[];
	static int bit[];

	static int N;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;

		N = Integer.parseInt(br.readLine());
		so = new int[N];
		bit = new int[N];
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			so[i] = Integer.parseInt(token.nextToken());
			bit[i] = Integer.parseInt(token.nextToken());
		}

		comb(0, 1, 0);
		System.out.println(min);
	}
}
