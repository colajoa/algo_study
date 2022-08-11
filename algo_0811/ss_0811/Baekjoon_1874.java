package ss_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		// 수열 갯수
		int N = Integer.parseInt(br.readLine());
		
		//스택에 담을 숫자.
		int num = 0;

		//N 0이 아니면 반복
		while (N != 0) {
			// 수열 숫자 받아오기
			int in = Integer.parseInt(br.readLine());
			// 스택에 담을 숫자가 입력 수열 숫자보다 작은지 검사 
			if (num < in) {
				// 작다면 num+1부터 in까지 숫자 담기
				for (int i = num + 1; i <= in; i++) {
					stack.push(i);
					str.append("+\n");
				}
				//다음 push를 위해 저장
				num = in;
			}
			
			else if(stack.peek() != in) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			str.append("-\n");
			N -= 1;
		}
		System.out.println(str);

	}
}