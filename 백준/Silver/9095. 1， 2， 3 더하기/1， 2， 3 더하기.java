import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            // dp[n]은 정수 n을 1, 2, 3의 합으로 나타낼 수 있는 경우
            int[] dp = new int[11];
            dp[1] = 1;  // 1
            dp[2] = 2;  // 1+1, 2
            dp[3] = 4;  // 1+1+1, 1+2, 2+1, 3
            // 즉, dp[4] = dp[1] + dp[2]+ dp[3]과 동일
            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            System.out.println(dp[n]);
        }
    }
}