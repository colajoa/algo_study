package algo_0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_17135_2 {

	static int[][] map;
	static int N, M, D;
	static int ans;
	// 궁수 행은 고정 열만 바뀜?
	static List<Integer> archer = new ArrayList<>();
	// static boolean[] visited;
	static int[] dx = { 0, -1, 0 };
	static int[] dy = { -1, 0, 1 };

	static void comb(int start, int depth) {
		if (depth == 3) {
			defense();
			return;
		}
		for (int i = 0; i < M; i++) {
			archer.add(i);
			comb(i + 1, depth + 1);
			archer.remove(archer.size()-1);
		}
	}

	static void defense() {
		int kill = 0;
		int castle = N;
		int[][] copyMap = new int[N][M];
		
		/*for(int i=0; i<N; i++) {
			copyMap[i] = Arrays.copyOf(map[i], M);
		}*/
		
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, M);
		}
		
		while (castle > 0) {
			List<int []> enemy = new ArrayList<>();

			for (int i = 0, size = archer.size(); i < size; i++) {
				int min = Integer.MAX_VALUE;
				int[] enemyP = new int[2];

				for (int c = 0; c < M; c++) {
					for (int r = castle-1; r >= 0; r--) {
						int dis = Math.abs(castle-r) + Math.abs(archer.get(i) - c);
						
						if(copyMap[r][c]==1 && dis <= D) {
							if(dis<min) {
								min = dis;
								enemyP[0] = r;
								enemyP[1] = c;
							}
							break;
						}
					}
				}
				
				if(min!=Integer.MAX_VALUE) {
					enemy.add(new int[] {enemyP[0], enemyP[1]});
				}
			}
			
			for(int i=0, size= enemy.size(); i<size; i++) {
				if(copyMap[enemy.get(i)[0]][enemy.get(i)[1]]!=0) {
					kill += 1;
					copyMap[enemy.get(i)[0]][enemy.get(i)[1]] = 0;
				}
			}
			castle -= 1;
		}
		
		if(kill > ans) ans = kill;
		//Math.max(ans, kill);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;

		token = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		D = Integer.parseInt(token.nextToken());

		map = new int[N][M];
		// 궁수 3명 각각의 x, y좌표

		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		ans = 0;
		comb(0, 0);
		System.out.println(ans);
	}
}
