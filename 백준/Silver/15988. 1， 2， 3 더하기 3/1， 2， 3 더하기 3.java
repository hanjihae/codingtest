import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001];
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            dp[1] = 1;
            dp[2] = 2;  // 1+1, 2
            dp[3] = 4;    // 1+1+1, 1+2, 2+1, 3
            for (int j=4; j <= n; j++) {
                dp[j] = (dp[j-3] + dp[j-2] + dp[j-1]) % 1000000009;
            }
            System.out.println(dp[n]);
        }
    }
}
