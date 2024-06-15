import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] memo = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            memo[i] = 1;    // 각 위치에서 최소 부분 수열의 길이는 1로 초기화
        }
        for (int i = 1; i < n; i++) {   // i는 현재 위치
            for (int j = 0; j < i; j++) {   // j는 i 이전의 위치 탐색
                if (arr[i] < arr[j]) {  // 현재 위치의 값이 이전 위치의 값보다 작다면
                    memo[i] = Math.max(memo[i], memo[j] + 1);   // memo[i] 더 큰 값으로 갱신
                }
            }
        }
        int ans = Arrays.stream(memo).max().getAsInt();
        System.out.println(ans);
    }
}