package ss_1027;

import java.util.ArrayDeque;
import java.util.Queue;
// 예시 2번과 3번
public class Solution_두큐합같게만들기 {
	public static int solution(int[] queue1, int[] queue2) {
		Queue<Integer> q1 = new ArrayDeque<>();
		Queue<Integer> q2 = new ArrayDeque<>();
		
		// long type 고려
		long sum1 = 0, sum2 = 0, total = 0;
		
		// 횟수
		int count = 0;
		
		// 원래대로 돌아가려면 필요한 횟수
		int org = (queue1.length + queue2.length) * 2;
		
		// 큐의 합
		for(int q:queue1) {
			q1.add(q);
			sum1 += q;
		}
		
		for(int q:queue2) {
			q2.add(q);
			sum2 += q;
		}
		
		total = sum1 + sum2;
		
		// 홀수면 종료
		if(total%2==1) return -1;
		
		System.out.println("org : " + q1 +" "+q2);
		
		// 양 쪽의 합이 같을 때까지 반복
		while(sum1 != sum2) {
			count += 1;
			
			// 큐의 합을 비교해서 큰 쪽에서 꺼내서 작은 쪽으로 더 해준다.
			if(sum1 < sum2) {
				int front = q2.poll();
				sum1 += front;
				sum2 -= front;
				
				q1.add(front);
			}
			else {
				int front = q1.poll();
				sum1 -= front;
				sum2 += front;
				
				q2.add(front);
			}
			System.out.println("move " + count + " : " + q1 +" "+q2);
			
			// 원래대로 돌아오면 나눌수 없음
			if(count == org) return -1;
		}

        return count;
    }
	
	public static void main(String[] args) {
		int[] q1 = {3, 2, 7, 2};	
		int[] q2 = {4, 6, 5, 1};
		
		solution(q1, q2);
		System.out.println();

		q1 = new int[] {1,2,1,2};	
		q2 = new int[] {1,10,1,2};
		
		solution(q1, q2);
		System.out.println();
		
		q1 = new int[] {1,1};	
		q2 = new int[] {1,5};
		
		solution(q1, q2);
		System.out.println();
		
		q1 = new int[] {3};	
		q2 = new int[] {5};
		
		solution(q1, q2);
		System.out.println();

		q1 = new int[] {2,1};	
		q2 = new int[] {5};
		
		solution(q1, q2);
		System.out.println();
		
	}
}
