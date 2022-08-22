package algo_0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2954 {

		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// 모음 확인을 위한 배열
			String[] mo = new String[] {"a","e","i","o","u"};
			String[] mos = new String[] {"apa", "epe", "ipi", "opo","upu"};
			String str = br.readLine();
			for(int i=0; i<5; i++) {
				str = str.replaceAll(mos[i], mo[i]);
			}
			System.out.println(str);
		}
}
