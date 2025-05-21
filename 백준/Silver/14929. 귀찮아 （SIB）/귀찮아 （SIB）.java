import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// arr[0] * arr[1] + arr[0] * arr[2] + arr[1] * arr[2] = -5
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum += arr[i];
        }
        long res = 0;
        // i = 0, sum = 2, sum -= 1, res += 1 * 1 = 1
        // i = 1, sum = 1, sum -= -2, res += -2 * 3 = -6
        for (int i = 0; i < n - 1; i++) {
            sum -= arr[i];
            res += arr[i] * sum;
        }
        System.out.println(res);
    }
}
