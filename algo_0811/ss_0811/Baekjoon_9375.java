package ss_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baekjoon_9375 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder str = new StringBuilder();
		//테스트 케이스
		int T = Integer.parseInt(br.readLine());
		
		//옷 종류를 저장할 해시맵
		HashMap<String, Integer> clothes = new HashMap<>();
		for(int t=0; t<T; t++) {
			//옷 갯수
			int N = Integer.parseInt(br.readLine());
			//케이스마다 맵을 새로 생성
			clothes = new HashMap<>();
			for(int input=0; input<N; input++) {
				//옷 입력
				token = new StringTokenizer(br.readLine()," ");
				//옷 날리기
				token.nextToken();
				//옷 종류 저장
				String cate = token.nextToken();
				//옷 종류가 없다면 새로운 key value 저장
				if(!clothes.containsKey(cate)) clothes.put(cate, 1);
				// 있다면 key의 value 1증가
				else clothes.put(cate,clothes.get(cate)+1);
			}
			//조합 저장을 위한 comb
			int comb = 1;
			// foreach로 맵의 value 반복
			for(int cnt: clothes.values()) {
				// values 값에 + 1을 더해 comb에 곱하기.
				// 옷 종류 + 1 (아무것도 착용하지 않는 경우)
				comb *= cnt+1;
			}
			// 조합을 str에 저장 comb - 1 (모든 옷을 탈의 한 경우를 빼준다.)
			str.append((comb-1)+"\n");
		}
		System.out.println(str);
	}
}
