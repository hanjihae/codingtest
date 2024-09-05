import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        if (x == 1) {
            System.out.println(0);
        } else if (x == 2 || x == 3) {
            System.out.println(1);
        } else {
            int[] dp = new int[x + 1];
            dp[2] = 1;
            dp[3] = 1;
            for (int i=2; i < x + 1; i++) {
                dp[i] = dp[i-1] + 1;    // -1 연산 수행
                // -1 vs 2나 3으로 떨어졌을 때 해야하는 연산 중 작은 값 저장
                if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i], dp[i/2] + 1);   // 2로 나눴으니 연산횟수 + 1
                }
                if (i % 3 == 0) {
                    dp[i] = Math.min(dp[i], dp[i/3] + 1);   // 3로 나눴으니 연산횟수 + 1
                }
            }
            System.out.println(dp[x]);
        }
    }
}