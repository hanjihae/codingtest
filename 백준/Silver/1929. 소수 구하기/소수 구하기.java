import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] isPrime = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        // 초기화
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        // 에라토스테네스의 체 알고리즘
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // n 이하 배수 모두 제거
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        // m부터 n까지 소수 출력
        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
