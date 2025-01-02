import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] candies = new int[n + 1][m + 1];
        for (int i=1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j <= m; j++) {
                candies[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i=1; i <= n; i++) {
            for (int j=1; j <= m; j++) {
                // 현재 위치 방에 있는 사탕과 왼, 왼대각선, 위 방향에서 온다고 가정했을 때 그 중 최댓값과 더함
                dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1])) + candies[i][j];
            }
        }
        System.out.println(dp[n][m]);
    }
}