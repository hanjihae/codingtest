import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;  // n=1일 때 상근이가 1개 가져가면 상근 승 == 1 (홀수)
        dp[2] = 2;  // n=2일 때 상근, 창영 각각 1개씩 가져가면 창영 승 == 2 (짝수)
        dp[3] = 1;  // n=3일 때 상근이가 3개 가져가면 상근 승 == 1 (홀수)
        // n=4일 때 상근이가 1개 Or 3개 가져가든 남은 게 각각 3개, 1개이므로 창영 승 == 2 (짝수)
        // n=5일 때 상근 1개 가져갔을 경우 - 4개가 남아 창영이 몇 개를 가져가든 상근 승
        //         상근 3개 가져갔을 경우 - 2개 남아 창영 1개 가져가면 상근 승
        for (int i=4; i <= n; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-3]) + 1;
        }
        if (dp[n] % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}