import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 지방의 수
        int low = 0;
        int high = Integer.MIN_VALUE;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            // 예산요청 중 가장 큰 값
            high = Math.max(arr[i], high);
        }
        int m = Integer.parseInt(br.readLine());
        while(low <= high) {
            // 상한액
            int mid = (low + high) / 2;
            long budget = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) { // 상한액보다 요청된 예산이 크다면
                    budget += mid;  // 총액에 상한액 저장
                } else {    // 상한액보다 요청된 예산이 작거나 같다면
                    budget += arr[i];   // 총액에 요청된 예산 저장
                }
            }
            if (budget <= m) {  // 총액이 총 예산보다 작거나 같다면
                low = mid + 1;
            } else {    // 총액이 총 예산보다 크다면
                high = mid - 1;
            }
        }
        System.out.println(high);
    }
}