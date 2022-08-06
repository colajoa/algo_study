package algo_0805;

import java.util.Scanner;

public class Baekjoon_2023 {
	static StringBuilder str = new StringBuilder();

	static void dfs(int N, String primeNum, int idx) {
		if (idx == N) {
			str.append(primeNum + "\n");
			return;
		}
		for (int i = 1; i < 10; i++) {
			if(prime(Integer.parseInt(primeNum+i))) dfs(N,primeNum+i,idx+1);
		}
	}

	static boolean prime(int primeNum) {
		if (primeNum == 1)
			return false;
		int sqrt = (int) Math.sqrt(primeNum);
		for (int i = 2; i < sqrt+1; i++) {
			if (primeNum % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dfs(N, "", 0);
		System.out.println(str);
	}
}
