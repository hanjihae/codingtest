import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 물품의 수
        int k = Integer.parseInt(st.nextToken());   // 준서가 버틸 수 있는 무게
        int[] weights = new int[n + 1];
        int[] values = new int[n + 1];
        for (int i=1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());   // 물건의 무게
            values[i] = Integer.parseInt(st.nextToken());   // 물건의 가치
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i=1; i <= n; i++) {
            for (int j=0; j <= k; j++) {
                // 현재 무게 j 이하인 경우, 물품 i를 선택/선택하지 않음 중 큰 값을 선택
                if (weights[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                } else {    // 현재 무게가 j 이상인 경우, 물품 i를 선택하지 않음
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
