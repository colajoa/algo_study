package swea;
import java.io.*;
import java.util.*;
public class swea_2112_2 {
	static int D, W, K;
	static int[][] film, copy;
	static int ans;
	static boolean isPass() {
		
		for(int c=0; c<W; c++) {
			boolean flag = false;
			int tmp = film[0][c];
			int cnt = 1;
			for(int r=1; r<D; r++) {
				
				if(tmp==film[r][c]) {
					cnt += 1;
				}
				else {
					cnt = 1;
					tmp = film[r][c];
				}
				
				if(cnt == K) {
					flag = true;
					break;
				}
			}
			if(!flag)
				return false;
		}
		return true;
	}
	
	static void change(int depth, int cnt) {
		if(isPass()) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if(cnt >= ans) return;
		
		for(int i= depth; i<D; i++) {
			
			Arrays.fill(film[i], 0);
			change(i+1, cnt+1);
			
			Arrays.fill(film[i], 1);
			change(i+1, cnt+1);
			
			film[i] = Arrays.copyOf(copy[i], W);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			token = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(token.nextToken());
			W = Integer.parseInt(token.nextToken());
			K = Integer.parseInt(token.nextToken());
			ans = Integer.MAX_VALUE;
			film = new int[D][W];
			copy = new int[D][W];
			for(int r=0; r<D; r++) {
				token = new StringTokenizer(br.readLine());

				for(int c=0; c<W; c++) {
					film[r][c] = Integer.parseInt(token.nextToken());
					copy[r][c] = film[r][c];
				}
			}
			
			change(0,0);
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
