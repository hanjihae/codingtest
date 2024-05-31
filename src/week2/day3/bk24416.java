package week2.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bk24416 {
    static int cnt = 0;
    static int cnt2 = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fib(n);
        fibonacci(n);
        System.out.println(cnt + " " + cnt2);
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt++;  // 결과적으로 1을 더해서 구하는 수이므로
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

    public static int fibonacci(int n) {
        int[] f = new int[n+1];
        f[1] = 1;
        f[2] = 1;
        for (int i=3; i <= n; i++) {
            cnt2++; // for문 돌아간 횟수
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
}
