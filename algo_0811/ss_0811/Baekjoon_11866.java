package ss_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_11866 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder str = new StringBuilder();
		str.append("<");
		token = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		// 원탁 테이블
		Queue<Integer> yo = new ArrayDeque<>();
		// 1~N번 사람 테이블에 착석 
		for(int i=1; i<=N; i++) {
			yo.offer(i);
		}
		// 테이블에 남은 인원 한 명이 될때까지 반복
		while(yo.size() != 1) {
			//K번 반복을 통해 제거자 선정
			for(int i=0; i<K-1; i++) {
				int front = yo.poll();
				yo.offer(front);
			}
			//선정
			str.append(yo.poll()+", ");
		}
		//마지막 남은 1명 제거
		str.append(yo.poll()+">");
		System.out.println(str);
	}
}
