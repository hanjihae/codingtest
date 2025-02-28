import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n가지 동전의 합이 k원이 되도록 하는 경우의 수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[k + 1];
        dp[0] = 1; // 0원을 만드는 방법 1가지 - 아무도 사용하지 않는 경우
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                // 현재 값 i를 만들 때 coin을 사용했을 경우의 수
                dp[i] += dp[i - coin];
            }
        }
        System.out.println(dp[k]);
    }
}
