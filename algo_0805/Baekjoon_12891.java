package algo_0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_12891 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		int[] dnaCnt = new int[4];
		token = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(token.nextToken());
		int P = Integer.parseInt(token.nextToken());

		char[] password;
		password =br.readLine().toCharArray();
		token = new StringTokenizer(br.readLine(), " ");
		
		int sum=0;
		int a = Integer.parseInt(token.nextToken());
		int c = Integer.parseInt(token.nextToken());
		int g = Integer.parseInt(token.nextToken());
		int t = Integer.parseInt(token.nextToken());
		
		int ca = 0;
		int cc = 0;
		int cg = 0;
		int ct = 0;
		int ans = 0;
		
		for (int i =0; i < P; i++) {
			if(password[i]=='A') ca += 1;
			else if(password[i]=='C') cc += 1;
			else if(password[i]=='G') cg += 1;
			else if(password[i]=='T') ct += 1;
		}
		if(ca>=a && cc>=c&& cg>=g && ct>=t) ans+=1;
		for (int i = 0; i < S - P; i++) {
			
			if(password[i] == password[i+P]) {
				if(ca>=a && cc>=c&& cg>=g && ct>=t) ans+=1;
				continue;
			}
			else {
				if(password[i+P] == 'A') {
					ca += 1;
					if(password[i] == 'C') cc-=1;
					else if(password[i] == 'G') cg-=1;
					else if(password[i] == 'T') ct-=1;
				}
				else if(password[i+P] == 'C') {
					cc+=1;
					if(password[i] == 'A') ca-=1;
					else if(password[i] == 'G') cg-=1;
					else if(password[i] == 'T') ct-=1;
				}
				else if(password[i+P] == 'G') {
					cg+=1;
					if(password[i] == 'A') ca-=1;
					else if(password[i] == 'C') cc-=1;
					else if(password[i] == 'T') ct-=1;
				}
				else if(password[i+P] == 'T') {
					ct+=1;
					if(password[i] == 'A') ca-=1;
					else if(password[i] == 'C') cc-=1;
					else if(password[i] == 'G') cg-=1;
				}
			}
			if(ca>=a && cc>=c&& cg>=g && ct>=t) ans+=1;
		}
		System.out.println(ans);
	}
}
