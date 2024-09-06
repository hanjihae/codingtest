import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(n == 1) {
            System.out.println(arr[0]);
            return;
        }
        int[] dp = new int[n];  // 현재 계단까지의 최고 점수
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        if (n > 2) {
            dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);
            for(int i=3; i < n; i++) {
                // 현재 계단까지의 최고 점수 (2개 계단 vs 3개 계단) + 현재 계단
                dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
            }
        }
        System.out.println(dp[n-1]);
    }
}
