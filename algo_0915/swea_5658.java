package ss_0908;

import java.io.*;
import java.util.*;
 
// 상자를 돌린다. 큐브를 돌린다.
public class swea_5658 {
    // 입력 길이, K번째 수
    static int N, K;
    // 박스 윗부분, 박스 아랫부분 큐
    static List<String> upBox = new ArrayList<>();
    static List<String> downBox = new ArrayList<>();
    // 그냥 리스트나 배열 받아서 중복체크해도 될거 같다.
    // Set은 중복을 허용하지 않고 TreeSet은 내림차순으로 정렬해준다.
    static Set<Integer> nums = new TreeSet<>((o1,o2) -> -Integer.compare(o1, o2));
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();
         
        // 테스트 케이스 갯수
        int T = Integer.parseInt(br.readLine());
         
        for(int t=1; t<=T; t++) {
            token = new StringTokenizer(br.readLine()," ");
            // 숫자 입력 길이
            N = Integer.parseInt(token.nextToken());
            // 찾을 순서 
            K = Integer.parseInt(token.nextToken());
             
            // N개의 16진수 
            String[] str = br.readLine().split("");
             
            // 입력 받은 숫자 반으로 나눠서 처음부터 반만큼 upBox에 저장
            for(int i=0; i < N/2; i++) {
                 upBox.add(str[i]);
            }
             
            // 남은 반은 뒤에서부터 downBox에 저장
            for(int i=N-1; i>=N/2; i--) {
                downBox.add(str[i]);
            }
            //System.out.println(upBox);
            //System.out.println(downBox);
             
            while(true) {
                int len = 0;
                String hex = "";
                int flag = 0;
                for(int i= 0; i < N/2; i++) {
                    hex += upBox.get(i);
                    len += 1;
                    if(len == N/4) {
                        int deci = Integer.parseInt(hex, 16);
                        if(nums.contains(deci)) {
                            flag += 1;
                        }
                        nums.add(deci);
                        hex = "";
                        len = 0;
                    }
                }
                 
                for(int i= N/2 - 1; i >= 0; i--) {
                    hex += downBox.get(i);
                    len += 1;
                    if(len == N/4) {
                        int deci = Integer.parseInt(hex, 16);
                        if(nums.contains(deci)) {
                            flag += 1;
                        }
                        nums.add(deci);
                        hex = "";
                        len = 0;
                    }
                }
                 
                if(flag == 4) break;
                // 위에서 꺼내서 밑으로 넣을 원소
                String upTmp = upBox.remove(upBox.size()-1);
                // 밑에서 꺼내서 위로 넣을 원소
                String downTmp = downBox.remove(0);
                 
                upBox.add(0, downTmp);
                downBox.add(upTmp);
 
            }
            //System.out.println(nums);
            int ans = 0;
            int cnt = 0;
            for(Integer num : nums) {
                cnt+=1;
                if(cnt == K) {
                    ans = num;
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
            upBox.clear();
            downBox.clear();
            nums.clear();
        }
        System.out.println(sb);
    }
}