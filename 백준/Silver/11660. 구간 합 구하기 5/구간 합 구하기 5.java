import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 표의 크기
        int m = Integer.parseInt(st.nextToken());   // 합을 구해야 하는 횟수
        int[][] arr = new int[n][n];
        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                // ○ ●
                // ● ☓
                // => (● + ●) - ○ = ☓
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + arr[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int sum = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
