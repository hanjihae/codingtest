import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];  // 연산횟수 저장
        int[] path = new int[n + 1];
        dp[1] = 0;  // 1은 1이므로 연산 필요없음
        for (int i=2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;  // 기본적으로 1을 빼는 경우 연산 횟수
            path[i] = i - 1;    // 연산 전 수를 기록
            // 2로 나누는 경우
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;
            }
            // 3으로 나누는 경우
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }
        }
        System.out.println(dp[n]);
        ArrayList<Integer> list = new ArrayList<>();
        while(n > 0) {  // n이 1이 될 때까지
            list.add(n);    // 현재 수를 리스트에 추가
            n = path[n];    // 이전 수로 이동
        }
        for (int i=0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
