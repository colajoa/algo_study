package ss_1103;
import java.io.*;
import java.util.*;

public class Baekjoon_18405 {
	static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int S, X, Y;
    static int N, K;
    static int[][] visited;
    static PriorityQueue<Virus> pq;

    static class Virus {
        int r, c, size;

        public Virus(int r, int c, int size) {
            this.r = r;
            this.c = c;
            this.size = size;
        }

    }

    static void spread() {
        PriorityQueue<Virus> tmp = new PriorityQueue<>((o1, o2) -> o1.size - o2.size);
        while (S-- > 0) {
            int queueSize = pq.size();
            // System.out.println(queueSize);
            while (queueSize-- > 0) {
                Virus virus = pq.poll();
                // System.out.println(virus.r + " " + virus.c + " " + virus.size);
                for (int d = 0; d < 4; d++) {
                    int nr = virus.r + dr[d];
                    int nc = virus.c + dc[d];
                    int size = virus.size;
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N && visited[nr][nc] == 0) {
                        visited[nr][nc] = size;
                        tmp.add(new Virus(nr, nc, size));
                    }
                }
                // System.out.println(queueSize);
            }
            pq.addAll(tmp);
            tmp.clear();
            
            //print();
            // for (int n = 0; n < N; n++) {
            // System.out.println(Arrays.toString(visited[n]));
            // }
            // System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        visited = new int[N][N];
        pq = new PriorityQueue<>((o1, o2) -> o1.size - o2.size);

        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int size = Integer.parseInt(token.nextToken());
                if (size > 0) {
                    pq.offer(new Virus(r, c, size));
                    visited[r][c] = size;
                    // System.out.println(size);
                }
                // System.out.println(pq.peek().size);
            }
        }
        // while (!pq.isEmpty()) {
        // Virus v = pq.poll();
        // System.out.println(v.r + " " + v.c + " " + v.size);
        // }
        token = new StringTokenizer(br.readLine());
        S = Integer.parseInt(token.nextToken());
        X = Integer.parseInt(token.nextToken()) - 1;
        Y = Integer.parseInt(token.nextToken()) - 1;


        spread();

        //print();

        System.out.println(visited[X][Y]);
    }

	private static void print() {
		for (int n = 0; n < N; n++) {
        	System.out.println(Arrays.toString(visited[n]));
        }
        System.out.println();
		
	}
}