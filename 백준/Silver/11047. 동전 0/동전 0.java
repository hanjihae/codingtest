import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;    // 필요한 동전의 개수 저장
        for (int i = n-1; i >= 0; i--) {    // 큰 동전부터 사용하기 위해 배열 끝에서부터 반복
            if (coins[i] > k) continue; // 현재 동전이 k원보다 크다면 패스
            cnt += k/coins[i];  // 현재 동전으로 만들 수 있는 최대 개수 더함
            k = k % coins[i];   // 남은 금액 갱신
        }
        System.out.println(cnt);
    }
}