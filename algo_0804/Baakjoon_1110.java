package ssafy_study;

import java.util.Scanner;

public class Baakjoon_1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int one = N%10;
		int ten = N/10;
		int plus = 0;
		int newOne=one*10;
		newOne += (one+ten)%10;
		int cnt = 1;
		while(N != newOne){
			one = newOne%10;
			ten = newOne/10;
			plus = (one + ten)%10;
			
			newOne = one*10 + plus;
			cnt++;
		}
		System.out.println(cnt);
	}
}
