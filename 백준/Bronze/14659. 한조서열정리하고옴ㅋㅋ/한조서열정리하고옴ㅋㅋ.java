import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            int cnt = 0;    // 처치 가능한 활잡이 수
            for (int j = i + 1; j < n; j++) {
               if (arr[i] > arr[j]) {   // 현재 봉우리가 다음 봉우리보다 높다면 카운트
                   cnt++;
               } else { // 현재 봉우리가 다음 봉우리보다 낮다면 종료
                   break;
               }
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}