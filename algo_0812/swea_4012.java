package algo_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4C2
public class swea_4012 {
	static void comb(int start, int cnt) {
		if (cnt == N / 2) {
			//계산
			calc();
			return;
		}

		for (int i = start; i < N; i++) {
			//방문
			visited[i] = true;
			//들어가기
			comb(i + 1, cnt + 1);
			//나오기
			visited[i] = false;
		}
	}

	static void calc() {
		int a = 0;
		int b = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//방문 한것
				if (visited[i] && visited[j])
					a += recipe[i][j];
				//방문 안한것
				if (!visited[i] && !visited[j])
					b += recipe[i][j];
			}
		}
		min = Math.min(min, Math.abs(a - b));
	}

	static int N;
	//레시피
	static int[][] recipe;
	//방문 여부 확인
	static boolean[] visited;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			N = Integer.parseInt(br.readLine());
			recipe = new int[N][N];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				token = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					recipe[i][j] = Integer.parseInt(token.nextToken());
				}
			}

			comb(0, 0);
			System.out.println("#" + (t + 1) + " " + min);
		}
	}
}
