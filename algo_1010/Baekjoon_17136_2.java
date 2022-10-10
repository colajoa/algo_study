package algo_1010;
import java.io.*;
import java.util.*;
public class Baekjoon_17136_2 {
	static int N = 10;
	static int ans;
	static int oneCnt;
	static int[][] map;
	static boolean[][] visited;
	static int cnt = 0;
	
	static void check(int one, int two, int three, int four, int five, int count, int oneCnt) {
		if(oneCnt == 0) {
			ans = Math.min(count, ans);
			return;
		}
		
		
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 0)	continue;
				if(five > 0) {
					if(checkSquare(r,c,5)) {
						//System.out.println("R : "+ r + " C : " + c + " five");
						cover(r,c,5);
						check(one, two, three, four, five-1, count+1, oneCnt-25);
						recover(r,c,5);
					}
				}
				
				if(four > 0) {
					if(checkSquare(r,c,4)) {
						//System.out.println("R : "+ r + " C : " + c + " four");
						cover(r,c,4);
						check(one, two, three, four-1, five, count+1, oneCnt-16);
						recover(r,c,4);
					}
				}
				
				if(three > 0) {
					if(checkSquare(r,c,3)) {
						//System.out.println("R : "+ r + " C : " + c + " three");
						cover(r,c,3);
						check(one, two, three-1, four, five, count+1, oneCnt-9);
						recover(r,c,3);
					}
				}
				
				if(two > 0) {
					if(checkSquare(r,c,2)) {
						//System.out.println("R : "+ r + " C : " + c + " two");
						cover(r,c,2);
						check(one, two-1, three, four, five, count+1, oneCnt-4);
						recover(r,c,2);
					}
				}
				
				if(one > 0) {
					if(checkSquare(r,c,1)) {
						cnt++;
						System.out.println("R : "+ r + " C : " + c + " one");
						cover(r,c,1);
						check(one-1, two, three, four, five, count+1, oneCnt-1);
						recover(r,c,1);
					}
				}
//				return;
			}
		}
	}
	
	static boolean checkFull() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void cover(int r, int c, int i) {
		for(int nr=r; nr<r+i; nr++) {
			for(int nc=c; nc<c+i; nc++) {
				map[nr][nc] = 0;
			}
		}
	}
	
	static void recover(int r, int c, int i) {
		for(int nr=r; nr<r+i; nr++) {
			for(int nc=c; nc<c+i; nc++) {
				map[nr][nc] = 1;
			}
		}
	}
	
	static boolean checkSquare(int r, int c, int i) {
		for(int nr=r; nr<r+i; nr++) {
			for(int nc=c; nc<c+i; nc++) {
				if(nr >= N || nc >= N) 	return false;
				if(map[nr][nc] == 0) 	return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		map = new int[N][N];
		visited = new boolean[N][N];
		ans = Integer.MAX_VALUE;
		
		for(int r=0; r<N; r++) {
			token = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(token.nextToken());
				if(map[r][c] == 1) oneCnt += 1;
			}
		}
		check(5,5,5,5,4,0, oneCnt);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		System.out.println(cnt);
	}
}
