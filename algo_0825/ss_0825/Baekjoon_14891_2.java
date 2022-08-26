package ss_0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 비트마스킹...
public class Baekjoon_14891_2 {
	static void rotate(int pos, int rot) {
		int[] clockwise = new int[4];
		clockwise[pos] = rot;
		
		for(int i=pos; i>0; i--) {
			if(isSame(i-1, i)) break;
			clockwise[i-1] = -clockwise[i];
		}
		
		for(int i=pos; i<3; i++) {
			if(isSame(i, i+1)) break;
			clockwise[i+1] = -clockwise[i]; 
		}
		
		turn(clockwise);
	}
	
	static void turn(int[] clockwise) {
		for(int i=0; i<4; i++) {
			if(clockwise[i] == 1) {
				turnClockwise(i);
			}
			else if(clockwise[i] == -1) {
				turnConuterClockwise(i);
			}
		}
	}
	static void turnClockwise(int i) {
		if((wheel[i]&1)>0) {
			wheel[i] >>>= 1;
			wheel[i] |= (1<<7);
		}
		else wheel[i] >>>=1;
	}
	
	static void turnConuterClockwise(int i) {
		if((wheel[i]&(1<<7))>0) {
			wheel[i] <<= 1;
			wheel[i] |= 1;
		}
		else wheel[i] <<=1;
	}
	
	static boolean isSame(int l, int r) {
		int left = (wheel[l] & (1 << 5)) > 0 ? 1 : 0; 
		int right = (wheel[r] & (1 << 1)) > 0 ? 1 : 0;
		
		return left == right;
	}
	static int[] wheel = new int[4];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		for(int i=0; i<4; i++) {
			wheel[i] = Integer.parseInt(br.readLine(), 2);
		}
		
		
		int K = Integer.parseInt(br.readLine());
		for(int k=0; k<K; k++) {
			token = new StringTokenizer(br.readLine()," ");
			int pos = Integer.parseInt(token.nextToken())-1;
			int rot = Integer.parseInt(token.nextToken());
			rotate(pos, rot);
		}
		int ans = 0;
		for(int i=0; i<4; i++) {
			ans += (wheel[i] & (1<<7)) == 0 ? 0 : Math.pow(2, i);
		}
		System.out.println(ans);
	}
}
