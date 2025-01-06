import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m, n;
    static int[] cookies;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());   // 조카 수
        n = Integer.parseInt(st.nextToken());   // 과자 수
        cookies = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for (int i=0; i < n; i++) {
            cookies[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, cookies[i]);
        }
        System.out.println(binarySearch(max));
    }

    static int binarySearch(int max) {
        int start = 1;
        int end = max;
        int ans = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            for (int cookie : cookies) {
                cnt += cookie / mid;
            }
            if (cnt >= m) { // 나눠줄 수 있는 쿠키 수가 m개 이상이라면
                ans = mid;
                start = mid + 1;    // 더 큰 길이 탐색
            } else {    // 나눠줄 수 있는 쿠키 수가 m개 미만이라면
                end = mid - 1;  // 더 작은 길이 탐색
            }
        }
        return ans;
    }
}
