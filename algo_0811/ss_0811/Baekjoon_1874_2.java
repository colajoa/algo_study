package ss_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Baekjoon_1874_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] in = new int[N];
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> sequence = new ArrayDeque<>();
		
		// 수열 입력 
		for(int i=1; i<=N; i++) {
			sequence.offer(Integer.parseInt(br.readLine()));
		}

		// 1~N까지 입력
		for(int i=1; i<=N; i++) {
			stack.push(i);
			str.append("+\n");
				// 스택이 비어있지 않고 수열 head와 스택 top을 비교해서 같다면 while 
				while(!stack.empty() && stack.peek()== sequence.peek()) {
					stack.pop();
					sequence.poll();
					str.append("-\n");
				}
			}
		
		// 스택에서 다꺼냈다면 삽입 삭제 순서를 출력
		if(stack.empty()) {
			System.out.print(str);
		}
		// 아니면 "NO" 출력
		else {
			System.out.print("NO");
		}
	}
}
