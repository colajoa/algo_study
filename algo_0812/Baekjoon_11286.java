package algo_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

//Priority Queue를 사용하자
public class Baekjoon_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder();
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}
				return Math.abs(o1) - Math.abs(o2);

			}
		});

		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				q.add(num);
			}

			else {
				if (q.isEmpty()) {
					str.append("0\n");
					continue;
				} else {
					str.append(q.poll()+"\n");
				}
			}
		}
		System.out.println(str);
	}
}
