import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][][] dp = new int[n][n][3];
        StringTokenizer st;
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][1][0] = 1;    // 초기 상태 0, 1 위치에 가로 파이프 존재
        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                if (arr[i][j] == 1) continue;   // 벽인 경우 건너뛰기
                // 가로 방향
                if (j - 1 >= 0) {
                    dp[i][j][0] += dp[i][j-1][0];   // 가로 > 가로
                    dp[i][j][0] += dp[i][j-1][2];   // 대각선 > 가로
                }
                // 세로 방향
                if (i - 1 >= 0) {
                    dp[i][j][1] += dp[i-1][j][1];   // 세로 > 세로
                    dp[i][j][1] += dp[i-1][j][2];   // 대각선 > 세로
                }
                // 대각선 방향
                if (i - 1 >= 0 && j - 1 >= 0) {
                    // 대각선 이동이 가능한 경우
                    if (arr[i-1][j] != 1 && arr[i][j-1] != 1) {
                        dp[i][j][2] += dp[i-1][j-1][0]; // 가로 > 대각선
                        dp[i][j][2] += dp[i-1][j-1][1]; // 세로 > 대각선
                        dp[i][j][2] += dp[i-1][j-1][2]; // 대각선 > 대각선
                    }
                }
            }
        }
        // 마지막 위치 n-1, n-1에 도달하는 모든 경우의 수의 합
        int ans = dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2];
        System.out.println(ans);
    }
}