import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        // Math.min 쓰려면 최댓값으로 dp 배열 초기화 해야함
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=1; i <= n; i++) {
            for (int j=1; j*j <= i; j++) {
                // i - (j*j) -> j*j가 되려면 제곱수가 갱신되어야 함.
                // 제곱수가 갱신될 때마다 +1
                dp[i] = Math.min(dp[i], dp[i - (j*j)] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
