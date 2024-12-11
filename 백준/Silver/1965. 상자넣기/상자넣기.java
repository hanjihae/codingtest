import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] boxes = new int[n];
        for (int i=0; i < n; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 각 상자는 자기 자신만으로 LIS를 구성할 수 있기 때문에
        for (int i=1; i < n; i++) {
            for (int j=0; j < i; j++) { // 자신보다 앞에 있는 상자들과 각각 크기 비교
                if (boxes[j] < boxes[i]) {  // 자신이 더 크다면
                    // 이전 박스가 먹은 상자들 수에 1 더한 값과 비교해서 큰 값 저장
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int cnt : dp) {
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}