package algo_0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_11729 {
	public static StringBuilder str = new StringBuilder();
	static void hanoi(int N, int from, int to, int r) {
		if(N==1) {
			str.append(from + " "+ to+"\n");
		}
		else {
			hanoi(N-1, from, r, to);
			str.append(from + " "+ to+"\n");
			hanoi(N-1, r, to ,from);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println((int)Math.pow(2, N)-1);
		hanoi(N, 1,3,2);
		System.out.println(str);
	}
}
