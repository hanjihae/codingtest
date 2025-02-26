import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 산성용액 1~1,000,000,000
// 알칼리성 용액 -1~-1,000,000,000
// 같은 양의 두 용액을 혼합한 용액 = 혼합에 사용된 각 용액의 특성값의 합
// 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액 출력
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // n = 2 ~ 100,000
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;   // 알칼리
        int right = n - 1;  // 산성
        int minDif = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < minDif) {
                minDif = Math.abs(sum);
                ans1 = arr[left];
                ans2 = arr[right];
            }
            if (sum > 0) {  // 0보다 크면 right(산성) 줄이고, 작으면 left(알칼리) 증가
                right--;
            } else {
                left++;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}
