import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        while (n > 0) {
            if (n % 5 == 0) {   // 5로 나누어지는 경우
                ans += n / 5;
                break;
            } else {    // 나누어지지 않거나 3으로 나누어지는 경우
                n -= 3;
                ans++;
            }
            // n이 0보다 작다면 -1 출력
            if (n < 0) ans = -1;
        }
        System.out.println(ans);
    }
}