import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            // n이 6보다 작을 때 예외 처리
            if (n < 6) {
                if (n == 1 || n == 2 || n == 3) {
                    System.out.println(1);
                } else if (n == 4 || n == 5) {
                    System.out.println(2);
                }
            } else {
                long[] p = new long[n + 1];
                p[1] = 1;
                p[2] = 1;
                p[3] = 1;
                p[4] = 2;
                p[5] = 2;
                for (int j = 6; j <= n; j++) {
                    p[j] = p[j-5] + p[j-1];
                }
                System.out.println(p[n]);
            }
        }
    }
}
