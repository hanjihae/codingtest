import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;
    static int cnt2 = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = fib(n);
        int b = fibonacci(n);
        System.out.println(cnt + " " + cnt2);
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt++;
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

    public static int fibonacci(int n) {
        int[] f = new int[n+1];
        if (n == 1 || n == 2) {
            cnt2++;
            return 1;
        }
        for (int i=3; i <= n; i++) {
            cnt2++;
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
