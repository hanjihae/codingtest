import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // m과 n의 최소공배수(LCM)
            int lcm = m * n / gcd(m, n);
            int ans = -1;

            // x부터 시작해서 m씩 증가하는 값 중에서 조건을 만족하는 값을 찾음
            for (int k = x; k <= lcm; k += m) {
                // k = x, x + m, x + 2m ...
                // 달력의 날짜는 1부터 시작하므로 -1 빼서 0부터 시작하는 인덱스로 변환
                // (k - 1) % n 후 다시 1부터 시작하도록 + 1
                // (k - 1) % n + 1 : 두번 째 달력에서 k가 몇 번째 날짜인지
                if ((k - 1) % n + 1 == y) {
                    ans = k;
                    break;
                }
            }
            System.out.println(ans);
        }
    }

    // 최대공약수(GCD)
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;   // b가 0이면 a가 최대공약수
        }
        return gcd(b, a % b);
    }
}
