package ss_1006;

import java.io.*;
import java.util.*;

// 1, 2, 3, 4 / 1 : 시계 -1 : 반시계
public class swea_4013 {
	static int K;
	static List<Integer>[] magnet;

	static void order(int num, int rot) {
		checkLeft(num-1, rot * -1);
		checkRight(num+1, rot * -1);
		turn(num, rot);
	}
	
	// 왼쪽 검사
	static void checkLeft(int num, int rot) {
		// 범위를 벗어나거나 현재위치 왼쪽과 이전위치 오른쪽이 같으면 리턴
		if(num < 1 || magnet[num].get(2) == magnet[num+1].get(6)) return;
		// 다음 검사
		checkLeft(num-1, rot*-1);
		// 회전
		turn(num, rot);
	}
	
	// 오른쪽 검사
	static void checkRight(int num, int rot) {
		// 범위를 벗어나거나 현재위치 오른쪽과 이전위치 오른쪽이 같으면 리턴
		if(num > 4 || magnet[num].get(6) == magnet[num-1].get(2)) return;
		// 다음 검사
		checkRight(num+1, rot*-1);
		// 회전
		turn(num, rot);
	}
	
	static void turn(int num, int rot) {
		// 시계 끝자리가 맨 앞으로 
		if(rot == 1) magnet[num].add(0,magnet[num].remove(7));
		// 반시계 맨 앞이 끝자리로
		if(rot == -1) magnet[num].add(7,magnet[num].remove(0));
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int ans = 0;
			K = Integer.parseInt(br.readLine());
			magnet = new ArrayList[5];
			for(int i=1; i<5; i++) {
				magnet[i] = new ArrayList<>();
				token = new StringTokenizer(br.readLine());
				
				for(int n=0; n<8; n++) {
					magnet[i].add(Integer.parseInt(token.nextToken()));
				}
			}
			
			for(int k=0; k<K; k++) {
				token = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(token.nextToken());
				int rot = Integer.parseInt(token.nextToken());
				
				order(num, rot);
				
			}
			ans = (magnet[1].get(0) == 1 ? 1 :0 ) + (magnet[2].get(0) == 1 ? 2 :0 ) + (magnet[3].get(0) == 1 ? 4 :0 ) + (magnet[4].get(0) == 1 ? 8 :0 );
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
