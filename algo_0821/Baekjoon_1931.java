package algo_0821;

import java.io.*;
import java.util.*;

public class Baekjoon_1931 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		int N = Integer.parseInt(br.readLine());
		
		List<int[]> room = new ArrayList<>();
		
		for(int i = 0; i<N; i++) {
			token = new StringTokenizer(br.readLine()," ");
			room.add(new int[] {Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())});
		}
		
		Collections.sort(room, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
			}
		});
		int cnt = 1;
		int tmp = room.get(0)[1];
		for(int i=1, size = room.size(); i<size; i++) {
			if(tmp <= room.get(i)[0]) {
				tmp = room.get(i)[1];
				cnt += 1;
			}
		}
		/*for(int[] r: room)
		System.out.println(Arrays.toString(r));*/
		System.out.println(cnt);
	}
}
