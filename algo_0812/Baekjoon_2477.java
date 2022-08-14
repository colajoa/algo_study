package algo_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//파이썬처럼%6하면 안됨. 인덱스 -1이 없기 때문에 오류발생
public class Baekjoon_2477 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;

		int[][] farm = new int[6][2];
		int K = Integer.parseInt(br.readLine());
		int widthIndex = 0;
		int heightIndex = 0;

		int height = 0;
		int width = 0;

		for (int i = 0; i < 6; i++) {
			token = new StringTokenizer(br.readLine(), " ");
			farm[i][0] = Integer.parseInt(token.nextToken());
			farm[i][1] = Integer.parseInt(token.nextToken());
		}

		for (int i = 0; i < 6; i++) {
			if (farm[i][0] < 3) {
				if (farm[i][1] > width) {
					width = farm[i][1];
					heightIndex = i;
				}
			}

			else {
				if (farm[i][1] > height) {
					height = farm[i][1];
					widthIndex = i;
				}
			}
		}
		int wf;
		int wt;
		int hf;
		int ht;
		int s = 0;
		if(widthIndex-1 == -1) wf = 5;
		else wf = widthIndex-1;
		
		if(widthIndex+1 == 6) wt = 0;
		else wt = widthIndex+1;
		
		if(heightIndex-1 == -1) hf = 5;
		else hf = heightIndex-1;
			
		if(heightIndex+1 == 6) ht = 0;
		else ht = heightIndex+1;
		
		s = width * height -(Math.abs(farm[wf][1]-farm[wt][1])*Math.abs(farm[hf][1]-farm[ht][1]));
		
		System.out.println(s*K);
	}
}
