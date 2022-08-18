package algo_0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1992 {
	static int[][] video;
	static StringBuilder str = new StringBuilder();
	static void divide(int r, int c, int size) {
		
		// 전체가 같은 색이면 좌상단 색 결과에 추가
		if (check(r, c, size)) {
			str.append(video[r][c]);
			return;
		}
		
		// 탐색할 변의 길이로 줄이기
		size = size/2;
		
		// 시작 괄호
		str.append("(");
		
		divide(r, c, size);
		divide(r, c + size, size);
		divide(r + size, c, size);
		divide(r + size, c + size, size);
		
		//끝 괄호
		str.append(")");
	}
	
	// 전체가 같은 색인지 검사 
	static boolean check(int r, int c, int size) {
		int chk = video[r][c];
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(video[i][j] != chk) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				video[i][j] = s.charAt(j) - '0';
			}
		}

		divide(0, 0, N);
		System.out.println(str);
	}
}
