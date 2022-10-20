package ss_1020;
import java.io.*;
import java.util.*;
public class Baekjoon_1654 {
	static int K, N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		token = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(token.nextToken());
		N = Integer.parseInt(token.nextToken());
		
		long max = 0;
		int[] cables = new int[K];
		
		for(int k=0; k<K; k++) {
			token = new StringTokenizer(br.readLine());
			cables[k] = Integer.parseInt(token.nextToken());
			if(cables[k] > max) max = cables[k];
		}
		
		int cnt = 0;
		long mid=0;
		long low = 1;
		long high = max;
		
		//이분 탐색 중간 값을 기준으로 계속 범위를 줄여가며 탐색.
		while(low<=high) {
			cnt = 0;
			mid = (low+high)/2;
			
			for(int i=0; i<K; i++) {
				cnt += cables[i]/mid;
			}
			
			// 자른 케이블 수가 얻고자하는 수보다 많으면 길이가 짧기 때문에 왼쪽을 버린다.
			if(cnt >= N) low = mid + 1;
			// 자른 케이블 수가 얻고자하는 수보다 적으면 길이가 길기 때문에 오른쪽을 버린다.
			else high = mid - 1;
		}
		System.out.println(high);
	}
}
