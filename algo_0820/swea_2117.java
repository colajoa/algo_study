package algo_class_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2117 {

    static int[][] map;
    static int N, M;
    static int ans;

    static void search(int k) {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                ans = Math.max(ans, getHouse(i, j, k));
            }
        }

    }

    static int getHouse(int r, int c, int k) {
        int house = 0;
        for (int i = r - k + 1; i <= r + k - 1; i++) {
            for (int j = c - k + 1; j <= c + k - 1; j++) {
                int dis = Math.abs(r - i) + Math.abs(c - j);
                if (i < 0 || i >= N || j < 0 || j >= N)
                    continue;
                if (dis <= k - 1 && map[i][j] == 1) {
                    house += 1;
                }
            }
        }

        int cost = house * M - ((k * k) + (k - 1) * (k - 1));

        if (cost >= 0) {
            return house;
        }

        else {
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            token = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            ans = 0;
            for (int k = 1; k <= N+1; k++) {
                search(k);
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}

