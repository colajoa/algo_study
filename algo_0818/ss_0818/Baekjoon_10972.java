package ss_0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// boolean 반환
public class Baekjoon_10972 {
	public static boolean nextPermutation(int[] nums) {
		int len = nums.length;
		int i = len - 1;
		
		// 끝에서부터 역순으로 앞 숫자가 큰것이 있는 지 검사.
		while (i > 0 && nums[i - 1] >= nums[i])
			i--;
		// 없다면 마지막 순열이므로 종료
		if (i == 0)
			return false;

		// 앞 숫자가 큰것이 있다면 끝에서부터 큰 숫자보다 작은 것을 찾는다.
		int j = len - 1;
		while (nums[i - 1] >= nums[j])
			j--;

		// i-1과 j교환
		swap(nums, i - 1, j);
		
		// i부터 끝까지 오름차순 정렬
		int k = len - 1;
		while (i < k)
			swap(nums, i++, k--);
		return true;
	}

	static void swap(int nums[], int from, int to) {
		int tmp = nums[from];
		nums[from] = nums[to];
		nums[to] = tmp;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;

		int N = Integer.parseInt(br.readLine());
		token = new StringTokenizer(br.readLine(), " ");

		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(token.nextToken());
		}

		if (nextPermutation(nums)) {
			for (int i = 0; i < N; i++) {
				System.out.print(nums[i] + " ");
			}
		} else {
			System.out.println(-1);
		}
	}
}
