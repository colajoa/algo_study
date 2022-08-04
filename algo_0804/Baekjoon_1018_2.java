package ssafy_study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1018_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer token = null;
	static char[][] board;

	public static void main(String[] args) throws IOException {
		token = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		board = new char[N][M];
		char[] ch = null;
		for (int r = 0; r < N; r++) {
			ch = br.readLine().toCharArray();
			for (int c = 0; c < M; c++) {
				board[r][c] = ch[c];
			}
		}
		int startW = 0;
		int startB = 0;
		int min = Integer.MAX_VALUE;
		for (int x = 0; x < N - 7; x++) {
			for (int y = 0; y < M - 7; y++) {
				startW = 0;
				startB = 0;
				for (int r = x; r < x+8; r++) {
					for (int c = y; c < y+8; c++) {
						if ((r + c) % 2 == 0) {
							if (board[r][c] == 'W') 
								startW += 1;
							
							else 
								startB += 1;
							
						} else {
							if (board[r][c] == 'W') 
								startB += 1;								
							
							else 
								startW += 1;
							
						}
					}
				}
				min = Integer.min(min,Integer.min(startB, startW));
			}
		}
		System.out.println(/*startB+" "+startW+" "+*/min);
	}
}
