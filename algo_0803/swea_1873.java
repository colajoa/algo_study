package algo_0803;

import java.util.Arrays;
import java.util.Scanner;

public class swea_1873 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		  int[] dx = {-1,1,0,0}; 
		  int[] dy = {0,0,-1,1};
		 
		for (int t = 1; t <= T; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			sc.nextLine();
			char[][] map = new char[H][W];
			char[] line = null;
			int tank = 0;
			int x = 0;
			int y = 0;
			for (int i = 0; i < H; i++) {
				line = sc.nextLine().toCharArray();
				for (int j = 0; j < W; j++) {
					map[i][j] = line[j];
					if (line[j] == '<' || line[j] == '>' || line[j] == '^' || line[j] == 'v') {
						x = i;
						y = j;
						if(line[j] == '^') {
							tank = 0;
							continue;
						}
						else if(line[j] == 'v') {
							tank = 1;
							continue;
						}
						else if(line[j] == '<') {
							tank = 2;
							continue;
						}
						else if(line[j] == '>') {
							tank = 3;
							continue;
						}
					}
				}
			}

			int N = sc.nextInt();
			sc.nextLine();

			char[] cmd = sc.nextLine().toCharArray();
			int nx = 0;
			int ny = 0;
			for (int i = 0; i < N; i++) {
				switch (cmd[i]) {
				case 'U':
					map[x][y] = '^';
					nx = x - 1;
					tank = 0;
					if (nx >= 0 && nx < H && y >= 0 && y < W) {
						if (map[nx][y] == '.') {
							map[x][y] = '.';
							x = nx;
							map[x][y] = '^';
						}
					}
					break;
				case 'D':
					map[x][y] = 'v';
					nx = x + 1;
					tank = 1;
					if (nx >= 0 && nx < H && y >= 0 && y < W) {
						if (map[nx][y] == '.') {
							map[x][y] = '.';
							x = nx;
							map[x][y] = 'v';
						}
					}
					break;
				case 'L':
					map[x][y] = '<';
					ny = y - 1;
					tank = 2;
					if (x >= 0 && x < H && ny >= 0 && ny < W) {
						if (map[x][ny] == '.') {
							map[x][y] = '.';
							y = ny;
							map[x][y] = '<';
						}
					}
					break;
				case 'R':
					map[x][y] = '>';
					ny = y + 1;
					tank = 3;
					if (x >= 0 && x < H && ny >= 0 && ny < W) {
						if (map[x][ny] == '.') {
							map[x][y] = '.';
							y = ny;
							map[x][y] = '>';
						}
					}
					break;
				case 'S':
					nx = x + dx[tank];
					ny = y + dy[tank];
						while (true) {
							if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == '#') {
								break;
							}
							if (map[nx][ny] == '*') {
								map[nx][ny] = '.';
								break;
							}
							nx += dx[tank];
							ny += dy[tank];
						}
						break;
					}
					
					
					System.out.println((i+1)+" "+cmd[i]);
					for(int m=0; m<H; m++) {
						for(int j=0; j<W; j++) {
							System.out.print(map[m][j]);
						}
						System.out.println();
					}
				}				
				
			
			/*System.out.print("#"+t+" ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}*/
		}
	}
}