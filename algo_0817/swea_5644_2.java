package algo_0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class swea_5644_2 {
 
    static int[] dx = { 0, -1, 0, 1, 0 };
    static int[] dy = { 0, 0, 1, 0, -1 };
    static int[] loA;
    static int[] loB;
    static int[] pathA;
    static int[] pathB;
    static int[][] BC;
    static int M, A, ans;
 
    static void move() {
 
        // System.out.println(loA[0]+" "+loA[1]+" "+loB[0]+" "+loB[1]);
 
        // A, B 위치 이동
        for (int i = 0; i < M + 1; i++) {
 
            loA[0] += dx[pathA[i]];
            loA[1] += dy[pathA[i]];
            loB[0] += dx[pathB[i]];
            loB[1] += dy[pathB[i]];
            // 충전기 탐색
            search();
        }
 
    }
 
    static void search() {
 
        int max = 0;
        for (int a = 0; a < A; a++) {
 
            for (int b = 0; b < A; b++) {
                int sum = 0;
                int AP = 0;
                int BP = 0;
                // 이부분이 Distance() ≤ BC[i][2] = true
 
                if (Math.abs(loA[0] - BC[a][1]) + Math.abs(loA[1] - BC[a][0]) <= BC[a][2]) {
                    AP = BC[a][3];
                }
                if (Math.abs(loB[0] - BC[b][1]) + Math.abs(loB[1] - BC[b][0]) <= BC[b][2]) {
                    BP = BC[b][3];
                }
 
                if (a != b) {
                    sum = AP + BP;
                } else
                    sum = Math.max(AP, BP);
                if (sum > max) {
                    max = sum;
                }
            }
        }
 
        ans += max;
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();
        StringTokenizer token = null;
        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            token = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(token.nextToken());
            A = Integer.parseInt(token.nextToken());
            pathA = new int[M + 1];
            pathB = new int[M + 1];
 
            // A,B 시작 좌표
            loA = new int[] { 1, 1 };
            loB = new int[] { 10, 10 };
            // 충전기 좌표, 충전거리, 충전량
            BC = new int[A][4];
 
            token = new StringTokenizer(br.readLine(), " ");
 
            for (int i = 1; i < M + 1; i++) {
                pathA[i] = Integer.parseInt(token.nextToken());
            }
 
            token = new StringTokenizer(br.readLine(), " ");
 
            for (int i = 1; i < M + 1; i++) {
                pathB[i] = Integer.parseInt(token.nextToken());
            }
 
            for (int i = 0; i < A; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                // 충전기 좌표, 충전 거리, 충전량
                BC[i] = new int[] { Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),
                        Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()) };
            }
 
            // System.out.println(Arrays.toString(pathA));
            // System.out.println(Arrays.toString(pathB));
            // 정답
            ans = 0;
            move();
            str.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(str);
    }
}