package ss_1114;

import java.util.*;

public class Solution_숫자게임 {
	static int solution(int[] A, int[] B) {
		int answer = 0;
		List<Integer> aTeam = new ArrayList<>();
		List<Integer> bTeam = new ArrayList<>();
		int length = A.length;
		int idx = 0;
		// boolean[] selected = new boolean[length];
		
		for(int i=0; i<length; i++) {
			aTeam.add(A[i]);
			bTeam.add(B[i]);
		}
		
		aTeam.sort((o1, o2)-> o2-o1);
		bTeam.sort((o1, o2)-> o2-o1);
		
		for(int i=0; i<length; i++) {
			if(aTeam.get(i) < bTeam.get(idx)) {
				answer += 1;
				idx += 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] A = {5,1,3,7};
		int[] B = {2,2,6,8};
		int ans = solution(A, B);
		System.out.println(ans);
	}
}
