package algo_0805;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_2493 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		int N = Integer.parseInt(br.readLine());
		token = new StringTokenizer(br.readLine()," ");
		StringBuilder str = new StringBuilder();
		Stack<Integer> tower = new Stack<>();
		Stack<Integer> result = new Stack<>();
		
		for(int i=1; i<=N; i++) {
			int h = Integer.parseInt(token.nextToken());
			
				while(!tower.isEmpty()) {
					if(h < tower.peek()) {
						str.append(result.peek()+" ");
						break;
					}
					tower.pop();
					result.pop();
				}
			
			if(tower.isEmpty()) {
				str.append(0+" ");
			}
			tower.push(h);
			result.push(i);
		}
		
		System.out.println(str);
	}
}
