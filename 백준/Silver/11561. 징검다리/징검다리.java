import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine());
            long start = 0;
            long end = (long)Math.sqrt(2*n-1);
            long ans = 0;
            while (start <= end) {
                long mid = (start + end) / 2;
                long sum = mid * (mid + 1) / 2;
                if (sum <= n) {
                    ans = Math.max(mid, ans);
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            System.out.println(ans);
        }
    }
}