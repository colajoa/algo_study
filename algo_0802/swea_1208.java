package algo_0802;

import java.util.Arrays;
import java.util.Scanner;

public class swea_1208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc<=10 ; tc++) {
			int dump = sc.nextInt();
			int po[] = new int[100];
			for(int i=0; i<100; i++) {
				po[i] = sc.nextInt();
			}
			while(true) {
				Arrays.sort(po);
				po[99] -= 1;
				po[0] += 1;
				dump -= 1;
				if(dump==0 || (po[99]-po[0]) <= 1) break;
				
			}
			System.out.printf("#%d %d\n",tc, (po[99]-po[0]));
		}
	}
}
