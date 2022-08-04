package ssafy_study;

import java.util.Scanner;

public class Baekjoon_2941 {
	public static void main(String[] args) {
		String[] croAlpha = {"c=","c-", "dz=","d-","lj","nj","s=","z="};
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		for(String a : croAlpha) {
				str = str.replaceAll(a, "0");
		}
		System.out.println(str.length());
	}
}
