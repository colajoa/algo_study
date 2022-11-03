package ss_1103;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_13549 {
	static int N, K, ans = Integer.MAX_VALUE;
    static int[] move = {0, -1, 1 };

    static class Point {
        int position, time;

        public Point(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }

    static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];

        visited[N] = true;

        q.add(new Point(N, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();
            //System.out.println(now.position + " " + now.time);
            if (now.time >= ans)
                continue;
            if (now.position == K) {
                ans = Math.min(now.time, ans);
            }
            for (int i = 0; i < 3; i++) {
                int position = now.position + move[i];
                int time = now.time + 1;
                if (i == 0) {
                    position = now.position * 2;
                    time = now.time;
                }
                //System.out.println(position + " " + time);
                if (position >= 0 && position <= 100000 && !visited[position]) {
                    visited[position] = true;
                    q.add(new Point(position, time));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        bfs();

        System.out.println(ans);
    }
}
