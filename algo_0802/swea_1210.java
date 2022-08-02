	package algo_0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1210 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int[][] game = new int[100][100];
			int [] dx = {0,0,-1};
			int [] dy = {-1,1,0};
			int x=0;
			int y=0;
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					game[i][j] = Integer.parseInt(token.nextToken());
					if(game[i][j]==2) {
						x = i;
						y = j;
					}
				}
			}
			
			
			while(x!=0) {
				for(int n=0; n<dx.length; n++) {
					int nx = x+dx[n];
					int ny = y+dy[n];
					for(int l=0; l<game.length; l++) {
						if(nx >= 0 && nx < game.length && ny >= 0 && ny<game.length) {
							if(game[nx][ny]==1) {
								game[nx][ny] = 1;
								x = nx;
								y = ny;
							}
						}else continue;
					}
				}
			}
			System.out.printf("#%d %d\n", t, y);
		}
	}
}
