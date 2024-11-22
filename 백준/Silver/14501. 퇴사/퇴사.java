import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Cs {
        int t;
        int p;

        public Cs(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Cs[] consult = new Cs[n + 1];
        StringTokenizer st;
        for (int i=1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            consult[i] = new Cs(t, p);
        }
        int[] dp = new int[n + 2];  // 퇴사 당일까지 포함
        for (int i=n; i >= 1; i--) {    // 역순으로 첫째날에 최대 수익 저장
            int time = consult[i].t;    // 상담 기간
            int pay = consult[i].p;     // 상담 수익
            if (i + time <= n + 1) {    // 상담할 수 있는 경우
                dp[i] = Math.max(dp[i + 1], pay + dp[i + time]);
            } else {    // 상담할 수 없는 경우
                dp[i] = dp[i + 1];  // 다음날 수익과 같다
            }
        }
        System.out.println(dp[1]);
    }
}
