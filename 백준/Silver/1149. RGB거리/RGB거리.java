import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 집은 빨강, 초록, 파랑 중 하나로 칠해야만
// 1번집 색 != 2번집 색
// n번집 색 != n-1번집 색
// i번집 색!= i-1번집 색, i+1번집 색, i (2 <= i <= n-1)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] colors = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n][3];
        dp[0][0] = colors[0][0];    // 첫번째 집을 빨강으로 칠하는 비용
        dp[0][1] = colors[0][1];    // 초록
        dp[0][2] = colors[0][2];    // 파랑
        for (int i = 1; i < n; i++) {
            // 현재 집을 빨강으로 칠하는 경우 다음집은 초록 또는 파랑
            dp[i][0] = colors[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = colors[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = colors[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        int min = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        System.out.println(min);
    }
}
