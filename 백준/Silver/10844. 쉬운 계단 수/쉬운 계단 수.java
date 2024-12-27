import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = 1000000000;
        long[][] dp = new long[n + 1][10]; // 자릿수 길이 N, 숫자 0~9
        for (int i = 1; i < 10; i++) {  // 1~9는 1개의 계단 수를 가지므로 초기 설정
            dp[1][i] = 1;
        }
        for (int i=2; i <= n; i++) {
            // 여기서 i는 현재 자릿수 위치고, j는 그 자릿수에 해당하는 수
            for (int j=0; j < 10; j++) {
                if (j == 0) {   // 수가 0일 때, 이전 자릿수는 1만 가능
                    dp[i][j] = dp[i-1][1] % mod;
                } else if (j == 9) {    // 수가 9일 때, 이전 자릿수는 8만 가능
                    dp[i][j] = dp[i-1][8] % mod;
                } else {    // 이전 자릿수가 j-1이나 j+1만 가능하므로
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }
        long ans = 0;
        for (int i=0; i < 10; i++) {
            ans = (ans + dp[n][i]) % mod;
        }
        System.out.println(ans);
    }
}
