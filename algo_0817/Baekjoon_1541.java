package algo_0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_1541{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer token = null;
		String input = br.readLine();
		String[] str = input.split("-");
		int ans = 0;
		//System.out.println(Arrays.toString(str));
		for (int i = 0; i < str.length; i++) {
			int sum = 0;
			// +는 메타문자(특별한 의미를 담고 있는 문자) +를 split에서 사용할 경우 \\+ 또는 [+]같은 정규식으로 입력해준다.
			String[] tmp = str[i].split("\\+");
			//System.out.println(Arrays.toString(tmp));
			for (int j = 0; j < tmp.length; j++) {
				sum += Integer.parseInt(tmp[j]);
			}
			if (i == 0) {
				ans += sum;
			} else {
				ans -= sum;
			}
		}
		System.out.println(ans);
	}
}

