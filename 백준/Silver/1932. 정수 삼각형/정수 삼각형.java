import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        int[][] sum = new int[n + 1][n + 1];    // 최대 합 저장
        for(int i=1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i <= n; i++) { // 저장된 수 외에는 0
            for (int j=1; j <= n; j++) {    // 위층 2개의 수 중 더 큰 값 + 현재 값
                sum[i][j] = Math.max(sum[i-1][j-1], sum[i-1][j]) + arr[i][j];
            }
        }
        int ans = 0;
        for(int i=1; i <= n; i++) { // 경우의 수의 최댓값만 저장된 sum[n][i] 중 최댓값 저장
            ans = Math.max(ans, sum[n][i]);
        }
        System.out.println(ans);
    }
}
