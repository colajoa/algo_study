package swea;
import java.io.*;
import java.util.*;
public class swea_1204 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int o = Integer.parseInt(br.readLine());
			int[] nums = new int[101];
			token = new StringTokenizer(br.readLine());
			
			for(int i=0; i<1000; i++) {
				int num = Integer.parseInt(token.nextToken());
				nums[num] += 1;
			}
			
			int max = Integer.MIN_VALUE;
			int idx = 0;
			for(int i=1; i<=100; i++) {
				if(max <= nums[i]) {
					max = nums[i];
					idx = i;
				}
			}
			sb.append("#").append(o).append(" ").append(idx).append("\n");
		}
		System.out.println(sb);
	}
}
