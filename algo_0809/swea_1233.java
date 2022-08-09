package algo_0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1233 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder str = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 1;
			for (int i = 1; i <= N; i++) {
				token = new StringTokenizer(br.readLine(), " ");
				//첫 노드 번호 날리기
				token.nextToken();
				char data = token.nextToken().charAt(0);
				
				if((data >= '0' && data <= '9' && token.hasMoreTokens()) || (!(data >= '0'&& data <='9') && !token.hasMoreTokens())) {
					ans = 0;
					
					//처음에 N번 만큼 입력 받은 것을 날려줘야하기 때문에 반복문으로 라인을 읽어서 날려준다.
					for(int end = i+1; end<=N; end++) {
						br.readLine();
					}
					//탈출
					break;
				}
			}
			//정답
			str.append("#"+t+" "+ans+"\n");
		}
		System.out.println(str);
	}
}
