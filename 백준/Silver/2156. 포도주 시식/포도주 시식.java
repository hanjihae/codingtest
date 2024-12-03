import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n];
        for (int i=0; i < n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n];
        if (n == 1) {
            System.out.println(wines[0]);
            return;
        }
        dp[0] = wines[0];
        dp[1] = wines[0] + wines[1];
        if (n > 2) {    // (0,1) vs (0,2) vs (1,2) 중 큰 값
            dp[2] = Math.max(dp[1], Math.max(wines[0] + wines[2], wines[1] + wines[2]));
        }
        for (int i=3; i < n; i++) {
            // i 포기 vs i-1 없이 i 마시기 vs i-2없이 i, i-1 마시기 중 큰값
            dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + wines[i]), dp[i - 3] + wines[i - 1] + wines[i]);
        }
        System.out.println(dp[n - 1]);
    }
}
