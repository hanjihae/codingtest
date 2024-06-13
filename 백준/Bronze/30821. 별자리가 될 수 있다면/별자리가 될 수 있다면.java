import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    // N개의 꼭짓점 중 별을 만들 수 있는 개수를 구해라 == NC5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int r = 5;
        // f(N)/(f(5)*f(N-5) == N!/5!(N-5)!
        BigInteger ans = f(BigInteger.valueOf(N)).divide(f(BigInteger.valueOf(r)).multiply(f(BigInteger.valueOf(N-r))));
        System.out.println(ans);
    }

    public static BigInteger f(BigInteger n) {
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {    // n == 0 || n == 1
            return BigInteger.ONE;
        }
//        int res = 1;
//        for (int i = 2; i <= n; i++) {
//            res *= i;
//        }
        return n.multiply(f(n.subtract(BigInteger.ONE)));
    }
}