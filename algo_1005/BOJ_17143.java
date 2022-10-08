package algo_1005;
/* 낚시왕 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17143 {

    private static class Shark{
        public int x, y, s, d, z;

        public Shark(int z){
            this.z = z;
        }
        public Shark(int x, int y, int s, int d, int z){
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    private static int[][] map;
    private static int[] dx = {-1, 1, 0, 0};    // 위, 아래, 오른쪽, 왼쪽
    private static int[] dy = {0, 0, 1, -1};
    private static List<Shark> sharks = new ArrayList<>();
    private static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());   // 상어의 수

        map = new int[r + 1][c + 1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());       // 속력
            int d = Integer.parseInt(st.nextToken()) - 1;   // 이동 방향 (1: 위, 2: 아래, 3: 오른쪽, 4: 왼쪽)
            int z = Integer.parseInt(st.nextToken());       // 크기

            sharks.add(new Shark(x,y,s,d,z));
            map[x][y] = z;
        }

//        print();
        int total = 0;
        for(int i = 1; i <= c; i++){
            for(int j = 1; j <= r; j++){
                if(map[j][i] != 0) {
                    total += getShark(j, i);
                    break;
                }
            }
            move();
            compare();
//            print();
        }

        System.out.println(total);
    }

    private static void print(){
        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void move(){
        for(int i = 0; i < sharks.size(); i++){
            Shark shark = sharks.get(i);

            int x = shark.x;
            int y = shark.y;
            int dir = shark.d;
            int speed = shark.s;

            map[x][y] = 0;

            int nx = x;
            int ny = y;
            if(dir == 0 || dir == 1) {
                speed %= (r - 1) * 2;
            }
            else if(dir == 2 || dir == 3){
                speed %= (c - 1) * 2;
            }

            for(int j = 0; j < speed; j++){
                nx += dx[dir];
                ny += dy[dir];

                if(nx < 1){
                    nx -= dx[dir] * 2;
                    dir = 1;
                }
                if(nx > r){
                    nx -= dx[dir] * 2;
                    dir = 0;
                }
                if(ny < 1){
                    ny -= dy[dir] * 2;
                    dir = 2;
                }
                if(ny > c){
                    ny -= dy[dir] * 2;
                    dir = 3;
                }
            }

            sharks.set(i, new Shark(nx, ny, speed, dir, shark.z));
        }
    }

    private static void compare(){
        for(int i = 0; i < sharks.size(); i++){
            Shark s1 = sharks.get(i);
            int sx = s1.x;
            int sy = s1.y;
            int ss = s1.z;  //size

            if(map[sx][sy] == 0)    map[sx][sy] = ss;
            else{
                if(map[sx][sy] < ss)    {
                    for(int j = i - 1; j >= 0; j--){
                        if(sharks.get(j).z == map[sx][sy])
                            sharks.remove(j);
                    }
                    map[sx][sy] = ss;
                }else{
                    sharks.remove(i);
                }
                i--;
            }
        }
    }

    private static int getShark(int x, int y){
        for(int i = 0; i < sharks.size(); i++){
            Shark shark = sharks.get(i);
            int sx = shark.x;
            int sy = shark.y;
            int size = shark.z;

            if(sx == x && sy == y){
                map[sx][sy] = 0;
                sharks.remove(i);
                return size;
            }
        }
        return 0;
    }
}