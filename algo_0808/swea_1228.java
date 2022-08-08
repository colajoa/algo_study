package algo_0808;

import java.io.*;
import java.util.*;
public class swea_1228 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder str = new StringBuilder();
		
		for(int t=1; t<=10; t++) {
			LinkedList<Integer> list = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			token = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(token.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			token = new StringTokenizer(br.readLine(), "I ");
			for(int i=0; i<M; i++) {
				int start = Integer.parseInt(token.nextToken());
				int count = Integer.parseInt(token.nextToken());
				for(int j=0; j<count; j++) {
					list.add(start+j,Integer.parseInt(token.nextToken()));
				}
			}
			str.append("#"+t+" ");
			for(int i=0; i<10; i++) {
				str.append(list.get(i)+" ");
			}
			str.append("\n");
		}
		System.out.println(str);
	}
}
