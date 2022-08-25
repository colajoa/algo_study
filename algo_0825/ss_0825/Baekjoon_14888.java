package ss_0825;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon_14888 {
	// 입력 숫자
	static int[] nums;
	// + - * /
	static int[] op;
	// 숫자 갯수
	static int N;
	// 최대 값
	static int max = Integer.MIN_VALUE;
	// 최소 값
	static int min = Integer.MAX_VALUE;
	// 탐색 ans 계산 결과, depth 연산자 사용 횟수
	static void dfs(int ans, int depth) {
		// 탐색 범위가 N과 같으면 최소 값과 최대 값을 구해준다.
		if(depth == N) {
			max = Math.max(max, ans);
			min = Math.min(min, ans);
			return;
		}
		//연산자를 위한 반복문
		for (int i = 0; i < 4; i++) {
			// 해당 연산자가 0보다 크면 조건문 실행
			if (op[i] > 0) {
				// 사용한 것
				op[i]--;
				// op배열에 맞는 연산자 계산을 위해서 switch case문을 이용
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
				// 되돌리기
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
		// dfs(ans, depth) depth를 0으로 해서 N-1개가 되면 종료되도록 하려고 했는데 계산 값이 정답이 아니라서 1로 해줌 
		dfs(nums[0], 1);
		
		bw.write(max+"\n"+min);
		bw.close();
	}
}
