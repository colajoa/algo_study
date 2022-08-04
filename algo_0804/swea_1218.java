package algo_0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1218 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer token = null;
		String str;
		

		for(int t=1; t<=10; t++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			str = br.readLine();
			
			int answer;
			char b;
			for(int i=0; i<N; i++) {
				b = str.charAt(i);
				
				if(b==')' && sb.charAt(sb.length()-1)=='(') {
					sb.deleteCharAt(sb.indexOf("(",sb.length()-1));
					
				}
				else if(b=='>'&& sb.charAt(sb.length()-1)=='<') {
					sb.deleteCharAt(sb.indexOf("<",sb.length()-1));
					
				}
				else if(b==']'&& sb.charAt(sb.length()-1)=='[') {
					sb.deleteCharAt(sb.indexOf("[",sb.length()-1));
					
				}
				else if(b=='}'&& sb.charAt(sb.length()-1)=='{') {
					sb.deleteCharAt(sb.indexOf("{",sb.length()-1));
					
				}
				else {
					sb.append(b);
				}
			}
			if (sb.length() == 0) answer = 1;
			else answer = 0;
			System.out.println(sb);
			System.out.println(answer);
		}
	}
}
