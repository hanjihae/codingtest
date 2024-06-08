import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 선수 수
        int winner = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 2번의 런에서 받은 최고 점수
            int ans = Integer.MIN_VALUE;
            for (int j = 0; j < 2; j++) {
                int n = Integer.parseInt(st.nextToken());
                ans = Math.max(ans, n);
            }
            // 5번의 트릭연기에서 받은 상위 2개의 점수
            int[] arr = new int[5];
            for (int j = 0; j < 5; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);   // 오름차순 정렬
            // 뒤에서 1, 2번째 런 최고점수에 더하기
            ans += arr[arr.length - 1] + arr[arr.length - 2];
            // 우승자에 저장된 값보다 ans가 더 크다면 우승자는 ans
            if (ans >= winner) winner = ans;
        }
        System.out.println(winner);
    }
}