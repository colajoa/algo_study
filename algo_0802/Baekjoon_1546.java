package algo_0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon_1546 {
	public static void main(String[] args) throws IOException {
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());*/
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] score = new double[N];
		for(int i=0; i<N; i++) {
			score[i] = sc.nextDouble();
		}
		
		Arrays.sort(score);
		double max = score[N-1];
		
		for(int i=0; i<N; i++) {
			score[i] = score[i]/max*100;
		}
		double sum = 0;
		for(int i=0; i<N; i++) {
			sum += score[i];
		}
		System.out.printf("%f", (double)(sum/N));
	}
}
