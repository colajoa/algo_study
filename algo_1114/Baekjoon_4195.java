package ss_1114;

import java.util.*;
import java.io.*;

public class Baekjoon_4195 {
	static int[] parent, friends;
	static int N;

	static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return;

		parent[bRoot] = aRoot;
		friends[aRoot] += friends[bRoot];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> network = new HashMap<>();

			parent = new int[N * 2];
			friends = new int[N * 2];
			for (int i = 0; i < N * 2; i++) {
				parent[i] = i;
				friends[i] = 1;
			}
			int idx = 0;
			for (int n = 0; n < N; n++) {
				token = new StringTokenizer(br.readLine());

				
				String[] str = new String[2];

				str[0] = token.nextToken();
				if (!network.containsKey(str[0])) {
					
					network.put(str[0], idx++);
				}

				str[1] = token.nextToken();
				if (!network.containsKey(str[1])) {
					
					network.put(str[1], idx++);
				}

				union(network.get(str[0]), network.get(str[1]));

				sb.append(friends[find(network.get(str[1]))]).append("\n");
			}

		}
		System.out.println(sb);
	}
}
