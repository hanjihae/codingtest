import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퇴사 전까지 최대한 많은 상담 - 최대 수익 출력
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];   // 상담시간 T
        int[] p = new int[n + 1];   // 급여 P
        int[] dp = new int[n + 2];  // dp[i] = i일에 얻을 수 있는 최대 수익
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for(int i = 1; i <= n + 1; i++) {
            dp[i] = Math.max(dp[i], max);   // 오늘까지 얻을 수 있는 최대 수익
            // 상담을 진행하는 경우
            if (i <= n && i + t[i] <= n + 1) {
                // 상담종료일자 = 오늘 + 상담에 걸리는 시간
                // dp[상담종료일자] = 상담종료일자에 예정된 최대수익 vs 오늘자 최대수익 + 오늘자 상담비용
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
