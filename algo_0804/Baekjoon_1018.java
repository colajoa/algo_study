package ssafy_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1018 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer token = null;
	static char[][] board;
	static char[][] chess;
	public static void main(String[] args) throws IOException {
		token = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		board = new char[N][M];
		chess= new char[N][M];
		char[] ch = null;
		for (int r = 0; r < N; r++) {
			ch = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				board[r][c] = ch[c];
				if((r+c)%2==0) {
					chess[r][c] = 'W';
				}
				else {
					chess[r][c] = 'B';
				}
			}
		}
		int diff = 0;
		int min = Integer.MAX_VALUE;
		for (int x = 0; x < N - 7; x++) {
			for (int y = 0; y < M - 7; y++) {
				diff = 0;
				for (int r = x; r < x+8; r++) {
					for (int c = y; c < y+8; c++) {
						if (board[r][c] != chess[r-x][c-y]) {
							diff += 1;
						} 
					}
				}
				
				min = Integer.min(min,Integer.min((64-diff),diff));
				System.out.println(min+" "+diff+" "+(64-diff));
			}
		}
		System.out.println(min);
	}
}
