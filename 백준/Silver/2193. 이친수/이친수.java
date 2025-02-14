import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 0과 1로만 이루어진 이진수 중 0으로 시작하지 않고, 1이 두번 연속 나타나지 않는 수 == 이친수
// N자리 이친수의 개수 출력
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1 || n == 2) {
            System.out.println(1);
        } else {
            long[] dp = new long[n + 1];
            dp[1] = 1;  // 1
            dp[2] = 1;    // 10
//            dp[3] = 2;    // 100, 101
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            System.out.println(dp[n]);
        }
    }
}
