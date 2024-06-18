import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];  // 스티커
            int[][] dp = new int[2][n+1];   // 최대 점수 배열
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k=1; k<=n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            // 스티커 선택시 해당 스티커의 왼/오/위/아래 스티커 사용할 수 없음.
            for (int j = 2; j <= n; j++) {
                // 해당 스티커 점수 + 제외 범위에 있는 두 스티커 중 큰 값
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
            }
            int ans = Math.max(dp[0][n], dp[1][n]);
            System.out.println(ans);
        }
    }
}