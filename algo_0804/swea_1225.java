package algo_0804;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class swea_1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new ArrayDeque<>();

		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			for (int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}
			
			int cnt = 5;
			int p = 0;
			while(!q.contains(0)) {
				p = q.poll();
				cnt = (cnt%5)+1;
				if(p-cnt>0) {		
					q.offer(p-cnt);
				}
				else {
					q.offer(0);
					break;
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0; i<8; i++) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}
	}
}
