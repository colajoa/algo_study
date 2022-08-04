package ssafy_study;

import java.util.ArrayList;
import java.util.List;

public class Baekjoon_4673 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= 10000; i++) {
			list.add(i);
		}
		for (int i = 1; i <= 10000; i++) {
			int sum = 0;
			sum += i;
			char[] ch = Integer.toString(i).toCharArray();
			for (int j = 0; j < ch.length; j++) {
				sum += (int)ch[j];
			}
			if(list.contains(sum)) {
				list.set(sum,0);
			}
		}
		for(int i=1; i<list.size(); i++) {
			if(list.get(i)!=0)
			System.out.println(list.get(i));
		}
	}
}
