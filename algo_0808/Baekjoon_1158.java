package algo_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1158 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder str = new StringBuilder();
		str.append("<");
		token = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		
		Queue<Integer> yo = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			yo.offer(i);
		}
		while(yo.size() != 1) {
			for(int i=0; i<K-1; i++) {
				int front = yo.poll();
				yo.offer(front);
			}
			str.append(yo.poll()+", ");
		}
		str.append(yo.poll()+">");
		System.out.println(str);
	}
}
