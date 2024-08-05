import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger sum = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        String str = String.valueOf(sum);
        int cnt = 0;
        for (int i=str.length()-1; i >= 0; i--) {
            if (str.charAt(i) == '0') {
                cnt++;
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }
}