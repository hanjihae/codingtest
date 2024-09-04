import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] zero;
    public static int[] one;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < t; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                sb.append("1 0\n");
            } else if (input == 1) {
                sb.append("0 1\n");
            } else {
                fibonacci(input);
                sb.append(zero[input] + " " + one[input] + "\n");
            }
        }
        System.out.println(sb);
    }

    public static void fibonacci(int n) {
        zero = new int[n + 1];
        one = new int[n + 1];
        zero[0] = 1;
        one[1] = 1;
        for (int i=2; i <= n; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
        }
    }
}
