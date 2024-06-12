import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger k = new BigInteger(st.nextToken());
        BigInteger l = new BigInteger(st.nextToken());
        int ans = 0;
        for (int i = 2; i < l.intValue(); i++) {
            // k % i == 0
            if ((k.remainder(BigInteger.valueOf(i))).compareTo(BigInteger.ZERO) == 0) {
                ans = i;
                break;
            }
        }
        System.out.println(ans > 0 ? "BAD " + ans : "GOOD");
    }
}