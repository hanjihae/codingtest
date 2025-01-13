import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 카드 N개 포함된 카드팩 N가지
// 카드 i개 포함된 카드팩 가격 Pi원
// N개 카드를 구매하기 위해 민규가 지불해야 하는 금액 최댓값
// N개보다 많은 개수 카드 사고 나머지 카드 버리는 건 불가능

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 민규가 구매하려는 카드 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] price = new int[n + 1];
        for (int i=1; i <= n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1];  // 카드 i개 구매시 지불할 수 있는 금액의 최댓값
        for (int i=1; i <= n; i++) {
            for (int j=1; j <= i; j++) {
                // 카드 i개 가격 vs 이미 계산된 값 + 카드 j개 가격
                dp[i] = Math.max(dp[i], dp[i - j] + price[j]);
            }
        }
        System.out.println(dp[n]);

    }
}
