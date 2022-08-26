package ss_0825;

import java.util.*;
import java.io.*;
// 꽝 다음기회에...
public class Baekjoon_14499 {
	// 동 서 북 남
	
	static int[][] map;
	static int[] dice;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M, x, y, K;
	static StringBuilder sb = new StringBuilder();
	
	static boolean go(int i) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if(nx >= 0 && nx < N && ny >= 0 && ny < M)
			return true;
		return false;
	}
	static void shootingDice(int i) {
		
		if(go(i)) {
		
		int temp;
		switch(i) {
		
		case 0 :
			temp = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[3];
			dice[3] = temp;
			break;
		
		case 1 :
			temp = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
			break;
			
		case 2: 
			temp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[3];
			dice[3] = temp;
			break;
			
		case 3:
			temp = dice[3];
			dice[3] = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[0];
			dice[0] = temp;
			break;
		}
		
		copy(i);
		x += dx[i];
		y += dy[i];
		print();
		}
		
	}
	static void copy(int i) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if(map[nx][ny] == 0 ) {
			map[nx][ny] = dice[3];
		}
		else {
			dice[3] = map[nx][ny];
			map[nx][ny] = 0;
		}
	}
	static void print() {
		sb.append(dice[1]).append("\n");
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		x = Integer.parseInt(token.nextToken());
		y = Integer.parseInt(token.nextToken());
		K = Integer.parseInt(token.nextToken());

		map = new int[N][M];
		dice = new int[6];
		for (int r = 0; r < N; r++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(token.nextToken());
			}
		}

		token = new StringTokenizer(br.readLine(), " ");

		while (token.hasMoreTokens()) {
			int cmd = Integer.parseInt(token.nextToken()) - 1;
			shootingDice(cmd);
			//System.out.println(Arrays.toString(dice));
		}
		//System.out.println();
		System.out.println(sb);
	}
}
