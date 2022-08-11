package ss_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder str = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int ans;
		for (int tc = 0; tc < t; tc++) {
			Queue<int[]> q = new ArrayDeque<>();
			StringTokenizer token = new StringTokenizer(br.readLine(), " ");
			// 문서 갯수
			int n = Integer.parseInt(token.nextToken());
			// 찾고자하는 문서 번호
			int m = Integer.parseInt(token.nextToken());
			token = new StringTokenizer(br.readLine(), " ");
			ans = 0;
			for (int i = 0; i < n; i++) {
				// {i 위치 값, 우선순위(중요도)}
				q.offer(new int[] { i, Integer.parseInt(token.nextToken()) });
			}
			
			while (true) {
				// 큐에서 한개 꺼내서 head라는 배열에 저장
				int[] head = q.poll();
				
				// max:중요도 높은가
				// boolean imp = true;
				int max = head[1];
				// for-each로 큐에 들어있는 원소의 중요도와 head의 중요도를 비교  
				for (int[] el : q) {
					// 중요도가 높은게 있다면 max를 변경 후 반복문 종료
					if (head[1] < el[1]) {
						//imp = false;
						max = el[1];
						break;
					}
				}
				//반복문 종료 후 max가 head의 중요도와 같은 지 검사. 같다면 ans 1증가
				// if(imp){
				if(max==head[1]) {
					ans += 1;
					//찾고자하는 원소와 같다면 종료
					if(head[0]==m) break;
				}
				//max와 다르면 꺼낸 head를 다시 큐에 넣어준다.
				else {
					q.offer(head);
				}
			}
			//while문 종료 후 몇번 만에 꺼내진지 횟수 저장
			str.append(ans+"\n");
		}
		System.out.println(str);
	}
}
