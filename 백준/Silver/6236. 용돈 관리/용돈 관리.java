import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 하루에 k원 인출하고 하루 보낼 수 있으면 그대로 쓰고,
// 부족하면 남은 돈 입금하고 다시 k원 인출
// 정확히 m번 인출하기 위해 남은 금액이 그날 사용할 금액보다 많더라도 남은 금액은 다시 입금해 k원 인출 가능
// 인출할 k원의 최소 금액을 구해라.
public class Main {
    static int n, m;
    static int[] plan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        plan = new int[n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            plan[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, plan[i]);
        }
        System.out.println(binarySearch(max));
    }

    public static int binarySearch(int max) {
        int low = max;
        int high = 10_000 * 100_000;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWithdraw(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // k원씩 인출해서 m번 이내로 쓸 수 있는지
    private static boolean canWithdraw(int k) {
        int withdrawCnt = 1;
        int money = k;
        for (int i = 1; i <= n; i++) {
            money -= plan[i];   // 하루 쓸 돈 차감
            if (money < 0) {  // 남은 돈이 계획된 금액보다 적다면
                ++withdrawCnt;  // 인출 횟수 증가
                money = k - plan[i];    // 남은 돈 k원 갱신
            }
        }
        return withdrawCnt <= m;
    }
}
