import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        int[] dp = new int[max + 1];
        dp[1] = 1;
        dp[2] = 2;  // 1+1, 2
        dp[3] = 4; // 1+1+1, 2+1, 1+2, 3
        for (int i=4; i <= max; i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < n; i++) {
            sb.append(dp[arr[i]]+"\n");
        }
        System.out.println(sb);
    }
}
