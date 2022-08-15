package algo_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_1158_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder str = new StringBuilder();
		str.append("<");
		token = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		
		List<Integer> yo = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			yo.add(i);
		}
		int idx = 0;
		while(yo.size()!=1) {
			idx = (idx + K - 1)%yo.size();
			str.append(yo.get(idx)+", ");
			yo.remove(idx);
		}
		str.append(yo.get(0)+">");
		System.out.println(str);
	}
}
