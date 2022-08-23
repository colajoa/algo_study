package algo_0823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon_14888 {
	static int[] nums;
	static int[] op;
	static int N;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static void dfs(int ans, int depth) {
		if(depth == N-1) {
			max = Math.max(max, ans);
			min = Math.min(min, ans);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				
				op[i]--;
				switch (i) {
				case 0:
					dfs(ans+ nums[depth], depth+1);
					break;
					
				case 1:
					dfs(ans - nums[depth], depth+1);
					break;
					
				case 2:
					dfs(ans * nums[depth], depth+1);
					break;

				case 3:
					dfs(ans / nums[depth], depth+1);
					break;
				}
				op[i] ++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = null;

		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		op = new int[4];
		
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(token.nextToken());
		}
		
		token = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(token.nextToken());
		}

		dfs(nums[0], 0);
		
		bw.write(max+"\n"+min);
		bw.close();
	}
}
