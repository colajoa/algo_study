package ss_0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 비트마스킹...
public class Baekjoon_14891_2 {
	static int[] wheel = new int[4];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		for(int i=0; i<4; i++) {
			wheel[i] = Integer.parseInt(br.readLine(), 2);
		}
		
		System.out.println(Arrays.toString(wheel));
		
		int K = Integer.parseInt(br.readLine());
		for(int k=0; k<K; k++) {
			token = new StringTokenizer(br.readLine()," ");
		}
	}
}
