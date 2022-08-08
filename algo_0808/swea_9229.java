package algo_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_9229 {
	/*static void pack(int N, int M, int[] snacks) {
		for(int i=0; i<M; i++) {
			
		}
	}*/
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			token = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			
			token = new StringTokenizer(br.readLine(), " ");
			int[] snacks = new int[N];
			for(int i=0; i<N; i++) {
				snacks[i] = Integer.parseInt(token.nextToken());
			}
			
			//pack(M, snacks);
			int max = 0;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N;j++) {
					int sum = snacks[i] + snacks[j];
					if(max < sum && sum <= M) max = sum;
				}
			}
            if(max > 0 && max <= M) {
                    System.out.println("#"+t+" "+max);
                }
            else {
				System.out.println("#"+t+" -1");
            }
        }
	}
}

