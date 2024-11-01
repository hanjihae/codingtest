import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dp[1] != dp[2]
// dp[n] != dp[n-1]
// dp[i] != dp[i-1] && dp[i] != dp[i+1]
// n개의 집을 칠하는 비용, 차례대로 빨강, 초록, 파랑

public class Main {
    static int n;
    static int[][] budget;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        budget = new int[n][3];
        dp = new int[n][3];
        for (int i=0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j < 3; j++) {
                budget[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = budget[0][0];    // 빨강
        dp[0][1] = budget[0][1];    // 초록
        dp[0][2] = budget[0][2];    // 파랑
        for (int i=1; i < n; i++) {
            dp[i][0] = budget[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = budget[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = budget[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        int min = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        System.out.println(min);
    }
}
