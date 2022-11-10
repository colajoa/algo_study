package ss_1110;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_9019 {
	static int org;
	static int convert;
	static boolean[] visited;
	static String[] command = { "D", "S", "L", "R" };
	static StringBuilder ans = new StringBuilder();

	static class Number {
		int num;
		String cmd;

		public Number(int num, String cmd) {
			this.num = num;
			this.cmd = cmd;
		}
	}

	static void bfs() {
		Queue<Number> q = new ArrayDeque<>();
		q.add(new Number(org, ""));
		visited[org] = true;
		while (!q.isEmpty()) {
			Number now = q.poll();
			int num = now.num;
			String cmd = now.cmd;
			if (num == convert) {
				ans.append(cmd).append("\n");
				q.clear();
				break;
			}
		
			for (int i = 0; i < 4; i++) {
				int changedNum = command(num, command[i]);
				//System.out.println(changedNum);
				if (changedNum >= 0 && changedNum < 10000 && !visited[changedNum]) {

					visited[changedNum] = true;
					q.add(new Number(changedNum, cmd + command[i]));
				}
			}
		}
	}

	static int command(int num, String command) {
		switch (command) {

		case "D":
			num = (num * 2) % 10000;
			//System.out.println(num);
			break;
		case "S":
			if (num >= 1)
				num -= 1;
			else if(num==0) num = 9999;
			//System.out.println(num);
			break;
		case "L":
			int head = num/1000;
			int tmp1 = num - head*1000;
			num = tmp1*10 + head;
			//System.out.println(num);
			break;
		case "R":
			int tail = num%10;
			int tmp2 = num/10;
			num = tail*1000 + tmp2;
			//System.out.println(num);
			break;
		}

		return num;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			visited = new boolean[10000];
			org = sc.nextInt();
			convert = sc.nextInt();

			bfs();
		}
		System.out.println(ans);
	}
}
