import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int d = Integer.parseInt(br.readLine());
            int s = 0;
            while (s + (s*s) <= d) {
                s++;
            }
            System.out.println(s-1);
        }
    }
}