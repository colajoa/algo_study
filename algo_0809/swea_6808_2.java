package algo_0809;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea_6808_2 {
	
	static void per(int cnt, int kyuScore, int inScore) {

		if(cnt == 9) {
			if(kyuScore > inScore)
				win += 1;
			else if(inScore > kyuScore)
				lose += 1;
		}
		
		for(int i=0; i<9 ; i++) {
			
			if(isSelected[i]) continue; 
			
			isSelected[i] = true;
			if(kyu.get(cnt) > in.get(i)) {
				
				per(cnt+1, kyuScore+ kyu.get(cnt) + in.get(i), inScore);
			}
			else if (kyu.get(cnt) < in.get(i)) {
				per(cnt+1, kyuScore, inScore+ kyu.get(cnt) + in.get(i));
			}
			isSelected[i] = false;
		}

	}
	
	static List<Integer> kyu = null;
	static List<Integer> in = null;
	
	static int win, lose;
	static StringBuilder str = new StringBuilder();
	static boolean isSelected[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		
		
		for(int t=1; t<=tc; t++) {
			kyu = new ArrayList<>();
			in = new ArrayList<>();
			isSelected = new boolean[9];
			for(int i=0; i<9; i++) {
				kyu.add(sc.nextInt());
			}
			
			for(int i=1; i<19; i++) {
				in.add(i);
			}
			in.removeAll(kyu);
			win = 0;
			lose = 0;
			per(0,0,0);
			str.append("#"+t+" "+win+" "+lose+"\n");
		}
		System.out.println(str);
	}
}
