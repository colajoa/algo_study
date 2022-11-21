package ss_1121;

public class programmers_야근지수 {

    static public long solution(int n, int[] works) {
        long answer = 0;
        int[] nums = new int[50001];
        int size = works.length;
        for (int i = 0; i < size; i++) {
            nums[works[i]] += 1;
        }

        for (int i = 50000; i > 0; i--) {
            if (n == 0)
                break;
            if (nums[i] != 0 && (n - nums[i]) >= 0) {
                nums[i - 1] += nums[i];
                n -= nums[i];
                nums[i] -= nums[i];

            } else if (nums[i] != 0 && (n - nums[i] < 0)) {
                nums[i - 1] += n;
                nums[i] -= n;
                n -= n;
            }

        }

        for (int i = 1; i < 50000; i++) {
            if (nums[i] > 0) {
                for (int c = 0; c < nums[i]; c++) {
                    answer += i * i;
                }
            }
        }
        return answer;
    }

}
