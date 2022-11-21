package ss_1121;

import java.io.*;
import java.util.*;

public class Baekjoon_1941 {
    static char[][] ban = new char[5][5];
    static boolean[] visited;
    static int[] selected = new int[7];
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int ans = 0;

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void comb(int depth, int start, int somCnt) {
        if (depth - somCnt > 3)
            return;

        if (depth == 7) {
            bfs(selected[0] / 5, selected[0] % 5);
            return;
        }

        for (int i = start; i < 25; i++) {
            int r = i / 5, c = i % 5;

            selected[depth] = i;

            comb(depth + 1, i + 1, ban[r][c] == 'S' ? somCnt + 1 : somCnt);
        }
    }

    static void bfs(int r, int c) {
        Queue<Point> q = new ArrayDeque<>();
        visited = new boolean[7];
        int cnt = 1;
        q.add(new Point(r, c));
        visited[0] = true;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
                    int next = 5 * nr + nc;
                    for (int i = 0; i < 7; i++) {
                        if (!visited[i] && selected[i] == next) {
                            visited[i] = true;
                            cnt += 1;
                            q.add(new Point(nr, nc));
                        }
                    }
                }
            }
        }
        if (cnt == 7)
            ans += 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < 5; r++) {
            String str = br.readLine();
            for (int c = 0; c < 5; c++) {
                ban[r][c] = str.charAt(c);
            }
        }

        comb(0, 0, 0);
        System.out.println(ans);
    }

}
