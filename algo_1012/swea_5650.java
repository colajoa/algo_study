package algo_1011;

import java.io.*;
import java.util.*;

public class swea_5650 {
    static int N, ans;
    static int[][] map;
    static List<Point>[] hole;
    static List<Point> blank;

    // 상우하좌
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void move(Point p, int sr, int sc, int dir, boolean flag) {
        int cnt = 0;
        while (true) {

            //System.out.println(p.r + " " + p.c + " " + dir);
            if ((flag && p.r == sr && p.c == sc) || (map[p.r][p.c] == -1))
                break;
            flag = true;
            p.r += dr[dir];
            p.c += dc[dir];

            if (p.r < 0 || p.r >= N || p.c < 0 || p.c >= N) {
                p.r -= dr[dir];
                p.c -= dc[dir];
                dir = (dir + 2) % 4;
                cnt += 1;
                //System.out.println(cnt);
            }

            if (map[p.r][p.c] >= 1 && map[p.r][p.c] <= 5) {
                if (map[p.r][p.c] == 1) {
                    if (dir == 0) {
                        dir = 2;
                    }

                    else if (dir == 1) {
                        dir = 3;
                    }

                    else if (dir == 2) {
                        dir = 1;
                    }

                    else if (dir == 3) {
                        dir = 0;
                    }
                } else if (map[p.r][p.c] == 2) {
                    if (dir == 0) {
                        dir = 1;
                    }

                    else if (dir == 1) {
                        dir = 3;
                    }

                    else if (dir == 2) {
                        dir = 0;
                    }

                    else if (dir == 3) {
                        dir = 2;
                    }
                } else if (map[p.r][p.c] == 3) {
                    if (dir == 0) {
                        dir = 3;
                    }

                    else if (dir == 1) {
                        dir = 2;
                    }

                    else if (dir == 2) {
                        dir = 0;
                    }

                    else if (dir == 3) {
                        dir = 1;
                    }
                } else if (map[p.r][p.c] == 4) {
                    if (dir == 0) {
                        dir = 2;
                    }

                    else if (dir == 1) {
                        dir = 0;
                    }

                    else if (dir == 2) {
                        dir = 3;
                    }

                    else if (dir == 3) {
                        dir = 1;
                    }
                } else if (map[p.r][p.c] == 5) {
                    if (dir == 0) {
                        dir = 2;
                    }

                    else if (dir == 1) {
                        dir = 3;
                    }

                    else if (dir == 2) {
                        dir = 0;
                    }

                    else if (dir == 3) {
                        dir = 1;
                    }
                }
                cnt += 1;
                continue;
            }

            if (map[p.r][p.c] >= 6) {

                int i = map[p.r][p.c];
                if (hole[i].get(0).r == p.r && hole[i].get(0).c == p.c) {
                    p.r = hole[i].get(1).r;
                    p.c = hole[i].get(1).c;
                } else if (hole[i].get(1).r == p.r && hole[i].get(1).c == p.c) {
                    p.r = hole[i].get(0).r;
                    p.c = hole[i].get(0).c;
                }
            }

        }
        ans = Math.max(cnt, ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token = null;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            hole = new ArrayList[11];
            blank = new ArrayList<>();
            ans = Integer.MIN_VALUE;
            for (int i = 0; i < 11; i++) {
                hole[i] = new ArrayList<>();
            }

            for (int r = 0; r < N; r++) {
                token = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(token.nextToken());
                    if (map[r][c] == 0) {
                        blank.add(new Point(r, c));
                    }
                    if (map[r][c] >= 6) {
                        hole[map[r][c]].add(new Point(r, c));
                    }
                }
            }
            for (Point p : blank) {
                for (int dir = 0; dir < 4; dir++) {
                    Point point = new Point(p.r, p.c);
                    move(point, p.r, p.c, dir, false);
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
