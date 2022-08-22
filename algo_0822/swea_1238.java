package algo_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1238 {
	static int N, start;
	static int[][] contact;
	static int ans;

	static void bfs() {
		// bfs를 위한 큐
		Queue<Integer> q = new ArrayDeque<>();
		// 번호 방문 여부
		boolean[] visited = new boolean[101];
		// 처음 시작 방문처리
		visited[start] = true;
		// 시작 지점 큐에 넣기
		q.offer(start);
		// 방문 노드 중 가장 큰 값
		int max = 0;
		while (!q.isEmpty()) {
			// 큐의 크기만큼 한번 더 반복문. 각 레벨 별로 누구에게 연락했는지 검사해야한다.
			int size = q.size();
			// 각 레벨별로 가장 큰 값 저장위해 초기화
			// 출력은 마지막 레벨에서 가장 큰값
			max = 0;
			for (int s = 0; s < size; s++) {
				// 헤드의 값을 현재 위치
				int now = q.poll();
				// 관계 확인을 위한 반복문
				for (int i = 1; i < 101; i++) {
					// from to로 연락을 할 수 있으며 방문하지 않았다면
					if (contact[now][i] != 0 && !visited[i]) {
						// 방문 처리
						visited[i] = true;
						// 다음 방문을 위해 큐에 넣기
						q.offer(i);
						// 큰 값 찾기
						max = max < i ? i : max;
						// 큰 값 저장
						ans = max;
					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			token = new StringTokenizer(br.readLine(), " ");
			// 입력 받는 from to의 총합 관계는 N/2개
			N = Integer.parseInt(token.nextToken());
			// 시작 위치
			start = Integer.parseInt(token.nextToken());
			// 연락 배열 2차원 배열로 서로의 관계를 설정해준다.
			contact = new int[101][101];

			token = new StringTokenizer(br.readLine(), " ");
			// {from, to}로 주어지기 때문에 반복은 N/2만큼
			for (int i = 0; i < N / 2; i++) {
				// from to 행은 from 열은 to로 가르키는 방향으로 배열에 1할당
				int from = Integer.parseInt(token.nextToken());
				int to = Integer.parseInt(token.nextToken());
				contact[from][to] = 1;
			}
			// 정답
			ans = 0;
			// 탐색
			bfs();
			// 정답 저장
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		// 답 출력
		System.out.println(sb);
	}
}
