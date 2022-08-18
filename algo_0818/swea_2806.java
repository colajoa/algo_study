package algo_0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2806 {
	static int count, queen[], N;

	static void NQueen(int row) {
		if (row == N) {
			count += 1;
			return;
		}

		for (int c = 0; c < N; c++) {
			boolean check = true;
			queen[row] = c;

			for (int i = 0; i < row; i++) {

				if (queen[row] == queen[i] || Math.abs(queen[row] - queen[i]) == row - i) {
					check = false;
					break;
				}
			}
			if (check) {
				NQueen(row + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			queen = new int[N];
			count = 0;
			NQueen(0);
			str.append("#"+t+" "+count+"\n");
		}
		System.out.println(str);
	}
}
