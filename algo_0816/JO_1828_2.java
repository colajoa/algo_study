package algo_0816;

import java.util.Arrays;
import java.util.Scanner;

public class JO_1828_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] chem = new int[N][2];
		int cnt = 1;
		for (int i = 0; i < N; i++) {
				chem[i] = new int[] { sc.nextInt(), sc.nextInt() };
		}
		
		Arrays.sort(chem, (o1, o2)-> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
		
		int max = chem[0][1];
		
		for(int i=1, size = chem.length; i<size; i++) {
			if(max <= chem[i][0] ) {
				max = chem[i][0];
				cnt += 1;
			}
		}

		System.out.println(cnt);
	}
}
