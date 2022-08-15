package algo_0808;

import java.io.*;
import java.util.*;

public class swea_1228 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder str = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			// 원본 암호문 담을 LinkedList
			LinkedList<Integer> list = new LinkedList<>();

			// 원본 암호문 길이
			int N = Integer.parseInt(br.readLine());
			// 원본 암호문 입력 받아 LinkedList에 추가
			token = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(token.nextToken()));
			}
			// 추가할 명령 갯수
			int M = Integer.parseInt(br.readLine());
			// I와 공백을 구분하여 입력 받기
			token = new StringTokenizer(br.readLine(), "I ");
			for (int i = 0; i < M; i++) {
				// start 암호문을 삽입하고자하는 위치
				int start = Integer.parseInt(token.nextToken());
				// count 삽입할 암호문 갯수
				int count = Integer.parseInt(token.nextToken());
				// 시작 위치부터 count개를 삽입한다. 시작부터 1증가시키며 삽입
				for (int j = 0; j < count; j++) {
					list.add(start + j, Integer.parseInt(token.nextToken()));
				}
			}
			// 처음부터 10개 출력
			str.append("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				str.append(list.get(i) + " ");
			}
			str.append("\n");
		}
		System.out.println(str);
	}
}
