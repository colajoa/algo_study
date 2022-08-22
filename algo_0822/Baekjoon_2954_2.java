package algo_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2954_2 {
	// 모음 확인을 위한 배열
			static char[] mo = new char[] {'a','e','i','o','u'};
			public static void main(String[] args) throws IOException{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				// 알파벳 저장 및 결과를 출력하기 위한 StringBuilder sb;
				StringBuilder sb = new StringBuilder();
				// 암호화된 단어 입력
				String word = br.readLine();
				// 단어의 각 위치 탐색을 위한 변수
				int pos = 0;
				// 단어 길이
				int len = word.length();
				// 단어 길이보다 탐색 위치가 작으면 반복
				while(pos < len) {
					// 탐색 위치의 모음 확인을 위한 반복문 
					sb.append(word.charAt(pos));
					//다음 위치 탐색을 위해  + 1
					pos += 1;
					for(int i=0; i<5; i++) {
						// 위치의 알파벳이 모음이면
						if(word.charAt(pos-1) == mo[i]) {
							// StringBuilder sb에 현재 위치의 알파벳 저장.

							// 다음 탐색 위치를 위한 pos 증가.
							// 2칸을 넘어야한다.
							pos += 2;
							// 탈출
							break;
						}
					}
					// apa len = 3, pos = 3 같이 탐색위치가 단어길이보다 크거나 같으면 커지면 반복문 탈출 
					//if(pos >= len) break;
					
				}
				// 결과 출력
				System.out.println(sb);
			}
}
